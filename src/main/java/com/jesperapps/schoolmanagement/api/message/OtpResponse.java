package com.jesperapps.schoolmanagement.api.message;

public class OtpResponse extends BaseResponse{

	public OtpResponse() {
		super();
	}
	
	public OtpResponse(Integer code, String description) {
		super(code, description);
	}
}
