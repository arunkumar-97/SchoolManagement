package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.ArrayList;
import java.util.List;

import com.jesperapps.schoolmanagement.api.message.TopicRequest;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

public class TopicJSON {
	
	private TopicRequest topic;
	private List<AnswerAttachmentJSON> attachment;
	
	public TopicJSON() {
		
	}
	
	public TopicJSON(Topic topic) {
		this.setTopic(new TopicRequest(topic));
		List<TopicAttachment> topicAttachmentFromDB = topic.getTopicAttachment();
		if(topicAttachmentFromDB !=null) {
			topicAttachmentFromDB.forEach(attachment -> {
				this.addTopicAttachment(new AnswerAttachmentJSON(attachment));
			});
		}
	}
	
	public TopicRequest getTopic() {
		return topic;
	}
	public void setTopic(TopicRequest topic) {
		this.topic = topic;
	}
	public List<AnswerAttachmentJSON> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<AnswerAttachmentJSON> attachment) {
		this.attachment = attachment;
	}
	
	public void addTopicAttachment(AnswerAttachmentJSON attachment) {
	if(this.attachment  == null) {
		this.attachment = new ArrayList<>();
	}
	this.attachment.add(attachment);
	}

}
