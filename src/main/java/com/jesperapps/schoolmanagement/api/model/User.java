package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.jesperapps.schoolmanagement.api.message.UserRequest;

@Entity
public class User {
	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String email;
	private String password;
	private int phoneNumber;

	@ManyToOne
	@JoinColumn(name="userTypeId", referencedColumnName ="userTypeId")
	private UserType userType;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private ConfirmationToken otpToken;

	@OneToOne
	@JoinColumn(name="userProfilePicture")
	private UserProfilePicture userProfile;
	
	public User() {
		
	}
	
	public User(UserRequest adminRequest) {
		this.email=adminRequest.getEmail();
		this.password=adminRequest.getPassword();
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public ConfirmationToken getOtpToken() {
		return otpToken;
	}

	public void setOtpToken(ConfirmationToken otpToken) {
		this.otpToken = otpToken;
	}

	public UserProfilePicture getUserProfile(){
		return this.userProfile;
	}
	
	public void setUserProfile(UserProfilePicture userProfile){
		this.userProfile = userProfile;
	}

}
