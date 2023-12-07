package com.example.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.entity.EmpAccessLevel;
import com.example.microservice.exception.IdNotFoundException;
import com.example.microservice.repository.EmpAccessLevelRepo;

@Service
public class EmpAccessLevelService {
	
	@Autowired
	private EmpAccessLevelRepo empAccessLevelRepo;
	
//	public EmpAccessLevel saveAccessLevel(EmpAccessLevel empAccessLevel) {
//
//		return empAccessLevelRepo.save(empAccessLevel);
//
//	}
	
	public EmpAccessLevel getAccessLevel(Long accesslevelid) {
		return empAccessLevelRepo.findById(accesslevelid)
				.orElseThrow(() -> new RuntimeException("AccessLevel is Not Available"));
	}
	
	public List<EmpAccessLevel> getAllAccessLevel() throws IdNotFoundException {

		List<EmpAccessLevel> accessLevel = empAccessLevelRepo.findAll();
		if (accessLevel.isEmpty()) {
			throw new IdNotFoundException("Accesslevel Data not Available");
		} else {
			return accessLevel;
		}
	}



}
