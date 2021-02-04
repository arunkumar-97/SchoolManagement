package com.jesperapps.schoolmanagement.api.model;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.Id;

@Entity

public class UserType {
	
	@Id

	private Integer userTypeId;

	private String userTypeRole;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userType")
	private List<User> user;
	
	

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	

	

	public String getUserTypeRole() {
		return userTypeRole;
	}

	public void setUserTypeRole(String userTypeRole) {
		this.userTypeRole = userTypeRole;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

public UserType() {
		
	}

	public UserType(int id, String admin) {
		this.userTypeId=id;
		this.userTypeRole=admin;
	}

	

}
