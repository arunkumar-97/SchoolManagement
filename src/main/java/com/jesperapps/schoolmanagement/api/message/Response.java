package com.jesperapps.schoolmanagement.api.message;

public class Response extends BaseResponse{
	public Response() {
		super();
	}
	public Response(Integer code, String description) {
		super(code, description);
	}
}
