package com.jesperapps.schoolmanagement.api.modelmessage;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;

public class AnswerAttachmentJSON {
	
	private String name;
	private String type;
	private String fileByte;
	
	public AnswerAttachmentJSON() {
		
	}
	
	public AnswerAttachmentJSON(AnswerAttachment answerAttachment) {
		this.name=answerAttachment.getPictureName();
		this.fileByte=answerAttachment.getPictureLocation();
	}
	
	



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileByte() {
		return fileByte;
	}
	public void setFileByte(String fileByte) {
		this.fileByte = fileByte;
	}





	

}
