package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;

public class EducationBoardResponse extends BaseResponse{
	
	
	private Integer educationBoardId;
	private String educationBoardName;
	
	
	
	public EducationBoardResponse(int i, String string) {
		// TODO Auto-generated constructor stub
		super(i,string);
	}
	public EducationBoardResponse(EducationBoard educationBoard) {
		// TODO Auto-generated constructor stub
		this.educationBoardId=educationBoard.getEducationBoardId();
		this.educationBoardName=educationBoard.getEducationBoardName();
	}
	public EducationBoardResponse() {
		// TODO Auto-generated constructor stub
	}
	public EducationBoardResponse(EducationBoardJson boardReqEntity) {
		// TODO Auto-generated constructor stub
		this.educationBoardId=boardReqEntity.getEducationBoardId();
		this.educationBoardName=boardReqEntity.getEducationBoardName();
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
