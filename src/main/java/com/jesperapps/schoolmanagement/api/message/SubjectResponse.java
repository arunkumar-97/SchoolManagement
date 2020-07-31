package com.jesperapps.schoolmanagement.api.message;

public class SubjectResponse {

	
	private Integer subjectId;
	private String subjectName;
	private String status;
	
	public SubjectResponse() {
	}
	
	public SubjectResponse(Integer subjectId, String subjectName, String status) {
	
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.status = status;
	}
	
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
