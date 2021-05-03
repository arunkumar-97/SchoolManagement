package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassJSON;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;

public class YearContent {
	
	private ClassSubjects classSubjects;
	private YearJSON year;
	private List<QuestionJson> question;
	
	
	public List<QuestionJson> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuestionJson> question) {
		this.question = question;
	}
	public YearJSON getYear() {
		return year;
	}
	public void setYear(YearJSON year) {
		this.year = year;
	}
	public ClassSubjects getClassSubjects() {
		return classSubjects;
	}
	public void setClassSubjects(ClassSubjects classSubjects) {
		this.classSubjects = classSubjects;
	}
	

	
	
	

}
