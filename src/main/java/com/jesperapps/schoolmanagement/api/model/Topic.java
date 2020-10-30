package com.jesperapps.schoolmanagement.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Topic {
	
	
	@Id
	private Integer topicId;
	private String topicName;
	
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="topic")
	private List<TopicAttachment> topicAttachment;
	
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public List<TopicAttachment> getTopicAttachment() {
		return topicAttachment;
	}
	public void setTopicAttachment(List<TopicAttachment> topicAttachment) {
		this.topicAttachment = topicAttachment;
	}
	
	public void addAttachment(TopicAttachment attachment) {
		if(this.topicAttachment == null) {
			this.topicAttachment = new ArrayList<>();
		}
		if(attachment != null) {
			this.topicAttachment.add(attachment);
		}
	}
	

}
