package com.example.rating.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.rating.entity.EmpRating;
import com.example.rating.entity.EmpSkill;
import com.example.rating.entity.Employee;
import com.example.rating.repository.EmpRatingRepo;
import com.example.rating.repository.EmployeeRepo;

import jakarta.mail.internet.MimeMessage;
import org.thymeleaf.context.Context;
@Service
@EnableScheduling
public class EmpRatingService {
	
	@Autowired
	private EmpRatingRepo empRatingRepo;
	
	@Autowired
	private EmployeeRepo employeerepo;
	
	private String username;

	public String saveEmpRatings(EmpRating emprating) {
		// TODO Auto-generated method stub
		EmpRating save = empRatingRepo.save(emprating);
		return "Ratings Data inserted successfully";
	}
	
	@Autowired
	private JavaMailSender javamailsender;
	
	@Scheduled(fixedRate = 600000)
	public void yourScheduledMethod() {
	    // Your logic here

	
	      try {
	    	  
	    	  LocalDate today = LocalDate.now();
	    	  List<Employee> lowratings = employeerepo.findEmployeesWithLowRatings();
	    	  
	    	  for(Employee employee : lowratings) {
	    		  MimeMessage message = javamailsender.createMimeMessage();
	    		  MimeMessageHelper helper = new MimeMessageHelper(message, true);

					helper.setTo(employee.getEmail());
					helper.setSubject("Monthly reviews");
					helper.setText("This is your monthly review.");
					javamailsender.send(message);
	    	  }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	}

	
	
	

	
	
	
	


