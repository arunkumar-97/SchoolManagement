package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;

public class EducationBoardJson {

	private Integer educationBoardId;
	private String educationBoardName;
	
	public EducationBoardJson() {}
	
	public EducationBoardJson(EducationBoard educationBoard) {
		this.educationBoardId = educationBoard.getEducationBoardId();
		this.educationBoardName = educationBoard.getEducationBoardName();
	}
	
	public Integer getEducationBoardId() {
		return educationBoardId;
	}
	public void setEducationBoardId(Integer educationBoardId) {
		this.educationBoardId = educationBoardId;
	}
	public String getEducationBoardName() {
		return educationBoardName;
	}
	public void setEducationBoardName(String educationBoardName) {
		this.educationBoardName = educationBoardName;
	}
	
	
}
