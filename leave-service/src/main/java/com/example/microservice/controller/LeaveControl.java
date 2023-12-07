package com.example.microservice.controller;

import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.entity.AccessLevel;
import com.example.microservice.entity.EmpAccessLevel;
import com.example.microservice.entity.Leave;
import com.example.microservice.service.AccessLevelService;
import com.example.microservice.service.EmpAccessLevelService;
import com.example.microservice.service.LeaveService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/leave")
public class LeaveControl {
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private EmpAccessLevelService empAccessLevelService;
	
	@Autowired
	private AccessLevelService accessLevelService;
	
	
	@PostMapping("/saveAccesslevel")
	public ResponseEntity<String> saveAccessLevel(@RequestBody EmpAccessLevel empAccessLevel){
		leaveService.saveEmpAccessLevel(empAccessLevel);
		
	
		return new  ResponseEntity<String>("Saved Access Level Successfully!",null, HttpStatus.SC_OK);
	}
	
	@PostMapping("/saveAccessRole")
	public ResponseEntity<String> saveAccessRole(@RequestBody AccessLevel accessLevel){
		leaveService.saveAccessRole(accessLevel);
		return new  ResponseEntity<String>("Saved Access Details Successfully!",null, HttpStatus.SC_OK);
	}
	
	@PostMapping("/saveLeave")
	public ResponseEntity<String> saveEmpLeave(@RequestBody Leave leave) throws MessagingException {
		leaveService.saveEmpLeave(leave);
		return new ResponseEntity<String>("Saved Leave Details Successfully!",null, HttpStatus.SC_OK);
	}
		

	@DeleteMapping("/deleteById/{leaveid}")
    public ResponseEntity<Map<String, Object>> deleteByLeaveId(@PathVariable long leaveid) {
		
		leaveService.leaveDelete(leaveid);
		return null;
	}
	
	@GetMapping("/getAccessLevel/{accesslevelid}")
	public EmpAccessLevel getAccessLevel(@PathVariable Long accesslevelid){
		EmpAccessLevel accessLevel=empAccessLevelService.getAccessLevel(accesslevelid);
		return accessLevel;
	}
	
	@GetMapping("/getAccessRole/{id}")
	 public AccessLevel getAccessRole(@PathVariable Long id) {
		 AccessLevel accessLevel = accessLevelService.getAccessRole(id);
		return accessLevel;
		 
	 }
	 
	@GetMapping("/getEmpLeave/{leaveid}")
	public Leave getLeave(@PathVariable Long leaveid) {
		Leave leave = leaveService.getLeave(leaveid);
		return leave;
		
	}
	
	@PostMapping("/sendmail")
	public void sendMail(@RequestParam("employeemail") String employeemail,@RequestParam("employeeid") long employeeid, Leave leave) throws com.example.microservice.exception.MessagingException, MessagingException {
		Leave leave1 = new Leave();
				leaveService.sendMail(employeemail, employeeid, leave1); 
	}	
	
	
}
	
