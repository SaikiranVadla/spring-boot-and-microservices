package com.example.microservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.microservice.entity.Manager;
import com.example.microservice.repository.ManagerRepo;
import com.example.microservice.vo.Employee;
import com.example.microservice.vo.ResponseTemplate;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepo managerRepo;

	@Autowired
	private RestTemplate restTemplate;

	public String saveManager(Manager manager) {
		// TODO Auto-generated method stub
		Manager save = managerRepo.save(manager);
		return "Manager Data is Inserted";
	}

	public Manager getManagerById(Long managerid) {
		// TODO Auto-generated method stub
		Optional<Manager> manager = managerRepo.findById(managerid);
		if (manager.isPresent()) {
			return manager.get();
		} else
			return null;
	}

	public ResponseTemplate getManagerWithEmployee(Long managerid) {
		// TODO Auto-generated method stub
		ResponseTemplate vo = new ResponseTemplate();
		Manager manager = managerRepo.findById(managerid).get();
        
		Employee employee = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/get/" + manager.getEmployeeid(),
				Employee.class);

		vo.setManager(manager);
		vo.setEmployee(employee);

		return  vo;
	}
	
	public String updateManagerById(Long managerid) {
		Optional<Manager> manager1 = managerRepo.findById(managerid);
		if(manager1.isPresent()) {
			Manager manager = new Manager();
			Manager originalEmployee = manager1.get();
			if(Objects.nonNull(manager.getManagername()) && !"".equalsIgnoreCase(manager.getManagername())) {
				originalEmployee.setManagername(manager.getManagername());
			}
		}
		return "Updated Manager Successfully";
	}

}
