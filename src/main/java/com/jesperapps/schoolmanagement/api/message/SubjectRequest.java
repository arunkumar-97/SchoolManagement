package com.jesperapps.schoolmanagement.api.message;




public class SubjectRequest {
	
	private Integer subjectId;
	private String subjectName;
	private String status;
	private ClassJSON clas;
	
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
	public ClassJSON getClas() {
		return clas;
	}
	public void setClas(ClassJSON Clas) {
		clas = Clas;
	}

	
	
	
	
	
	
	

}
