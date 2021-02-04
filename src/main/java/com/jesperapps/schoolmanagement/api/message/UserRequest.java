package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserType;

public class UserRequest extends BaseResponse {
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private Long phoneNumber;
	private UserType userType;
	
	
	
	public UserRequest(User userData) {
		// TODO Auto-generated constructor stub
		this.userId=userData.getUserId();
		this.userName=userData.getUserName();
		this.email=userData.getEmail();
		this.password=userData.getPassword();
		this.confirmPassword=userData.getConfirmPassword();
		this.phoneNumber=userData.getPhoneNumber();
		this.userType=userData.getUserType();
	}

	public UserRequest() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	

}
