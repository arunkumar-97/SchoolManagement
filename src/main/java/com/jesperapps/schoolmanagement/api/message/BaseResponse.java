package com.jesperapps.schoolmanagement.api.message;

public  abstract class BaseResponse {
	
	public int statuscode=200;
	public String description="Listed Succesfully" ;
	
	
	
	
	public BaseResponse() {
	
	}
	
	public BaseResponse(int statuscode, String description) {
	
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
