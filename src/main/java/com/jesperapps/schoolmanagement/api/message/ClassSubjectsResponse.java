package com.jesperapps.schoolmanagement.api.message;


import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.Subject;

public class ClassSubjectsResponse extends BaseResponse{
	
	
	private String status;

	private SchoolClasses schoolClasses;
	private Subject subject;
	
	
	public ClassSubjectsResponse() {
	
	}

	public ClassSubjectsResponse(ClassSubjectsRequest userResponseEntity) {
		// TODO Auto-generated constructor stub
		
		this.status=userResponseEntity.getStatus();
		this.schoolClasses=userResponseEntity.getSchoolClasses();
		this.subject=userResponseEntity.getSubject();
	}
	public ClassSubjectsResponse(int i, String string) {
		// TODO Auto-generated constructor stub
		super(i,string);
	}

	public ClassSubjectsResponse(ClassSubjects classSubjects) {
		// TODO Auto-generated constructor stub
		this.status=classSubjects.getStatus();
		this.schoolClasses=classSubjects.getSchoolClasses();
		this.subject=classSubjects.getSubject();
	}

	public SchoolClasses getSchoolClasses() {
		return schoolClasses;
	}
	public void setSchoolClasses(SchoolClasses schoolClasses) {
		this.schoolClasses = schoolClasses;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
