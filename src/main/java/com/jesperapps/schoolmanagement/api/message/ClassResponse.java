package com.jesperapps.schoolmanagement.api.message;



import com.jesperapps.schoolmanagement.api.model.Class;

//import com.jesperapps.schoolmanagement.api.model.EducationBoard;
//import com.jesperapps.schoolmanagement.api.model.Medium;


public class ClassResponse extends BaseResponse {

	private Integer classId;
	private String className;
	private String status;
	private String medium;
	private String educationBoard;
	
	

	public ClassResponse() {
		
	}
	
	
	public ClassResponse(Class cls) {
		this.classId = cls.getClassId();
		this.className = cls.getClassName();
		this.status = cls.getStatus();
		this.medium=cls.getMedium().getMediumLanguage();
		this.educationBoard=cls.getEducationBoard()!=null? cls.getEducationBoard().getEducationBoardName():null;
	}
	
	
	public ClassResponse(Integer classId, String className, String status,String medium,String educationBoard) {
		
		this.classId = classId;
		this.className = className;
		this.status = status;
		this.medium=medium;
		this.educationBoard=educationBoard;
	}

	public ClassResponse(ClassResponse subscriptionClass) {
		this.classId=subscriptionClass.getClassId();
		this.className=subscriptionClass.getClassName();
	}


	public ClassResponse(int i, String string) {
	this.statuscode=i;
	this.description=string;
	}


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



	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
}


	



}
