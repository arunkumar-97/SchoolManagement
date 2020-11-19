package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.service.TopicAttachmentService;;


@Entity
public class TopicAttachment {
	
	 @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer pictureId;
	    private String pictureName;
	    private String pictureLocation;
	    private String previewLocation;
	    @ManyToOne
		@JoinColumn(name="topicId", referencedColumnName="topicId")
		private Topic topic;
	    
	    
	
	    
	    public TopicAttachment() {
	    	super();
	    }
	    
	    @PrePersist
	    public void updateAttachmentURLAfterSaving() {
	    	this.setPictureLocation(TopicAttachmentService.BASE_URL+"/"+this.getPictureId());
			this.setPreviewLocation(TopicAttachmentService.PREVIEW_URL+"/"+this.getPictureId());
			
	    }
	    
		public TopicAttachment(AnswerAttachmentJSON attachmentRequest) {
			this.pictureName=attachmentRequest.getName();
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
		public Topic getTopic() {
			return topic;
		}
		public void setTopic(Topic topic) {
			this.topic = topic;
		}
		public String getPreviewLocation() {
			return previewLocation;
		}
		public void setPreviewLocation(String previewLocation) {
			this.previewLocation = previewLocation;
		}
	    
	    
	    
	    

}
