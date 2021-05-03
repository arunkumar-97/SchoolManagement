package com.jesperapps.schoolmanagement.api.message;

public class SubjectBaseResponse extends BaseResponse {

	private SubjectResponse subject;

	public SubjectBaseResponse(int i, String string) {
		// TODO Auto-generated constructor stub
		super(i,string);
	}

	public SubjectResponse getSubject() {
		return subject;
	}
	
//	public SubjectBaseResponse(int statusCode, String description) {
//		super(statusCode, description);
//	}

	public void setSubject(SubjectResponse subject) {
		this.subject = subject;
	}
}
