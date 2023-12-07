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
public class EmpRating {
	
	@Id
	@GeneratedValue
	private Long ratingid;
	
	private String month;
	
	private Date year;
	
	private String technology;
	
	private Float techrating;
	
	private Float communicrating;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	@JsonBackReference
	private Employee employee;

	

	public Long getRatingid() {
		return ratingid;
	}

	public void setRatingid(Long ratingid) {
		this.ratingid = ratingid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Float getTechrating() {
		return techrating;
	}

	public void setTechrating(Float techrating) {
		this.techrating = techrating;
	}

	public Float getCommunicrating() {
		return communicrating;
	}

	public void setCommunicrating(Float communicrating) {
		this.communicrating = communicrating;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpRating [ratingid=" + ratingid + ", month=" + month + ", year=" + year + ", technology=" + technology
				+ ", techrating=" + techrating + ", communicrating=" + communicrating + ", employee=" + employee + "]";
	}

	public Boolean getRemainder() {
		
		return null;
	}

	public void setRemainder(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
	

}
