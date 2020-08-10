package com.jesperapps.schoolmanagement.api.message;

public class UserTypeRequest {
	
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
	
	
}
