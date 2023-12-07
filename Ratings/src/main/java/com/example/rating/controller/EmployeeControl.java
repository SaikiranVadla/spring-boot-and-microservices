package com.example.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.entity.Employee;
import com.example.rating.service.EmployeeService;

@RestController
public class EmployeeControl {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/saveemp")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		String saveEmployee = employeeservice.saveEmployee(employee);
		return new ResponseEntity<String>("Data inserted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllEmployees(){
		return employeeservice.fetchAllEmployees();
	}
	
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeservice.getEmployeeById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployeeById(@RequestBody Employee employee) {
		return employeeservice.saveEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		return employeeservice.deleteEmployeeById(id);
	}

}

