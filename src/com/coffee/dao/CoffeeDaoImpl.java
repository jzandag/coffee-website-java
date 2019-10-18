package com.coffee.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.base.BaseDaoHibernate;
import com.coffee.enums.CoffeeStatusEnum;
import com.coffee.model.CoffeeRequest;
import com.coffee.model.CoffeeRequestDTO;
import com.coffee.model.Configuration;
import com.coffee.model.Notification;
import com.coffee.model.Users;
import com.coffee.util.InventoryUtility;
			
@Repository("coffeeDao")
public class CoffeeDaoImpl extends BaseDaoHibernate implements CoffeeDao  {

	@Autowired
	public CoffeeDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	
	public static Integer brew = 1;
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Users> validateUser(Users user) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from users ");
		sql.append("where username = :first ");
		sql.append("or email = :first ");
		sql.append("and password = :password");
		
		final String userQuery = sql.toString();
		
		SQLQuery query = getSession().createSQLQuery(userQuery);
		
		if(StringUtils.isNotEmpty(user.getUsername())) {
			query.setParameter("first",user.getUsername());
		}
		
		if(StringUtils.isNotEmpty(user.getPassword())) {
			query.setParameter("password",user.getPassword());
		}
		//query.setResultTransformer(Transformers.aliasToBean(Users.class));
		
		List<Users> result = query.list();
		
		if(result.size() > 0)
			return result;
		return null;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean checkIfQueue(Users user) {
		StringBuffer sql = new StringBuffer("SELECT * from coffee_request ");
		sql.append("WHERE status = 0 and userID = :id");
		final String userQuery = sql.toString();
		
		SQLQuery query = getSession().createSQLQuery(userQuery);
		if(!InventoryUtility.isNull(user.getId())) {
			query.setParameter("id",user.getId());
		}
		List<CoffeeRequest> result = query.list();
		return result.size() > 0 ? true : false;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public String checkLatestSched(Users user) throws IOException{
		
		String output = "";
		final String getLatestquery = "SELECT * FROM coffee_request WHERE `queue`= 1 ORDER BY `brew_date`";
		SQLQuery query = getSession().createSQLQuery(getLatestquery);
		if(query.list().size() == 0){
			System.out.println("start");
			final String get_current_queue_query = "SELECT r.coffeereq_id AS id " +
					"FROM `coffee_request` r " +
					"INNER JOIN config c ON r.config = c.id " +
					"WHERE r.status=0 or r.status=2 AND r.brew_date <= now() " +
					"ORDER BY r.brew_date LIMIT 1";
			SQLQuery query2 = getSession().createSQLQuery(get_current_queue_query);
			query2.addScalar("id", StandardBasicTypes.LONG);
			/*query2.addScalar("appLicationDate", StandardBasicTypes.DATE);
			query2.addScalar("brewDate", StandardBasicTypes.DATE);
			query2.addScalar("coffeeLevel", StandardBasicTypes.INTEGER);
			query2.addScalar("creamerLevel", StandardBasicTypes.INTEGER);
			query2.addScalar("sugarLevel", StandardBasicTypes.INTEGER);
			query2.addScalar("queue", StandardBasicTypes.INTEGER);
			query2.addScalar("status", StandardBasicTypes.INTEGER);
			query2.addScalar("configStatus", StandardBasicTypes.INTEGER);*/
			
			query2.setResultTransformer(Transformers.aliasToBean(CoffeeRequestDTO.class));
			List<CoffeeRequestDTO> result = query2.list();
			
			
			for(CoffeeRequestDTO cr : result) {
				CoffeeRequest c = get(CoffeeRequest.class, cr.getId());
				if(c.getConfig().getStatus() == 0){
					return "Maintenance Mode";
				}
				c.setStatus(1);
				c.setQueue(1);
				save(c);
				
				//execute of check py
				//Integer status = checkStatusMachine();
				
				Long cfg = (long) 1;
				Configuration config = get(Configuration.class, cfg);
				
				Integer coffee = Python.coffeeCheck();
				Integer creamer = Python.creamerCheck();
				Integer sugar = Python.sugarCheck();
				Integer cup1 = Python.cup1();
				Integer cup2 = Python.cup2();
				Integer ir = Python.ir();
				Integer fs = Python.fs();
				System.out.println("here");
				if(coffee.equals(1)){
					notifUser("Insuffiecient coffee");
				}
				if(creamer.equals(1)){
					notifUser("Insuffiecient creamer");
				}
				if(sugar.equals(1)){
					notifUser("Insuffiecient sugar");
				}
				if(cup1.equals(1)){
					notifUser("Insufficient cup at slot #1");
				}
				if(cup2.equals(1)){
					notifUser("Insufficient cup at slot #2");
				}
				if(ir.equals(1)){
					notifUser("Both slots are occupied");
				}
				if(fs.equals(1)){
					notifUser("Water insufficient");
				}
				
				//check error or complete brewing process
				if(coffee.equals(1) || creamer.equals(1) || sugar.equals(1) || fs.equals(1)){
					config.setStatus(0);
					save(config);
					String queueFinish = "UPDATE coffee_request SET queue=0 WHERE coffeereq_id = :id";
					SQLQuery query4 = getSession().createSQLQuery(queueFinish);
					if(!InventoryUtility.isNull(c.getId())) {
						query4.setParameter("id",c.getId());
					}
					query4.executeUpdate();
				}
				else if(ir.equals(0) && brew.equals(1)) {
					brew=0;
					System.out.println("cup2");
					notifUserAdmin(c.getUser().getId(), c.getUser().getRole(), "Coffee of user \"" + c.getUser().getUsername() + "\" is ready on slot #2");
					if(user.getId().equals(c.getUser().getId())){
						output = "<script>modalAlertMessage('Coffee Brew', 'Coffee is ready to serve at slot #2');console.log('coffee brew!');</script>";
					}
					c.setStatus(1);
					c.setQueue(0);
					save(c);
					System.out.println("brew at slot2");
					brewSlot2(c);
					System.out.println("done2");
					brew=1;
					break;
				}
				else if(ir.equals(2) && brew.equals(1)){
					brew=0;
					System.out.println("cup1");
					notifUserAdmin(c.getUser().getId(), c.getUser().getRole(), "Coffee of user \"" + c.getUser().getUsername() + "\" is ready on slot #1");
					if(user.getId().equals(c.getUser().getId())){
						output = "<script>modalAlertMessage('Coffee Brew', 'Coffee is ready to serve at slot #1');console.log('coffee brew!');</script>";
					}
					c.setStatus(1);
					c.setQueue(0);
					save(c);
					System.out.println("brew at slot1");
					brewSlot1(c);
					System.out.println("done2");
					brew=1;
					break;
				}
				//end of check status
				
				
				break;
			}
		}
			
		return output;
	}
	
	public void brewSlot1(CoffeeRequest c) throws IOException {
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = { "sudo", "python3", "brewSlot1.py", c.getCoffeeLevel().toString(), c.getCreamerLevel().toString(), c.getSugarLevel().toString()};

			Process p = Runtime.getRuntime().exec(callAndArgs, null, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting
																									// the
																									// input

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting
																									// the
																									// error

			String command_result = stdInput.readLine();// reading the output
			System.out.println(command_result);
			
		} catch (IOException e) {

		}
	}
	
	public void brewSlot2(CoffeeRequest c) throws IOException {
		final String PYTHON_PATH = "PYTHON_PATH";

		try {

			// pagkuha ng path sa env variables
			String pythonPath = System.getenv(PYTHON_PATH);

			String[] env = null;
			// pwede magdagdag ng parameters para idagdag lang saa string array
			String[] callAndArgs = { "sudo", "python3", "brewSlot2.py", c.getCoffeeLevel().toString(), c.getCreamerLevel().toString(), c.getSugarLevel().toString()};

			Process p = Runtime.getRuntime().exec(callAndArgs, env, new java.io.File(pythonPath));

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));// getting
																									// the
																									// input

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));// getting
																									// the
																									// error

			String command_result = stdInput.readLine();// reading the output
			System.out.println(command_result);
			
		} catch (IOException e) {
			 
		}
	}
	
	@Transactional
	public void notifUserAdmin(Long id,String role, String description){
		Notification n = new Notification();
		Date date = new Date(System.currentTimeMillis());
		n.setCreatedDate(date);
		n.setIsRead(false);
		n.setUserId(id);
		n.setDescription(description);
		
		if(!role.equals("admin")){
			save(n);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("role", "admin");
		List<Users> list = (List<Users>) getAllByHashMap(Users.class, map);
		
		for(Users notifUser : list){
			n.setUserId(notifUser.getId());
			save(n);
		}
	}
	
	@Transactional
	public void notifAdmin(String description){
		Notification n = new Notification();
		Date date = new Date(System.currentTimeMillis());
		n.setCreatedDate(date);
		n.setIsRead(false);
		n.setDescription(description);
	
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("role", "admin");
		List<Users> list = (List<Users>) getAllByHashMap(Users.class, map);
		
		for(Users notifUser : list){
			n.setUserId(notifUser.getId());
			save(n);
		}
	}
	
	@Transactional
	public void notifUser(String description){
		Notification n = new Notification();
		Date date = new Date(System.currentTimeMillis());
		n.setCreatedDate(date);
		n.setIsRead(false);
		n.setDescription(description);
		
		List<Users> list = (List<Users>) getAll(Users.class);
		
		for(Users notifUser : list){
			n.setUserId(notifUser.getId());
			save(n);
		}
	}

	@Override
	public List<CoffeeRequestDTO> viewCoffeeRequest(Users user) {
		//StringBuffer hqlQuery = new StringBuffer("FROM CoffeeRequest where 1=1 ");
		
		StringBuffer hqlQuery = new StringBuffer("SELECT c.coffeereq_id AS id,c.app_date AS applicationDate, c.brew_date AS brewDate, u.username,c.status FROM coffee_request c ");
		
		
		hqlQuery.append("INNER JOIN users u ON u.id = c.userID ");
		hqlQuery.append("WHERE 1=1 ");
		if(user.getRole().equals("user"))
			hqlQuery.append("and userID = :id ");
		hqlQuery.append("AND `status` IN (0,2)");
		
		SQLQuery query = getSession().createSQLQuery(hqlQuery.toString());
		query.addScalar("id", StandardBasicTypes.LONG);
		query.addScalar("applicationDate", StandardBasicTypes.DATE);
		query.addScalar("brewDate", StandardBasicTypes.DATE);
		query.addScalar("status", StandardBasicTypes.INTEGER);
		query.addScalar("username", StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(CoffeeRequestDTO.class));
		if(user.getRole().equals( "user")) {
			query.setParameter("id",user.getId());
		}
		List<CoffeeRequestDTO> result = query.list();
		for(CoffeeRequestDTO d: result){
			d.setStatusDesc(CoffeeStatusEnum.getInstance(d.getStatus()).getDescription().toUpperCase());
		}
		return result;
	}

	@Override
	public Map<String, Object> viewNotifUnread(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Notification e where 1=1 AND isRead=false ");
		StringBuffer hqlQuery = new StringBuffer("from Notification e where 1=1 ");
		
		dynamicSql.append("AND userId= :id ORDER BY id desc limit 10 ");
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		
		query.setParameter("id", id);
		queryCount.setParameter("id", id);
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Notification> result = query.list();
		List<Notification> result2 = new ArrayList<Notification>();
		
		for(int x = 0; x <result.size();x++){
			if( x ==10)
				break;
			result2.add(result.get(x));
		}
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, result2);
		return map;
	}
	
	
}

