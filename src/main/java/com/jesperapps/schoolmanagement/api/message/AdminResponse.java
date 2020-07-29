package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Admin;

public class AdminResponse {

	
	private int adminId;
	private String adminName;
	private String eMail;
	private String password;
	private int phoneNumber;
	
	public AdminResponse() {
		
	}
	
	public AdminResponse(Admin admin) {
		this.adminId = admin.getAdminId();
		this.adminName = admin.getAdminName();
		this.eMail = admin.geteMail();
		this.password = admin.getPassword();
		this.phoneNumber = admin.getPhoneNumber();
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
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
	
	
}
