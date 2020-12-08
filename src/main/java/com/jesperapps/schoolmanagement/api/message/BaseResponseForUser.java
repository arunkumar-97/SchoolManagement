 package com.jesperapps.schoolmanagement.api.message;

public  abstract class BaseResponseForUser {

	public static final int SUCCESS = 200;
	public static final int FAILURE = 400;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Integer statusCode;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String description;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Integer errorCode;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String message;
	
	
	public BaseResponseForUser() {
	
	}
	
	public BaseResponseForUser(int statuscode, String description) {
	
		this.statusCode=statuscode;
		this.description=description;
	}
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static int getSuccess() {
		return SUCCESS;
	}

	public static int getFailure() {
		return FAILURE;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
}
