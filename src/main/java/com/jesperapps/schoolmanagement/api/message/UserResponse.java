package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.User;
//import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;

public class UserResponse {

	
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private int phoneNumber;
	private String userType;
	private String userProfilePicture;
	private String confirmPassword;
	private String authenticationType;

	public UserResponse() {
		
	}
	
	public UserResponse(User user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phoneNumber = user.getPhoneNumber();
		this.userType = user.getUserType() != null? user.getUserType().getUserTypeRole() : null;
		this.userProfilePicture=user.getUserProfile().getPictureName();
	}
	
	
	
	public String getUserProfilePicture() {
		return userProfilePicture;
	}

	public void setUserProfilePicture(String userProfilePicture) {
		this.userProfilePicture = userProfilePicture;
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAuthenticationType() {
		return authenticationType;
	}

	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}

	
	
}
