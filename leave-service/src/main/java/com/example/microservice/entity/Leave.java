package com.example.microservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MS_Leave")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long leaveid;
//	
	private LocalDate statrdate;
//	
	private LocalDate enddate;
//	
	private String reason;
public Long getLeaveid() {
		return leaveid;
	}
	public void setLeaveid(Long leaveid) {
		this.leaveid = leaveid;
	}
	public LocalDate getStatrdate() {
		return statrdate;
	}
	public void setStatrdate(LocalDate statrdate) {
		this.statrdate = statrdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LeaveStatus getStatus() {
		return status;
	}
	public void setStatus(LeaveStatus status) {
		this.status = status;
	}
	//	
	@Enumerated(EnumType.STRING)
	private LeaveStatus status=LeaveStatus.PENDING;
	public String getEmployeeid() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}