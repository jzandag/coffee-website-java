package com.coffee.service;

import java.util.List;

import com.coffee.base.BaseService;
import com.coffee.model.Users;

public interface CoffeeService extends BaseService {
	//student
	public List<Users> validateUser(Users user);
	
	public Boolean checkIfQueue(Users user);
	
	public String checkLatestSched(Users user);
}