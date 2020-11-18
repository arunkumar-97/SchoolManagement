package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.User;

public class TopicSubscriptionResponse  {
	
	private int topicSubscriptionId;
	private int topicId;
	private SubscriptionStatusJson subscriptionStatus;
	private UserSubscriptionResponse user;
	
	public TopicSubscriptionResponse() {
		
		
	}
	
	
	
	public TopicSubscriptionResponse(Topic topic, SubscriptionStatus subscriptionStatus2, Integer topicSubscriptionId2,
			User user2) {
		this.topicSubscriptionId=topicSubscriptionId2;
		this.topicId=topic.getTopicId();
		this.subscriptionStatus=new SubscriptionStatusJson(subscriptionStatus2);
		this.user=new UserSubscriptionResponse(user2);
		
		
	}

	public int getTopicSubscriptionId() {
		return topicSubscriptionId;
	}
	public void setTopicSubscriptionId(int topicSubscriptionId) {
		this.topicSubscriptionId = topicSubscriptionId;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public SubscriptionStatusJson getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(SubscriptionStatusJson subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public UserSubscriptionResponse getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = new UserSubscriptionResponse(user);
	}
	
	
	
	

}
