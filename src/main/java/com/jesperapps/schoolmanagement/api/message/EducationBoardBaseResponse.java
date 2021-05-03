package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;

public class EducationBoardBaseResponse extends BaseResponse {
	
	private EducationBoardResponse educationBoard;
	
	
	public EducationBoardBaseResponse() {
		
	}

	public EducationBoardBaseResponse(int i, String string) {
		// TODO Auto-generated constructor stub
		super(i,string);
	}

	
	

	public EducationBoardResponse getEducationBoard() {
		return educationBoard;
	}

	public void setEducationBoard(EducationBoardResponse educationBoard) {
		this.educationBoard = educationBoard;
	}
	
	
	
	

}
