package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.User;

public class UserResponse {

	
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private int phoneNumber;
	private String userRole;

	public UserResponse() {
		
	}
	
	public UserResponse(User admin) {
		this.userId = admin.getUserId();
		this.userName = admin.getUserName();
		this.email = admin.getEmail();
		this.password = admin.getPassword();
		this.phoneNumber = admin.getPhoneNumber();
		this.userRole = admin.getUserType() != null? admin.getUserType().getUserTypeRole() : null;
	}
	
	
	public Integer getAdminId() {
		return userId;
	}

	public void setAdminId(Integer userId) {
		this.userId = userId;
	}

	public String getAdminName() {
		return userName;
	}
	public void setAdminName(String userName) {
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
