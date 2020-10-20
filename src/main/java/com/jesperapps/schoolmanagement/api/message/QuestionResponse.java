package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;


public class QuestionResponse extends BaseResponse {
	
	private List<QuestionJson> question;
	
	
	
	public QuestionResponse() {
		
	}
	

	public QuestionResponse(Integer statusCode, String description) {
		super(statusCode, description);
	}


	public List<QuestionJson> getQuestion() {
		return question;
	}


	


	public void setQuestion(QuestionJson requestQuestionJson) {
		if(this.question== null) {
			this.question=new ArrayList<>();
		}
		if(requestQuestionJson != null) {
			this.question.add(requestQuestionJson);	
		}
	}

}
