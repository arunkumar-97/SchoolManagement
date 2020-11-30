package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkAnswerJSON;

@Entity
public class OneMarkAnswers {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="option_Id")
	private Integer optionId;
	
	@Column(name="options")
	private String options;
	
	@Column(name="status")
	private String status;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="oneMarkQuestionId",referencedColumnName = "oneMarkQuestionId")
	private OneMarkQuestion question;
	
	public OneMarkAnswers() {
		
	}
	
	
	
	public OneMarkAnswers(OneMarkAnswerJSON eachRequestAnswer) {
		this.options=eachRequestAnswer.getOption();
		this.status=eachRequestAnswer.getStatus();
	}
	
	
	
	public Integer getOptionId() {
		return optionId;
	}
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}
	public String getOption() {
		return options;
	}
	public void setOption(String option) {
		this.options = option;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OneMarkQuestion getQuestion() {
		return question;
	}
	public void setQuestion(OneMarkQuestion question) {
		this.question = question;
	}
	
	
	
	
}
