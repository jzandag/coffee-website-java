package com.coffee.dao;

import java.util.List;

import com.coffee.base.BaseDao;
import com.coffee.model.CoffeeRequest;
import com.coffee.model.CoffeeRequestDTO;
import com.coffee.model.Users;
				
public interface CoffeeDao extends BaseDao {
	
	public List<Users> validateUser(Users user);
	
	public Boolean checkIfQueue(Users user);
	
	public String checkLatestSched(Users user);
	
	public List<CoffeeRequestDTO> viewCoffeeRequest(Users user);
}
