package com.coffee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.base.BaseServiceImpl;
import com.coffee.dao.CoffeeDao;
import com.coffee.model.CoffeeRequest;
import com.coffee.model.CoffeeRequestDTO;
import com.coffee.model.Notification;
import com.coffee.model.Users;
import com.coffee.service.CoffeeService;
import com.coffee.util.Page;
import com.coffee.util.PaginationUtility;

@Service("coffeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CoffeeServiceImpl extends BaseServiceImpl implements CoffeeService  {

	@Autowired
	private CoffeeDao coffeeDao;

	@Override
	public List<Users> validateUser(Users user) {
		return coffeeDao.validateUser(user);
	}

	@Override
	public Boolean checkIfQueue(Users user) {
		return coffeeDao.checkIfQueue(user);
	}

	@Override
	public String checkLatestSched(Users user) {
		return coffeeDao.checkLatestSched(user);
	}

	@Override
	public List<CoffeeRequestDTO> viewCoffeeRequest(Users user) {
		// TODO Auto-generated method stub
		return coffeeDao.viewCoffeeRequest(user);
	}

	@Override
	public Page viewNotifUnread(Long id) {
		Map<String, Object> map = coffeeDao.viewNotifUnread(id);
        
        Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), 1);
        page.setContent((List<?>)map.get(KEY_LIST));
        
        return page;
	}
	

}