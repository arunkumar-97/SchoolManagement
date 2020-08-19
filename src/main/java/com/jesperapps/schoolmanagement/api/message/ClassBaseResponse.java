package com.jesperapps.schoolmanagement.api.message;

public class ClassBaseResponse extends BaseResponse{
	
	private ClassResponse Classes;
	
	public ClassBaseResponse(int statuscode,String description) {
		this.statuscode=statuscode;
		this.description=description;
		
	}

	public ClassBaseResponse() {
		
	}

	public ClassResponse getClasses() {
		return Classes;
	}

	public void setCls(ClassResponse classes) {
		Classes = classes;
	}

	
	

	
}