package com.jesperapps.schoolmanagement.api.message;

public  abstract class BaseResponseForUser {

	public int statuscode=200;
	public String description="User Registered Succesfully" ;
	
	
	
	
	public BaseResponseForUser() {
	
	}
	
	public BaseResponseForUser(int statuscode, String description) {
	
		this.statuscode=statuscode;
		this.description=description;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
