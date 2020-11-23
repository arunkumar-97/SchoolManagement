package com.jesperapps.schoolmanagement.api.message;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

public class AttachmentSubscriptionRequest {
	
	private SubscriptionStatusJson subscriptionStatus;
	private Topic topic;
	private List<TopicAttachment> attachment;
	private UserRequest user;

	public SubscriptionStatusJson getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(SubscriptionStatusJson subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public List<TopicAttachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<TopicAttachment> attachment) {
		this.attachment = attachment;
	}
	public UserRequest getUser() {
		return user;
	}
	public void setUser(UserRequest user) {
		this.user = user;
	}
	
	

}
