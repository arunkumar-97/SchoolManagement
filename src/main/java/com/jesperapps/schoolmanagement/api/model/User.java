package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jesperapps.schoolmanagement.api.message.AdminRequest;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String eMail;
	private String password;
	private int phoneNumber;
	
	
	public User() {
		
	}
	
	public User(AdminRequest adminRequest) {
		this.eMail=adminRequest.geteMail();
		this.password=adminRequest.getPassword();
		
	}
	@ManyToOne
	@JoinColumn(name="userTypeId", referencedColumnName ="userTypeId")
	private UserType userType;
	
	
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
