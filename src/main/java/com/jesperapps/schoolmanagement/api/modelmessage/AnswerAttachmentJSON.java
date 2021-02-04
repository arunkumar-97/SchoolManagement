package com.jesperapps.schoolmanagement.api.modelmessage;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

public class AnswerAttachmentJSON {
	
	private Integer id;
	private String name;
	private String type;
	private String viewUrl;
	private String previewUrl;
	private String downloadUrl;
	//only for request purpose
	private String fileByte;
	private String previewfileByte;
	public String getFileByte() {
		return fileByte;
	}

	public void setFileByte(String fileByte) {
		this.fileByte = fileByte;
	}

	public AnswerAttachmentJSON() {
		
	}
	
	public AnswerAttachmentJSON(AnswerAttachment answerAttachment) {
		String HOST_NAME = "https://www.jespersoft.com:6007/schoolQA";
		this.name=answerAttachment.getPictureName();
		this.setType("unknown");
		String pictureName = answerAttachment.getPictureName();
		if(pictureName.contains(".")) {
			String[] fileNameAndFileType = pictureName.split("\\.");
			if(fileNameAndFileType.length > 0) {
				this.setType(fileNameAndFileType[fileNameAndFileType.length-1]);	
			}
		}
		String urlFromDB = answerAttachment.getPictureLocation();
		if(urlFromDB.contains(":")) {
			this.viewUrl = urlFromDB;
		}else {
		this.viewUrl= HOST_NAME +answerAttachment.getPictureLocation();
		
	}
	}
	
	public AnswerAttachmentJSON(TopicAttachment topicAttachment) {
		
	String HOST_NAME = "https://www.jespersoft.com:6007/schoolQA";
		
//		String HOST_NAME="http://192.168.1.248:8080";
		
		this.id=topicAttachment.getPictureId();
		this.name=topicAttachment.getPictureName();
		this.setType("unknown");
		String pictureName = topicAttachment.getPictureName();
		if(pictureName.contains(".")) {
			String[] fileNameAndFileType = pictureName.split("\\.");
			if(fileNameAndFileType.length > 0) {
				this.setType(fileNameAndFileType[fileNameAndFileType.length-1]);	
			}
		}
		String urlFromDB = topicAttachment.getPictureLocation();
		if(urlFromDB.contains(":")) {
			this.viewUrl = urlFromDB;
		}else {
		this.viewUrl=HOST_NAME + topicAttachment.getPictureLocation();
		this.previewUrl=HOST_NAME +topicAttachment.getPreviewLocation();
		this.downloadUrl=HOST_NAME+"/"+"topic/"+"download_attachment/"+topicAttachment.getPictureId();
		System.out.println(topicAttachment.getPreviewLocation());
		}
	}


	

	



	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPreviewfileByte() {
		return previewfileByte;
	}

	public void setPreviewfileByte(String previewfileByte) {
		this.previewfileByte = previewfileByte;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}
	





	

}
