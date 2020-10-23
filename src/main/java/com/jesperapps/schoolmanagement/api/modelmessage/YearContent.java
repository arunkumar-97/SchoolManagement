package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassJSON;

public class YearContent {
	
	private ClassJSON clas;
	private SubjectJSON subject;
	private YearJSON year;
	private List<QuestionJson> question;
	
	public SubjectJSON getSubject() {
		return subject;
	}
	public void setSubject(SubjectJSON subject) {
		this.subject = subject;
	}
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
	public ClassJSON getClas() {
		return clas;
	}
	public void setClas(ClassJSON clas) {
		this.clas = clas;
	}
	
	
	

}
