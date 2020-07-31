package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.User;

public class AdminResponse {

	
	private int adminId;
	private String adminName;
	private String email;
	private String password;
	private int phoneNumber;
	private String userRole;

	public AdminResponse() {
		
	}
	
	public AdminResponse(User admin) {
		this.adminId = admin.getUserId();
		this.adminName = admin.getUserName();
		this.email = admin.getEmail();
		this.password = admin.getPassword();
		this.phoneNumber = admin.getPhoneNumber();
		this.userRole = admin.getUserType() != null? admin.getUserType().getUserTypeRole() : null;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
