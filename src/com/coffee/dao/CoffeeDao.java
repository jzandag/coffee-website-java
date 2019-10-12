package com.coffee.dao;

import java.util.List;
import java.util.Map;

import com.coffee.base.BaseDao;
import com.coffee.model.CoffeeRequest;
import com.coffee.model.CoffeeRequestDTO;
import com.coffee.model.Notification;
import com.coffee.model.Users;
				
public interface CoffeeDao extends BaseDao {
	
	public List<Users> validateUser(Users user);
	
	public Boolean checkIfQueue(Users user);
	
	public String checkLatestSched(Users user);
	
	public List<CoffeeRequestDTO> viewCoffeeRequest(Users user);

	public Map<String, Object> viewNotifUnread(Long id);
	
}
