package com.example.microservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@GetMapping("/managerServiceFallBack")
	public String managerServiceFallBackMethod() {
		return "Manager Service is taking longer than expected." +
	            "Please Try Again ater.";
	}
	
	
	@GetMapping("/employeeServiceFallBack")
	public String employeeServiceFallBackMethod() {
		return "Employee Service is taking longer than expected." +
	            "Please Try Again ater.";
	}


}
