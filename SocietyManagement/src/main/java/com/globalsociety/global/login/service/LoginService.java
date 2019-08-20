package com.globalsociety.global.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalsociety.global.login.bean.Login;
import com.globalsociety.global.login.dao.LoginDao;

@Service
public class LoginService {
	
	Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	LoginDao loginDao;
	
	public Login getLoginDetilsByUsername(String username) {
		
		logger.info("Inside getLoginDetailsByUsername in LoginService | username : "+ username);
		return loginDao.getLoginDetilsByUsername(username).get(0);
		
	}

	public int saveUser(Login login) {
		
		
		return loginDao.addUser(login);
		
	}
	
	

}
