package com.example.microservice.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long employeeid;
	
//	@NotEmpty(message= "Employee shouldn't be empty")
	private String employeename;
	
//	@NotBlank(message = "should not be blank")
//    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String employeemail;
	
//	@Pattern(regexp = "^[6789][0-9]{9}$",message = "mobile number should contain 10 digits and start with 6 or 7 or 8 or 9 ")
    private Long mobilenumber;

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeemail() {
		return employeemail;
	}

	public void setEmployeemail(String employeemail) {
		this.employeemail = employeemail;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeemail="
				+ employeemail + ", mobilenumber=" + mobilenumber + "]";
	}

	
	
	

}
