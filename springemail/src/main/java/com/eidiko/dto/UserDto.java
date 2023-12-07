package com.eidiko.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDto {

	@NotEmpty(message="user name shouldn't be empty!")
	private String userName;
	@NotEmpty(message = "email shouldn't be empty!")
	@Email(message = "Invalid Email!")
	private String mail;
	@NotNull(message = "mobile number shouldn't be empty!")
	@Pattern(regexp = "^[6789][0-9]{9}$",message = "mobile number should contain 10 digits and start with 6 or 7 or 8 or 9 ")
	private String mobile;
    @Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*~!]).{8,}$",message = "password should contain size greater than 8, atleast one cpatial and one small and one digit and one special character ")
	private String password;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(@NotEmpty(message = "user name shouldn't be empty!") String userName,
			@NotEmpty(message = "email shouldn't be empty!") @Email(message = "Invalid Email!") String mail,
			@NotNull(message = "mobile number shouldn't be empty!") @Pattern(regexp = "^[6789][0-9]{9}$", message = "mobile number should contain 10 digits and start with 6 or 7 or 8 or 9 ") Long mobile,
			@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*~!]).{8,}$", message = "password should contain size greater than 8, atleast one cpatial and one small and one digit and one special character ") String password) {
		super();
		this.userName = userName;
		this.mail = mail;
		this.mobile = String.valueOf(mobile);
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Long getMobile() {
		return Long.valueOf(mobile);
	}
	public void setMobile(Long mobile) {
		this.mobile = String.valueOf(mobile);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
