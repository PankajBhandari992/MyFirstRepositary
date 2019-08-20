package com.globalsociety.global.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalsociety.global.login.bean.Login;
import com.globalsociety.global.login.service.LoginService;

@Controller
public class LoginContoller {
	
	Logger logger= LoggerFactory.getLogger(LoginContoller.class);
	
	@Autowired
	LoginService loginService;
	
	/*
	 * @GetMapping(value="/login") public String validateLoginDetails(Model
	 * model, @RequestParam("username") String userName, @RequestParam("password")
	 * String password) { logger.info("inside validate login details"); Login login
	 * = loginService.getLoginDetilsByUsername(userName);
	 * 
	 * 
	 * logger.info("userId: "+ login.getUsername()+" pasword: "+ login.getPassword()
	 * );
	 * 
	 * if(userName.equals(login.getUsername()) &&
	 * password.equals(login.getPassword())) {
	 * 
	 * model.addAttribute("username", userName); model.addAttribute("password",
	 * password); model.addAttribute("message", "Login Successful"); }else {
	 * 
	 * model.addAttribute("username", userName); model.addAttribute("password",
	 * password); model.addAttribute("message", "Login UnSuccessful"); }
	 * 
	 * return "welcome"; }
	 */
	
	
	@RequestMapping(value="/adduser"  ,method =RequestMethod.POST	)
	public String addUser(Model model, @RequestParam("userName") String userName, @RequestParam("password") String password) {
		logger.info("inside addUser method :: "+ userName);
		
		Login login = new Login();
		
		login.setPassword(password);
		login.setUsername(userName);
		
		int a= loginService.saveUser(login);
		logger.info("login pk generated is: "+ a);
		model.addAttribute("message", "user added successfully");
		return "welcome";
		
	}	

}
