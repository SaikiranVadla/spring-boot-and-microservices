package com.example.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.microservice.entity.AccessLevel;
import com.example.microservice.entity.EmpAccessLevel;
import com.example.microservice.entity.Leave;
import com.example.microservice.exception.IdNotFoundException;
import com.example.microservice.exception.MessagingException;
import com.example.microservice.repository.AccessLevelRepo;
import com.example.microservice.repository.EmpAccessLevelRepo;
import com.example.microservice.repository.LeaveRepo;
import com.example.microservice.vo.Employee;
import com.example.microservice.vo.ResponseTemplate;

import jakarta.mail.internet.MimeMessage;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	private EmpAccessLevelRepo empAccessLevelRepo;
	
	@Autowired
	private AccessLevelRepo accessLevelRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Leave saveEmpLeave(Leave leave) throws jakarta.mail.MessagingException {


		Leave save = leaveRepo.save(leave);

		System.out.println(save.toString());

//		try {
//			sendMail("saikiran25.vsk@gmail.com", "Apply for Leave Letter", save.getLeaveid());
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("inside save leave");

		return save;
	}
	
	public Leave getLeave(Long leaveid) {
		Leave orElseThrow = leaveRepo.findById(leaveid)
				.orElseThrow(() -> new RuntimeException("EmpLeave Data is Not Available"));
		
		return orElseThrow;
	}
	
	public List<Leave> getAllLeaves() throws IdNotFoundException{
		List<Leave> leave = leaveRepo.findAll();
		if (leave.isEmpty()) {
			throw new IdNotFoundException("EmpLeave Data not Available");
		} else {
			return leave;
		}
	}
	
	public Leave sendMail(String employeemail, long employeeid, Leave leave) throws MessagingException, jakarta.mail.MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		String subject="Leave to HR";
		ResponseTemplate vo = new ResponseTemplate();
		Employee employee = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/get/" + leave.getEmployeeid(),
				Employee.class);
//		Leave findById = leaveRepo.findById(empId).get();
	
		helper.setTo(employeemail);
		helper.setSubject(subject);
		helper.setText("I am V.Sai Kiran joined as an intern in Springboot Technology."
				        + "Today I'm not coming to office due to some personal issue."
				        + "Thank You."
				        + "Yours Sincierly"
				        + "Sai Kiran");
		
		javaMailSender.send(message);
		return null;
		
	}

	public void saveEmpAccessLevel(EmpAccessLevel empAccessLevel) {
		// TODO Auto-generated method stub
		EmpAccessLevel save = empAccessLevelRepo.save(empAccessLevel);
	}

	public void saveAccessRole(AccessLevel accessLevel) {
		// TODO Auto-generated method stub
		AccessLevel save = accessLevelRepo.save(accessLevel);
	}

	public void leaveDelete(long leaveid) {
		// TODO Auto-generated method stub
		
	}

	
	
//	public ResponseTemplate getLeaveWithEmployee(Long leaveid) {
//		// TODO Auto-generated method stub
//		ResponseTemplate vo = new ResponseTemplate();
//		Leave leave = leaveRepo.findById(leaveid).get();
//        
//		Employee employee = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/get/" + leave.getEmployeeid(),
//				Employee.class);
//
//		vo.setLeave(leave);
//		vo.setEmployee(employee);
//
//		return  vo;
//	}
	

}
