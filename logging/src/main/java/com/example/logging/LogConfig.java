package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class LogConfig {
	
	private static final Logger log = LoggerFactory.getLogger(LogConfig.class);

	@GetMapping("/user")
	public void getUser() {
		log.info("getting user");
		
	}


}
