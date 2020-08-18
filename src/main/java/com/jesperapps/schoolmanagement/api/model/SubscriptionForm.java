package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SubscriptionForm {

	@Id
	private int subscriptionId;
	private int subscriptionClass;
	private String medium;
	private String educationBoard;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="subscriptionForm")
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public int getSubscriptionClass() {
		return subscriptionClass;
	}
	public void setSubscriptionClass(int subscriptionClass) {
		this.subscriptionClass = subscriptionClass;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getEducationBoard() {
		return educationBoard;
	}
	public void setEducationBoard(String educationBoard) {
		this.educationBoard = educationBoard;
	}
	
	
	
	
	
}
