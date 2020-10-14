package com.jesperapps.schoolmanagement.api.model;

public class Attachment {
	private Integer id;
	private String attachmentName;
	private String attachmentType;
	private String fileByte;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	public String getFileByte() {
		return fileByte;
	}
	public void setFileByte(String fileByte) {
		this.fileByte = fileByte;
	}
	
	
}
