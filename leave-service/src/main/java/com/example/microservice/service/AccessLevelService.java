package com.example.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.entity.AccessLevel;
import com.example.microservice.exception.IdNotFoundException;
import com.example.microservice.repository.AccessLevelRepo;

@Service
public class AccessLevelService {
	
	@Autowired
	private AccessLevelRepo accessLevelRepo;
	
	public AccessLevel saveAccessRole(AccessLevel accessLevel) {
		return accessLevelRepo.save(accessLevel);
	}
	
	public AccessLevel getAccessRole(Long id) {
		return accessLevelRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("AccessRole is Not Available"));
	}
	
	public List<AccessLevel> getAllAccessRole() throws IdNotFoundException {
		List<AccessLevel> accessLevel = accessLevelRepo.findAll();
		if (accessLevel.isEmpty()) {
			throw new IdNotFoundException("AccessRole Data not Available");
		} else {
			return accessLevel;
		}
	}

	

}
