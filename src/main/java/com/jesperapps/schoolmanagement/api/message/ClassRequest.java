package com.jesperapps.schoolmanagement.api.message;

public class ClassRequest {
	
	
	
	private Integer classId;
	private String className;
	private String status;
	private String medium;
	private String educationBoard;
	
	
	
	public String getEducationBoard() {
		return educationBoard;
	}
	public void setEducationBoard(String educationBoard) {
		this.educationBoard = educationBoard;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public Integer getClassId() 
	{
		return classId;
	}
	public void setClassId(Integer classId)
	{
		this.classId = classId;
	}
	public String getClassName()
	{
		return className;
	}
	public void setClassName(String className)
	{
		this.className = className;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
