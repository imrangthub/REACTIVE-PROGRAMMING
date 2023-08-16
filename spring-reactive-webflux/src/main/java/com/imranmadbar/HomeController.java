package com.imranmadbar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	
	@Autowired
	private SimpleReactiveService simpleReactiveService;
	


	@GetMapping(value = "/")
	public String welcomeMsg() {
		logger.info("Welcome to SimpleWebApplication");

		return "Welcome to SimpleWebApplication";
	}

	
	@GetMapping(value = "/reactive-call1")
	public String readtiveCall() {
		
		simpleReactiveService.consumer1();
		

		return "readtiveCall1";
	}
	
	
	@GetMapping(value = "/reactive-call2")
	public String readtiveCall2() {
		
		simpleReactiveService.consumer2();
		

		return "readtiveCall2";
	}

}