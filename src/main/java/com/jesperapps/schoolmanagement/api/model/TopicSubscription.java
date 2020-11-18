package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TopicSubscription {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer topicSubscriptionId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User userTopic;
	
	
	@OneToOne
	@JoinColumn(name="subscriptionStatusId")
	private SubscriptionStatus subscriptionStatus;
	
	@OneToOne
	@JoinColumn(name="topicId" ,referencedColumnName ="topicId")
	private Topic topic;

	public Integer getTopicSubscriptionId() {
		return topicSubscriptionId;
	}

	public void setTopicSubscriptionId(Integer topicSubscriptionId) {
		this.topicSubscriptionId = topicSubscriptionId;
	}

	

	public User getUserTopic() {
		return userTopic;
	}

	public void setUserTopic(User userTopic) {
		this.userTopic = userTopic;
	}

	public SubscriptionStatus getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	
	
	
}

