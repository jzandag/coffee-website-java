package com.coffee.service;

import java.io.IOException;
import java.util.List;

import com.coffee.base.BaseService;
import com.coffee.model.CoffeeRequest;
import com.coffee.model.CoffeeRequestDTO;
import com.coffee.model.Notification;
import com.coffee.model.Users;
import com.coffee.util.Page;

public interface CoffeeService extends BaseService {
	//student
	public List<Users> validateUser(Users user);
	
	public Boolean checkIfQueue(Users user);
	
	public String checkLatestSched(Users user) throws IOException;
	
	public List<CoffeeRequestDTO> viewCoffeeRequest(Users user);

	public Page viewNotifUnread(Long id);
}
