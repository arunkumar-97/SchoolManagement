package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;

public class SubscriptionStatusJson {

	private Integer subscriptionStatusid;
	private String subscriptionStatus;
	public SubscriptionStatusJson() {
		
	}
	
	public SubscriptionStatusJson(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatusid = subscriptionStatus.getSubscriptionStatusId();
		this.subscriptionStatus = subscriptionStatus.getStatus();
	}

	public Integer getSubscriptionStatusid() {
		return subscriptionStatusid;
	}

	public void setSubscriptionStatusid(Integer subscriptionStatusid) {
		this.subscriptionStatusid = subscriptionStatusid;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	
	
}
