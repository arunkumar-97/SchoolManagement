package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;

public class SchoolEducationBoardResponse extends BaseResponse 	 {

	private Integer schoolEducationBoardId;
	private School school;
	private EducationBoard educationBoard;
	
	
	public SchoolEducationBoardResponse() {
		
	}
	
	public SchoolEducationBoardResponse(SchoolEducationBoard schooleducationBoard) {
		// TODO Auto-generated constructor stub
		this.schoolEducationBoardId=schooleducationBoard.getSchoolEducationBoardId();
		this.educationBoard=schooleducationBoard.getEducationBoards();
	}

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

	public Integer getSchoolEducationBoardId() {
		return schoolEducationBoardId;
	}

	public void setSchoolEducationBoardId(Integer schoolEducationBoardId) {
		this.schoolEducationBoardId = schoolEducationBoardId;
	}
	
	
	
	
	
}
