package com.jesperapps.schoolmanagement.api.message;


import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.Subject;

public class ClassSubjectsRequest extends BaseResponse {

	
	private Integer classSubjectsId;
	private String status;
	private SchoolClasses schoolClasses;
	private Subject subject;
	
	
	
	public ClassSubjectsRequest() {
		
	}

	public ClassSubjectsRequest(ClassSubjects userData) {
		// TODO Auto-generated constructor stub
		this.classSubjectsId=userData.getClassSubjectsId();
		this.status=userData.getStatus();
		this.schoolClasses=userData.getSchoolClasses();
		this.subject=userData.getSubject();
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
	public Integer getClassSubjectsId() {
		return classSubjectsId;
	}
	public void setClassSubjectsId(Integer classSubjectsId) {
		this.classSubjectsId = classSubjectsId;
	}
	
	
	
	
}
