package com.jesperapps.schoolmanagement.api.modelmessage;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

public class AnswerAttachmentJSON {
	
	private String name;
	private String type;
	private String viewUrl;
	
	//only for request purpose
	private String fileByte;
	
	public String getFileByte() {
		return fileByte;
	}

	public void setFileByte(String fileByte) {
		this.fileByte = fileByte;
	}

	public AnswerAttachmentJSON() {
		
	}
	
	public AnswerAttachmentJSON(AnswerAttachment answerAttachment) {
		this.name=answerAttachment.getPictureName();
		this.setType("unknown");
		String pictureName = answerAttachment.getPictureName();
		if(pictureName.contains(".")) {
			String[] fileNameAndFileType = pictureName.split("\\.");
			if(fileNameAndFileType.length > 0) {
				this.setType(fileNameAndFileType[fileNameAndFileType.length-1]);	
			}
		}
		this.viewUrl=answerAttachment.getPictureLocation();
	}
	
	
	public AnswerAttachmentJSON(TopicAttachment topicAttachment) {
		this.name=topicAttachment.getPictureName();
		this.setType("unknown");
		String pictureName = topicAttachment.getPictureName();
		if(pictureName.contains(".")) {
			String[] fileNameAndFileType = pictureName.split("\\.");
			if(fileNameAndFileType.length > 0) {
				this.setType(fileNameAndFileType[fileNameAndFileType.length-1]);	
			}
		}
		this.viewUrl=topicAttachment.getPictureLocation();
	}


	

	



	public AnswerAttachmentJSON(AnswerAttachmentJSON eachAttachment) {
		this.name=eachAttachment.getName();
		this.type=eachAttachment.getType();
		this.viewUrl=eachAttachment.getViewUrl();
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

	public String getViewUrl() {
		return viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}
	





	

}
