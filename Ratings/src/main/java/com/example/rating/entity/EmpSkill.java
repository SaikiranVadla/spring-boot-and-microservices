package com.example.rating.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class EmpSkill {
	
	@Id
	@GeneratedValue
	private Long skillid;
	
	private String skill;
	
	private String working;
	
	private Date startdate;
	
	private Date enddate;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	@JsonBackReference()
	private Employee employee;

	

	public Long getSkillid() {
		return skillid;
	}

	public void setSkillid(Long skillid) {
		this.skillid = skillid;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getWorking() {
		return working;
	}

	public void setWorking(String working) {
		this.working = working;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpSkill [skillid=" + skillid + ", skill=" + skill + ", working=" + working + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", employee=" + employee + "]";
	}

	
	public static EmpSkill getById(Long employeeid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
