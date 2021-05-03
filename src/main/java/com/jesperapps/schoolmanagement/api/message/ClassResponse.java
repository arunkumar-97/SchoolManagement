package com.jesperapps.schoolmanagement.api.message;



import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;


//import com.jesperapps.schoolmanagement.api.model.EducationBoard;
//import com.jesperapps.schoolmanagement.api.model.Medium;


public class ClassResponse extends BaseResponse {

	private Integer classId;
	private String className;
	private String status;
	private Medium medium;
	private EducationBoard educationBoard;

	
	

	public ClassResponse() {
		
	
	}
	
	
	
	public ClassResponse(Class cls) {
		
		this.classId = cls.getClassId();
		this.className = cls.getClassName();
		this.status = cls.getStatus();
		this.medium=cls.getMedium();
		this.educationBoard=cls.getEducationBoard()!=null? cls.getEducationBoard():null;
//		this.school=cls.getSchool();
	}
	


	public ClassResponse(ClassResponse subscriptionClass) {
		this.classId=subscriptionClass.getClassId();
		this.className=subscriptionClass.getClassName();
	}


//	public ClassResponse(int i, String string) {
//	this.statuscode=i;
//	this.description=string;
//	}


	


	public ClassResponse(Integer classId2, String className2, String status2, Medium medium2,
			EducationBoard educationBoard2) {
		this.classId=classId2;
		this.className=className2;
		this.status=status2;
		this.medium=medium2;
		this.educationBoard=educationBoard2;
		
	}

	



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
