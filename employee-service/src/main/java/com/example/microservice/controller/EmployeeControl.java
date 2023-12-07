package com.example.microservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.entity.Employee;
import com.example.microservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeControl {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		 String saveEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee Data is Inserted", HttpStatus.OK);
	}
	
	@GetMapping("/get/{employeeid}")
	public Employee getEmployeeById(@PathVariable("employeeid") Long employeeid) {
		return employeeService.getEmployeeById(employeeid);
	}

}
