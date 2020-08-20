package com.jesperapps.schoolmanagement.api.message;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserRequestWithProfilePicture {

	private String userName;
	private String email;
	private String password;
	private int phoneNumber;
	private String authenticationType;
	private UserTypeRequest userType;
	private Attachment attachment;
	
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	public UserTypeRequest getUserType() {
		return userType;
	}
	public void setUserType(UserTypeRequest userType) {
		this.userType = userType;
	}
	public String getAuthenticationType() {
		return authenticationType;
	}
	public void setAuthentication(String authentication) {
		this.authenticationType = authentication;
	}
	
	
}
