package com.globalsociety.global.index.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPage {
	
	Logger logger= LoggerFactory.getLogger(IndexPage.class);

	@GetMapping("/societyManagement")
	public String getIndexPage() {
		
		logger.info("inside get index page");
		logger.info("*********************Opening Landing Page****************");
		return "index";
	}
	
}
