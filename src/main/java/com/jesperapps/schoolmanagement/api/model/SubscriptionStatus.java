package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubscriptionStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer subscriptionStatusId;
	
	private String status;

	

	public Integer getSubscriptionStatusId() {
		return subscriptionStatusId;
	}

	public void setSubscriptionStatusId(Integer subscriptionStatusId) {
		this.subscriptionStatusId = subscriptionStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public SubscriptionStatus(){
		
	}

	public SubscriptionStatus(int id, String subscriptionStatus) {
		this.subscriptionStatusId=id;
		this.status=subscriptionStatus;
	}
	
}
