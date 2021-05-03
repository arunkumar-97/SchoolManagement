package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.School;

public class SchoolEducationBoardRequest {

	
	
	private School school;
	private EducationBoard educationBoard;
	
	
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public EducationBoard getEducationBoard() {
		return educationBoard;
	}
	public void setEducationBoard(EducationBoard educationBoard) {
		this.educationBoard = educationBoard;
	}
	
	
	
	
	
}
