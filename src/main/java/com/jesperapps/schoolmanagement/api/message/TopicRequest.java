package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.Topic;

public class TopicRequest {
	
	private Integer topicId;
	private String topicName;
	private School school;
	public TopicRequest() {
		
	}

	
	public TopicRequest(Topic topic) {
		this.setTopicId(topic.getTopicId());
		this.setTopicName(topic.getTopicName());
		this.setSchool(topic.getSchool());
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


	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}
	
	
	
	

}
