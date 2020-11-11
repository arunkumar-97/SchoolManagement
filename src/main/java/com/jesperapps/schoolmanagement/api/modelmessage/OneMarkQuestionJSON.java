package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.ArrayList;
import java.util.List;


import com.jesperapps.schoolmanagement.api.model.OneMarkAnswers;
import com.jesperapps.schoolmanagement.api.model.OneMarkQuestion;



public class OneMarkQuestionJSON {
	
	
	private Integer oneMarkQuestionId;
	private String question;
	
	
	private List<OneMarkAnswerJSON> options;

	private String description;
	

	public OneMarkQuestionJSON() {
		
	}

	public OneMarkQuestionJSON(OneMarkQuestion question2) {
		this.oneMarkQuestionId=question2.getOneMarkQuestionId();
		this.question=question2.getQuestion();
		this.description=question2.getDescription();
		List<OneMarkAnswers> answers=question2.getAnswers();
		if(this.options==null) {
			this.options=new ArrayList<>();
		}
		if(answers != null) {
			for(OneMarkAnswers eachAnswer:answers) {
				this.options.add(new OneMarkAnswerJSON(eachAnswer));
			}
		}
	}


	public Integer getOneMarkQuestionId() {
		return oneMarkQuestionId;
	}


	public void setOneMarkQuestionId(Integer oneMarkQuestionId) {
		this.oneMarkQuestionId = oneMarkQuestionId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public List<OneMarkAnswerJSON> getOptions() {
		return options;
	}


	public void setOptions(List<OneMarkAnswerJSON> options) {
		this.options = options;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
