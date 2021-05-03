package com.jesperapps.schoolmanagement.api.modelmessage;

import com.jesperapps.schoolmanagement.api.model.AnswerContent;

public class AnswerContentJSON {

	private Integer answerContentId;
	private String answerConent;
	private String label;
	private AnswerAttachmentJSON answerAttachmentJSON;
	
	public AnswerContentJSON() {
		
	}
	
	
	public AnswerContentJSON(AnswerContent content) {
		// TODO Auto-generated constructor stub
		this.answerContentId=content.getAnswerContentId();
		this.answerConent=content.getAnswerConent();
		this.label=content.getLabel();
		this.answerAttachmentJSON=new AnswerAttachmentJSON(content.getImageAttachment());
		
	}
	public Integer getAnswerContentId() {
		return answerContentId;
	}
	public void setAnswerContentId(Integer answerContentId) {
		this.answerContentId = answerContentId;
	}
	public String getAnswerConent() {
		return answerConent;
	}
	public void setAnswerConent(String answerConent) {
		this.answerConent = answerConent;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public AnswerAttachmentJSON getAnswerAttachmentJSON() {
		return answerAttachmentJSON;
	}
	public void setAnswerAttachmentJSON(AnswerAttachmentJSON answerAttachmentJSON) {
		this.answerAttachmentJSON = answerAttachmentJSON;
	}


//	@Override
//	public String toString() {
//		return "AnswerContentJSON [answerContentId=" + answerContentId + ", answerConent=" + answerConent + ", label="
//				+ label + ", answerAttachmentJSON=" + answerAttachmentJSON + "]";
//	}
	
	
	
	
	
	
}
