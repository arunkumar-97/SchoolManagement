package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.UserType;

public class UserTypeResponse {
	
	private Integer userTypeId;
	private String userTypeRole;
	
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
	
	
	public UserTypeResponse() {
		
	}
	public UserTypeResponse(Integer userTypeId, String userTypeRole) {
		
		this.userTypeId = userTypeId;
		this.userTypeRole = userTypeRole;
	}
	
	public UserTypeResponse(UserType userType) {
		this.userTypeId=userType.getUserTypeId();
		this.userTypeRole=userType.getUserTypeRole();
	}
	
	
	

}
