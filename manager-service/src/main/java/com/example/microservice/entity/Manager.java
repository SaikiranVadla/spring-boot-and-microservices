package com.example.microservice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.example.microservice.vo.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Table
@Entity
public class Manager {

	@Id
	@GeneratedValue
	private Long managerid;

//	@NotEmpty(message = "ManagerName shouldn't be empty")
	private String managername;

//	@NotBlank(message = "should not be blank")
//    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String managermail;

//	@Pattern(regexp = "^[6789][0-9]{9}$",message = "mobile number should contain 10 digits and start with 6 or 7 or 8 or 9 ")
    private Long mobileno;
	
//	@NotBlank(message="Please mention your working")
	private String working;
	
//	@NotEmpty(message = "Skills shouldn't be empty")
    private String skills;
	
	private Date startdate;
	
	private Date enddate;
	
	@UpdateTimestamp
	private String modified;
	
	private String createdby;
	private Long employeeid;
	
//	 List<Employee> employee = new ArrayList<>();

	public Long getManagerid() {
		return managerid;
	}

	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagermail() {
		return managermail;
	}

	public void setManagermail(String managermail) {
		this.managermail = managermail;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	

	public String getWorking() {
		return working;
	}

	public void setWorking(String working) {
		this.working = working;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

}
