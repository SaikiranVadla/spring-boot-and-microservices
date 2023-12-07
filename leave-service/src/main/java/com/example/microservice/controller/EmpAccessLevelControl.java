package com.example.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.service.EmpAccessLevelService;

@RestController
@RequestMapping("/empaccesslevelcontrol")
public class EmpAccessLevelControl {
	
	@Autowired
	private EmpAccessLevelService empAccessLevelService;
	
	

}
