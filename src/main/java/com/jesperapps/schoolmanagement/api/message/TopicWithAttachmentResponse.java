package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.modelmessage.TopicJSON;

public class TopicWithAttachmentResponse extends BaseResponse{
	
	private List<TopicJSON> topic;
	
	
	

	public TopicWithAttachmentResponse() {
		
	}
	

	public TopicWithAttachmentResponse(Integer statusCode, String description) {
		super(statusCode, description);
	}
	

	public List<TopicJSON> getTopic() {
		return topic;
	}

	public void setTopic(TopicJSON topic) {
		if(this.topic != null) {
			this.topic=new ArrayList<>();
		}
		if(this.topic!=null) {
			this.topic.add(topic);
		}
	}
	
	public void addTopic(Topic topic) {
		if(this.topic == null) {
			this.topic = new ArrayList<>();
		}
		this.topic.add(new TopicJSON(topic));
	}
	

}
