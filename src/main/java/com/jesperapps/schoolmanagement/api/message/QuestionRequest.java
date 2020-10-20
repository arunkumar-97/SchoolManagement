package com.jesperapps.schoolmanagement.api.message;

public class QuestionRequest {
	
	private Integer questionId;

	private String question;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

}
