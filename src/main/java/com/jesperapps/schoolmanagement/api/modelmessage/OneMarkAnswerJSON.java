package com.jesperapps.schoolmanagement.api.modelmessage;

import com.jesperapps.schoolmanagement.api.model.OneMarkAnswers;

public class OneMarkAnswerJSON {

	
	private Integer optionId;
	private String option;
	private String status;
	
	
	public OneMarkAnswerJSON() {
		
	}
	
	public OneMarkAnswerJSON(OneMarkAnswers eachAnswer) {
		this.optionId=eachAnswer.getOptionId();
		this.option=eachAnswer.getOption();
		this.status=eachAnswer.getStatus();
	}
	
	public Integer getOptionId() {
		return optionId;
	}
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
