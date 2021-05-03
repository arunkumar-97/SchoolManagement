package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;

public class SchoolClassesResponse extends BaseResponse{
	
	
	private Integer schoolClassesId;
	private Class clas;
	private School school;
	private SchoolEducationBoard schoolEducationBoard;
	private SchoolMedium schoolMedium;
	
	
	
	public SchoolClassesResponse(SchoolClassesResponse user) {
		// TODO Auto-generated constructor stub
		this.clas=user.getClas();
		this.school=user.getSchool();
	}
	public SchoolClassesResponse() {
		// TODO Auto-generated constructor stub
	}
	public SchoolClassesResponse(SchoolClasses schoolClasses) {
		this.schoolClassesId=schoolClasses.getSchoolClassesId();
		this.clas=schoolClasses.getClas();
		this.school=schoolClasses.getSchool();
		this.schoolEducationBoard=schoolClasses.getSchoolEducationBoard();
		this.schoolMedium=schoolClasses.getSchoolMedium();													
		
		// TODO Auto-generated constructor stub
	}
	public SchoolClassesResponse(int i, String string) {
		// TODO Auto-generated constructor stub
		super(i,string);
	}
	public Class getClas() {
		return clas;
	}
	public void setClas(Class clas) {
		this.clas = clas;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public SchoolEducationBoard getSchoolEducationBoard() {
		return schoolEducationBoard;
	}
	public void setSchoolEducationBoard(SchoolEducationBoard schoolEducationBoard) {
		this.schoolEducationBoard = schoolEducationBoard;
	}
	public SchoolMedium getSchoolMedium() {
		return schoolMedium;
	}
	public void setSchoolMedium(SchoolMedium schoolMedium) {
		this.schoolMedium = schoolMedium;
	}
	public Integer getSchoolClassesId() {
		return schoolClassesId;
	}
	public void setSchoolClassesId(Integer schoolClassesId) {
		this.schoolClassesId = schoolClassesId;
	}

	
	

}
