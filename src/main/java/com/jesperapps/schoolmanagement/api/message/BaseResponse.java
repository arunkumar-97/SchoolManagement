package com.jesperapps.schoolmanagement.api.message;

public  abstract class BaseResponse {
	
	public static final int SUCCESS = 200;
	public static final int FAILURE = 400;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Integer statusCode;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String description;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Integer errorCode;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String message;;
	
	public BaseResponse(Integer statusCode2, String description2) {
		this.statusCode=statusCode2;
		this.description=description2;
	}

	public BaseResponse() {
		// TODO Auto-generated constructor stub
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public Integer setStatusCode(Integer statusCode) {
		return this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public String setDescription(String description) {
		return this.description = description;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public Integer setErrorCode(Integer errorCode) {
		return this.errorCode = errorCode;
	}

	public static int getSuccess() {
		return SUCCESS;
	}

	public static int getFailure() {
		return FAILURE;
	}

	public String getMessage() {
		return message;
	}

	public String setMessage(String message) {
		return this.message = message;
	}

	

}
