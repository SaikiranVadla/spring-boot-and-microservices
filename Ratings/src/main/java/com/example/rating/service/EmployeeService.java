package com.example.rating.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entity.Employee;
import com.example.rating.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	private Long id;

	public String saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee save = employeeRepo.save(employee);
		return "Data inserted successfully";
	}

	public List<Employee> fetchAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> allEmployees = employeeRepo.findAll();
		return allEmployees;
	}

	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {  return employee.get(); }
		return null;
	}
	
	public String updateEmployeeById(Long id) {
		Optional<Employee> employee1 = employeeRepo.findById(id);
		if(employee1.isPresent()) {
			Employee employee = new Employee();
			Employee originalEmployee = employee1.get();
			if(Objects.nonNull(employee.getUsername()) && !"".equalsIgnoreCase(employee.getUsername())) {
				originalEmployee.setUsername(employee.getUsername());
			}
		}
		return "Updated Employee Successfully";
	}

	public String deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		if(employeeRepo.findById(id).isPresent()) {
			employeeRepo.deleteById(id);
			return "Deleted Employee Successfully";
		}
		return null;
	}
	
	
	

	
	
	
	
	
	

}
