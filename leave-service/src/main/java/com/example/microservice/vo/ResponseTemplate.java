package com.example.microservice.vo;


import com.example.microservice.entity.Leave;

public class ResponseTemplate {
	
	private Leave leave;
	
	private Employee employee;

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

		
	
	

}
