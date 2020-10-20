package com.jesperapps.schoolmanagement.api.modelmessage;

import com.jesperapps.schoolmanagement.api.model.Answers;

public class AnswerJson {
	
	private Integer answerId;
	private String label;
	private String answer;
	private AnswerAttachmentJSON image;
	
	
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public AnswerAttachmentJSON getImage() {
		return image;
	}
	public void setImage(AnswerAttachmentJSON image) {
		this.image = image;
	}
	
	public AnswerJson() {
		
	}
	public AnswerJson(Answers answers) {
		this.answerId=answers.getAnswerId();
		this.label=answers.getLabel();
		this.answer=answers.getAnswer();
		if(answers.getImageAttachment()!=null) {
		this.image= new AnswerAttachmentJSON(answers.getImageAttachment());
		}
		}


}
