package com.example.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.entity.EmpSkill;
import com.example.rating.service.EmpSkillService;

@RestController
public class EmpSkillControl {
	
	@Autowired
	private EmpSkillService empskillservice;
	
	@PostMapping("/saveskill")
	public ResponseEntity<String> saveEmpSkills(@RequestBody EmpSkill empskill){
		String saveEmpSkill = empskillservice.saveEmpSkill(empskill);
		return new ResponseEntity<String>("Skill Data inserted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getworking/{id}")
	public String getWorkingById(@PathVariable("id") Long id) {
		return empskillservice.getWorkingById(id);
	}
	
	
	

}
