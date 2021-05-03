package com.jesperapps.schoolmanagement.api.message;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;

public class ClassRequest {
	
	
	
	private Integer classId;
	private String className;
	private String status;
	private Medium medium;
	private EducationBoard educationBoard;

	

	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	public EducationBoard getEducationBoard() {
		return educationBoard;
	}
	public void setEducationBoard(EducationBoard educationBoard) {
		this.educationBoard = educationBoard;
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
