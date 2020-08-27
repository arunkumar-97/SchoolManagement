package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.User;


public class SubscriptionResponse {
	
	private int subscriptionId;
	private int subscriptionClass;
	private String medium;
	private String educationBoard;
	private SubscriptionStatusJson subscriptionStatus;
	private UserSubscriptionResponse user;
	
	
	public UserSubscriptionResponse getUser() {
		return user;
	}
	public void setUser(UserSubscriptionResponse user) {
		this.user = user;
	}
	public void setUser(User user) {
		this.user = new UserSubscriptionResponse(user);
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
	
	public SubscriptionStatusJson getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(SubscriptionStatusJson subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public SubscriptionResponse() {
		
	}
	public SubscriptionResponse(SubscriptionForm subscriptionForm) {
		subscriptionId=subscriptionForm.getSubscriptionId();
		subscriptionClass=subscriptionForm.getSubscriptionClass().getClassId();
		medium=subscriptionForm.getMedium().getMediumLanguage();
		educationBoard=subscriptionForm.getEducationBoard().getEducationBoardName();
//		subscriptionStatus=subscriptionForm.getSubscriptionStatus().getStatus();
	
		
		
	}
	
	
	
	

}
