package com.bit.scrt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("index...");
		
		return "home";
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		logger.info("admin...");
		
		return "admin";
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		logger.info("user...");
		
		return "user";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login...");
		
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		logger.info("logout...");
		
		return "logout";
	}
	
}
