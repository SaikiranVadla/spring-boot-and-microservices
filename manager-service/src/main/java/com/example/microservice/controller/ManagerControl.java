package com.example.microservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.entity.Manager;
import com.example.microservice.service.ManagerService;
import com.example.microservice.vo.ResponseTemplate;

@RestController
@RequestMapping("/manager")
public class ManagerControl {
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveManager(@RequestBody Manager manager){
		String saveManager = managerService.saveManager(manager);
		return new ResponseEntity<String>("Manager Data is Inserted", HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public Manager getManagerById(@PathVariable("id") Long managerid ){
		return managerService.getManagerById(managerid);
	}
	
	@GetMapping("/get-m-e/{managerid}")
	public ResponseTemplate getManagerWithEmployee(@PathVariable Long managerid) {
		return managerService.getManagerWithEmployee(managerid);
	}
	
	@PutMapping("/update/{managerid}")
	public String updateManagerById(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	

}
