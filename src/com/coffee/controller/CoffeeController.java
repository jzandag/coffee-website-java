package com.coffee.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.base.BaseController;
import com.coffee.enums.Roles;
import com.coffee.model.CoffeeRequest;
import com.coffee.model.Configuration;
import com.coffee.model.Users;
import com.coffee.service.CoffeeService;
import com.coffee.util.InventoryUtility;


@Controller
@RequestMapping("/coffee")
public class CoffeeController extends BaseController {
	
	@Autowired
	private CoffeeService coffeeService;
	
	private Map<String, String> roleList;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			Users user = (Users) request.getSession().getAttribute("userSessionObj");
			if(user.getRole() == "admin"){
				HashMap<String, Object> map = new HashMap<String, Object>();
				//map.put
			}else if(user.getRole() == "user"){
				
			}
			return "dashboard";
		}
		return "login";
	}
	
	@RequestMapping(value = "/executeBrew")
	public String executeBrew(HttpServletRequest request,HttpServletResponse response,ModelMap map,
			@ModelAttribute("coffeeCommand") CoffeeRequest cr) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			Long l = (long) 1;
			Configuration cfg = coffeeService.get(Configuration.class, l);
			Users user = (Users) request.getSession().getAttribute("userSessionObj");
			cr.setConfig(cfg);
			Date date = new Date(System.currentTimeMillis());
			cr.setApplicationDate(date);
			cr.setBrewDate(date);
			cr.setUser(user);
			cr.setStatus(0);
			cr.setQueue(0);
			
			coffeeService.save(cr);
			return "dashboard";
		}
		return "login";
	}
	
	@RequestMapping(value = "/saveBrew")
	public String SaveBrew(HttpServletRequest request,HttpServletResponse response,ModelMap map,@ModelAttribute("coffeeCommand")CoffeeRequest cr) throws IOException, ParseException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			Long l = (long) 1;
			Configuration cfg = coffeeService.get(Configuration.class, l);
			Users user = (Users) request.getSession().getAttribute("userSessionObj");
			cr.setConfig(cfg);
			Date date = new Date(System.currentTimeMillis());
			cr.setApplicationDate(date);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date brewDate = formatter.parse(cr.getBrewDatee());
			cr.setBrewDate(brewDate);
			cr.setUser(user);
			cr.setStatus(2);
			cr.setQueue(0);
			coffeeService.save(cr);
			return "dashboard";
		}
		return "login";
	}
	
	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String about(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			
			return "aboutUs";
		}
		return "login";
	}
	
	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public String viewUsers(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			
			model.put("users", coffeeService.getAll(Users.class));
			return "viewUsers";
		}
		return "login";
	}
	
	@RequestMapping(value = "/userProfileNew", method = RequestMethod.GET)
	public String userProfileNew(@ModelAttribute("userCommand") Users user,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			initModel(model);
			model.put("users", coffeeService.getAll(Users.class));
			return "userProfile";
		}
		return "login";
	}
	
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String userProfile(@ModelAttribute("userCommand") Users user,BindingResult result,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			initModel(model);
			Users user2 = coffeeService.get(Users.class, user.getId());
			model.put("userCommand", user2);
			return "userProfile";
		}
		return "login";
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			
			Long id = Long.parseLong(request.getParameter("id"));
			coffeeService.delete(Users.class, id);
			return "viewUsers";
		}
		return "login";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(HttpServletRequest request,HttpServletResponse response,ModelMap model,@ModelAttribute("userComand") Users user,BindingResult result) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			coffeeService.save(user);
			model.put("users", coffeeService.getAll(Users.class));
			return "userProfile";
		}
		return "login";
	}
	
	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public String myProfile(HttpServletRequest request,HttpServletResponse response,ModelMap model,@ModelAttribute("userComand") Users user,BindingResult result) throws IOException {
		if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){
			initModel(model);
			model.put("users", coffeeService.getAll(Users.class));
			return "userProfile";
		}
		return "login";
	}
	
	@RequestMapping(value = "/disable")
	public @ResponseBody String disable(HttpServletRequest request,HttpServletResponse response,ModelMap map,@ModelAttribute("coffeeCommand")CoffeeRequest cr) throws IOException {
		//if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj")))
			
			Users user = (Users) request.getSession().getAttribute("userSessionObj");
			Boolean test = coffeeService.checkIfQueue(user);
			return "result:"+test;
		
	}
	
	@RequestMapping(value = "/latestSched")
	public @ResponseBody String latest(HttpServletRequest request,HttpServletResponse response,ModelMap map,@ModelAttribute("coffeeCommand")CoffeeRequest cr) throws IOException {
		/*if(!InventoryUtility.isNull(request.getSession().getAttribute("userSessionObj"))){*/
			Users user = (Users) request.getSession().getAttribute("userSessionObj");
			
			String test = coffeeService.checkLatestSched(user);
		return "{\"alert\":\""+test+"\"}";
	}
	
	private void initModel(ModelMap model) {
		model.addAttribute("roleList", getRoleList());
		
	}
	
	public Map<String, String> getRoleList() {
		if (InventoryUtility.isNull(roleList)) {
			roleList = new HashMap<String, String>();
			for (Roles value : Roles.values()) {
				roleList.put(value.getValue(), value.getDescription());
			}
		}

		return roleList;
	}
	
	
	
}
