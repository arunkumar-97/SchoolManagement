package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassJSON;

public class OneMarkYearContent {
	
	private ClassJSON clas;
	private SubjectJSON subject;
	private YearJSON year;
	private List<OneMarkQuestionJSON> mcq;
	
	
	public ClassJSON getClas() {
		return clas;
	}
	public void setClas(ClassJSON clas) {
		this.clas = clas;
	}
	public SubjectJSON getSubject() {
		return subject;
	}
	public void setSubject(SubjectJSON subject) {
		this.subject = subject;
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
