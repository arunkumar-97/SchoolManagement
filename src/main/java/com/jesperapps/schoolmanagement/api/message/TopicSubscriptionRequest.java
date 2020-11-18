package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Topic;

public class TopicSubscriptionRequest {
	
	
	private Topic subscriptionTopic;
	private SubscriptionStatusJson subscriptionStatus;
	private UserRequest user;
	
	
	public Topic getSubscriptionTopic() {
		return subscriptionTopic;
	}
	public void setSubscriptionTopic(Topic subscriptionTopic) {
		this.subscriptionTopic = subscriptionTopic;
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
