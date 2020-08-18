package com.jesperapps.schoolmanagement.api.message;

public class UserRequest {
	
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private int phoneNumber;
	private UserTypeRequest userType;
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserTypeRequest getUserType() {
		return userType;
	}

	public void setUserType(UserTypeRequest userType) {
		this.userType = userType;
	}


}
