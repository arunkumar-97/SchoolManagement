package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassJSON;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;

public class OneMarkYearContent {
	
	private ClassSubjects classSubjects;
	private YearJSON year;
	private List<OneMarkQuestionJSON> mcq;
	

	
	
	
	public ClassSubjects getClassSubjects() {
		return classSubjects;
	}
	public void setClassSubjects(ClassSubjects classSubjects) {
		this.classSubjects = classSubjects;
	}
	public YearJSON getYear() {
		return year;
	}
	public void setYear(YearJSON year) {
		this.year = year;
	}
	public List<OneMarkQuestionJSON> getMcq() {
		return mcq;
	}
	public void setMcq(List<OneMarkQuestionJSON> mcq) {
		this.mcq = mcq;
	}
	
	
	
	
	

}
