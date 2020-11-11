package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkQuestionJSON;


public class OneMarkQuestionResponse  extends BaseResponse{

	private List<OneMarkQuestionJSON> question;
	

	public OneMarkQuestionResponse() {
		
	}
	

	public OneMarkQuestionResponse(Integer statusCode, String description) {
		super(statusCode, description);
	}


	public List<OneMarkQuestionJSON> getQuestion() {
		return question;
	}



	public void setQuestion(OneMarkQuestionJSON eachQuestion) {

		if(this.question== null) {
			this.question=new ArrayList<>();
		}
		if(eachQuestion != null) {
			this.question.add(eachQuestion);	
		}
		
	}

	
	
	
}
