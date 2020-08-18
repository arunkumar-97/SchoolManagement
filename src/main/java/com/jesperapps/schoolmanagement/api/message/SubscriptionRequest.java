package com.jesperapps.schoolmanagement.api.message;

public class SubscriptionRequest {
	
	
	private int subscriptionId;
	private int subscriptionClass;
	private String medium;
	private String educationBoard;
	
	private Integer user;
	
	
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
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
	
	
	

}
