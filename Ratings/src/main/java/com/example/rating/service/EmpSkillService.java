package com.example.rating.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entity.EmpSkill;
import com.example.rating.entity.Employee;
import com.example.rating.repository.EmpSkillRepo;
import com.example.rating.repository.EmployeeRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpSkillService {
	
	@Autowired
	private EmpSkillRepo empSkillRepo;
	private EmployeeRepo employeeRepo;

	      public String saveEmpSkill(EmpSkill empskill) {
		// TODO Auto-generated method stub
		EmpSkill save = empSkillRepo.save(empskill);
		return "Skill Data inserted successfully";
	}


	public String getWorkingById(Long employeeid) {
		// TODO Auto-generated method stub
		String working = EmpSkill.getById(employeeid).getWorking();
		if(working.equals("trainee")) {
			return working;
		}
		
		return "Fetched trainee from data";
	}
      
      
	
	

	
	
	

}
