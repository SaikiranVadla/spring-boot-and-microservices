package com.example.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.entity.Employee;

import com.example.microservice.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public String saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee save = employeeRepo.save(employee);
		return "Employee Data is Inserted";
	}

	public Employee getEmployeeById(Long employeeid) {
		// TODO Auto-generated method stub
		Optional<Employee> manager = employeeRepo.findById(employeeid);
		if(manager.isPresent()) { 
			return manager.get();  
			}
		return null;
		
	}

}
