package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.List;

public class SubjectContent {

	private SubjectJSON subject;
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
	
	
	
}
