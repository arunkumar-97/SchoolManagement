package com.jesperapps.schoolmanagement.api.message;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.User;
//import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import com.jesperapps.schoolmanagement.api.model.UserType;

public class UserResponse {

	
	private Integer userId;
	private String userName;
	private String email;
//	private String password;
	private int phoneNumber;
	private String userType;
	private String userProfilePicture;
//	private String confirmPassword;
	private String authenticationType;
	private List<SubscriptionResponse> subscriptionForm;

	
	public UserResponse() {
		
	}
	public UserResponse(int statuscode,String decription) {
		
	}
	
	public UserResponse(User user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
//		this.password = user.getPassword();
		this.phoneNumber = user.getPhoneNumber();
		this.userType = user.getUserType() != null? user.getUserType().getUserTypeRole() : null;
		this.userProfilePicture=user.getUserProfile() != null ? user.getUserProfile().getPictureName() : null;
		this.authenticationType=user.getAuthentication();
		this.setSubscriptionFormFromUser(user.getSubscriptionForm());
	}
	
	
	
	public UserResponse(int userId2, String userName2, String email2, String password2, String confirmPassword2,
			String pictureName, String authentication, UserType userType2, Set<SubscriptionForm> subscriptionList) {
		this.userId=userId2;
		this.userName=userName2;
		this.email=email2;
//		this.confirmPassword=confirmPassword2;
		this.userProfilePicture=pictureName;
		this.authenticationType=authentication;
		this.userType=userType2.getUserTypeRole();
		this.setSubscriptionFormFromUser(subscriptionList);
		
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

//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
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

//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}

	public String getAuthenticationType() {
		return authenticationType;
	}

	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}
	public List<SubscriptionResponse> getSubscriptionForm() {
		return subscriptionForm;
	}
	public void setSubscriptionForm(List<SubscriptionResponse> subscriptionForm) {
		this.subscriptionForm = subscriptionForm;
	}
	public void setSubscriptionFormFromUser(Set<SubscriptionForm> subscriptionFormList) {
		if(subscriptionFormList == null) {
			this.subscriptionForm = null;
		}else {
		this.subscriptionForm = subscriptionFormList.stream().map((subscription) -> new SubscriptionResponse(subscription)).collect(Collectors.toList());
		}
		}

	
	
}
