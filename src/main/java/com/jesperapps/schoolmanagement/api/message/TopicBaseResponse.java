package com.jesperapps.schoolmanagement.api.message;

public class TopicBaseResponse extends BaseResponse {

	
	private TopicResponse topic;
	
	public TopicBaseResponse(int statuscode,String description) {
		this.statuscode=statuscode;
		this.description=description;
		
	}

	public TopicResponse getTopic() {
		return topic;
	}

	public void setTopic(TopicResponse topic) {
		this.topic = topic;
	}
	
	
	
}
