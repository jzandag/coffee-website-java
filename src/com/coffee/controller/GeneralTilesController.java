package com.coffee.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coffee.base.BaseController;
import com.coffee.model.Users;
import com.coffee.service.CoffeeService;
import com.coffee.util.InventoryUtility;



/*
 * Controller for general pages
 *  - zidrex
 */
@Controller
public class GeneralTilesController extends BaseController {
protected static Logger logger = Logger.getLogger(GeneralTilesController.class);
	
	@Autowired
	private CoffeeService coffeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Users user = (Users) request.getSession().getAttribute("userSessionObj");
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			response.sendRedirect(request.getContextPath() + "/coffee/dashboard");
		}
		return "login";
		
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request,HttpServletResponse response,ModelMap model, @ModelAttribute("") Users user,BindingResult result) throws IOException {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String pw = md5.encodePassword(user.getPassword(), "");
		//coffeeService
		user.setPassword(pw);
		
		 HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("password", user.getPassword());
			map.put("username", user.getUsername());
			List<Users> u = (List<Users>) coffeeService.getAllByHashMap(Users.class, map);
		//List<Users> u = (List<Users>) coffeeService.validateUser(user);
		if(u.size() == 0){
			model.addAttribute("error", "wrong password or doesnt exist");
			response.sendRedirect(request.getContextPath() + "/");
		}else{
			request.getSession().setAttribute("userSessionObj", coffeeService.get(Users.class, u.get(0).getId()));
			response.sendRedirect(request.getContextPath() + "/coffee/dashboard");
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("userSessionObj");
		
		response.sendRedirect(request.getContextPath() + "/");
	}
	
}
