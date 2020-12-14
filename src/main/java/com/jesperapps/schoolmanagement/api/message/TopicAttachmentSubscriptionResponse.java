package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;

public class TopicAttachmentSubscriptionResponse {
	
	private int SubscriptionId;
	private TopicResponse topic;
	private AnswerAttachmentJSON attachment;;
	private SubscriptionStatusJson subscriptionStatus;
	private UserSubscriptionResponse user;
	
	
	
	
	
	
	
	
	public TopicAttachmentSubscriptionResponse() {
		
	}

	






	public TopicAttachmentSubscriptionResponse(Integer subscriptionId2, Topic topicId2,
			TopicAttachment topicAttachment, SubscriptionStatus subscriptionStatus2, User users) {
		this.SubscriptionId=subscriptionId2;
		this.topic=new TopicResponse(topicId2);
		this.attachment=new AnswerAttachmentJSON(topicAttachment);
		this.subscriptionStatus=new SubscriptionStatusJson(subscriptionStatus2);
		this.user=new UserSubscriptionResponse(users);
	
	
	
	}









	public int getSubscriptionId() {
		return SubscriptionId;
	}








	public void setSubscriptionId(int subscriptionId) {
		SubscriptionId = subscriptionId;
	}








	







	public TopicResponse getTopic() {
		return topic;
	}








	public void setTopic(Topic topic) {
		this.topic = new TopicResponse(topic);
	}








	public AnswerAttachmentJSON getAttachment() {
		return attachment;
	}








	public void setAttachment(AnswerAttachmentJSON attachment) {
		this.attachment = attachment;
	}








	public void setUser(UserSubscriptionResponse user) {
		this.user = user;
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
