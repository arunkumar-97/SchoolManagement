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
	    private Integer pictureId;
	    private String pictureName;
	    private String pictureLocation;
	@OneToOne(mappedBy="imageAttachment")
	private Answers answer;
	
	public AnswerAttachment() {
		super();
	}
	
	
	public AnswerAttachment(AnswerAttachmentJSON image) {
		this.pictureName=image.getName();
	}
	
	public Integer getPictureId() {
		return pictureId;
	}
	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getPictureLocation() {
		return pictureLocation;
	}
	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}
	public Answers getAnswer() {
		return answer;
	}
	public void setAnswer(Answers answer) {
		this.answer = answer;
	}
	
	
	
	
	

}
