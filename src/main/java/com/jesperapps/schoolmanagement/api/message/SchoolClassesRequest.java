package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;
import com.jesperapps.schoolmanagement.api.model.Class;

public class SchoolClassesRequest {
	
	private Class clas;
	private School school;
	private SchoolEducationBoard schoolEducationBoard;
	private SchoolMedium schoolMedium;
	
	
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
	
	

}
