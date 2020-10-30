package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Topic;

public class TopicRequest {
	
	private Integer topicId;
	private String topicName;
	
	public TopicRequest() {
		
	}

	
	public TopicRequest(Topic topic) {
		this.setTopicId(topic.getTopicId());
		this.setTopicName(topic.getTopicName());
	}
	
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
	
	
	
	

}
