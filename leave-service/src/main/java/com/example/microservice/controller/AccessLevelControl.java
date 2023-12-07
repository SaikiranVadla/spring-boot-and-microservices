package com.example.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.service.AccessLevelService;

@RestController
@RequestMapping("/accesslevelcontrol")
public class AccessLevelControl {
	
	@Autowired
	private AccessLevelService accessLevelService;

}
