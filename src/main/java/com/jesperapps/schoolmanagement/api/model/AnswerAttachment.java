package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;



@Entity
public class AnswerAttachment {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer attachmentId;
	private String name;
	private String type;
	@Column(columnDefinition ="LONGTEXT")
	private String fileByte;
	@OneToOne(mappedBy="imageAttachment")
	private Answers answer;
	
	public Integer getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
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
	
	public Answers getAnswer() {
		return answer;
	}
	public void setAnswer(Answers answer) {
		this.answer = answer;
	}
	public AnswerAttachment() {
		super();
	}
	public AnswerAttachment(AnswerAttachmentJSON attachment) {

		this.name=attachment.getName();
		this.type=attachment.getType();
		this.fileByte=attachment.getFileByte();
	}
	
	
	

}
