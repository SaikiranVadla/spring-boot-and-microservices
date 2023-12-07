package com.example.rating.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//@NotBlank(message = "should not be blank")
//    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
//    @NotEmpty(message = "Username shouldn't be empty")
	private String username;
	
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", message = "Password should contain in the given format. Ex:Saikiran@123")
	private String password;

	
//	@Pattern(regexp = "^[6789][0-9]{9}$",message = "mobile number should contain 10 digits and start with 6 or 7 or 8 or 9 ")
	private Long mobileno;
	
	@OneToMany(targetEntity = EmpSkill.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "empskill_id")
	private List<EmpSkill> empskill= new ArrayList<>();
	
	@OneToMany(targetEntity = EmpRating.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "emprate_id")
	@JsonManagedReference
	private List<EmpRating> emprating = new ArrayList<>();


//public Employee(Long id, String email, String username, String password, Long mobileno) {
//	super();
//	this.id = id;
//	this.email = email;
//	this.username = username;
//	this.password = password;
//	this.mobileno = mobileno;
//}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Long getMobileno() {
	return mobileno;
}


public void setMobileno(Long mobileno) {
	this.mobileno = mobileno;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
			+ ", mobileno=" + mobileno + "]";
}


public EmpSkill getEmpSkill() {
	// TODO Auto-generated method stub
	return null;
}
	
	

}
