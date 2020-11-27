package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

public class AttachmentSubscriptionJSON {
	
	private TopicJSON topic;
	private List<TopicAttachment> attachment;
	private SubscriptionStatusJson subscriptionStatus;
	private UserRequest user;
	
	
	public TopicJSON getTopic() {
		return topic;
	}
	public void setTopic(TopicJSON topic) {
		this.topic = topic;
	}
	public List<TopicAttachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<TopicAttachment> attachment) {
		this.attachment = attachment;
	}
	public SubscriptionStatusJson getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(SubscriptionStatusJson subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public UserRequest getUser() {
		return user;
	}
	public void setUser(UserRequest user) {
		this.user = user;
	}
	
	
	
 
	

}
