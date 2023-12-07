package com.example.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.entity.EmpRating;
import com.example.rating.service.EmpRatingService;

@RestController
@RequestMapping("/rating")
public class EmpRatingControl {
	
	@Autowired
	private EmpRatingService empRatingService;
	
	@PostMapping("/saverating")
	public ResponseEntity<String> saveEmpRatings(@RequestBody EmpRating emprating){
		String saveEmpSkill = empRatingService.saveEmpRatings(emprating);
		return new ResponseEntity<String>("Ratings Data inserted successfully", HttpStatus.OK);
	}
	
	
	
	

}
