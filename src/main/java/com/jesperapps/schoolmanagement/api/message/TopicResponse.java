package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Topic;

public class TopicResponse extends BaseResponse {
	
	private Integer topicId;
	private String topicName;
	
	
	public TopicResponse() {
		
	}
	
	public TopicResponse(Integer topicId2, String topicName2) {
		this.topicId=topicId2;
		this.topicName=topicName2;
	}
	public TopicResponse(Topic topic) {
		this.topicId=topic.getTopicId();
		this.topicName=topic.getTopicName();
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
