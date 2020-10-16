package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.User;

public class UserSubscriptionResponse {
	private String userName;
	private String email;
//	private String password;
	private Long phoneNumber;
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
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public UserTypeRequest getUserType() {
		return userType;
	}
	public void setUserType(UserTypeRequest userType) {
		this.userType = userType;
	}
	
	public UserSubscriptionResponse(User user) {
		this.email = user.getEmail();
//		this.password = user.getPassword();
		this.phoneNumber = user.getPhoneNumber();
		this.userName = user.getUserName();
		this.userType = new UserTypeRequest(user.getUserType());
	}
	
}
