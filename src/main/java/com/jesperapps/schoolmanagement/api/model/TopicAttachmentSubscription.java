package com.jesperapps.schoolmanagement.api.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class TopicAttachmentSubscription {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subscriptionId;
	

	@OneToOne
	@JoinColumn(name="subscriptionStatusId")
	private SubscriptionStatus subscriptionStatus;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User users;
	
	@OneToOne
	@JoinColumn(name="topicId" ,referencedColumnName ="topicId")
	private Topic topics;
	
	@ManyToOne
	@JoinColumn(name="pictureId", referencedColumnName="pictureId")
	private TopicAttachment topicAttachment;
	
	
	public TopicAttachmentSubscription() {
		
	}
	

	

	public TopicAttachmentSubscription(TopicAttachmentSubscription topicAttSub) {
		super();
		this.subscriptionId = topicAttSub.getSubscriptionId();
		this.subscriptionStatus = topicAttSub.getSubscriptionStatus();
		this.users = topicAttSub.users;
		this.topics = topicAttSub.getTopics();
		this.topicAttachment = topicAttSub.getTopicAttachment();
	}



	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public SubscriptionStatus getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Topic getTopics() {
		return topics;
	}

	public void setTopics(Topic topics) {
		this.topics = topics;
	}

	public TopicAttachment getTopicAttachment() {
		return topicAttachment;
	}

	public void setTopicAttachment(TopicAttachment topicAttachment) {
		this.topicAttachment = topicAttachment;
	}

	
	
}
