package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
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
		subscriptionStatus=new SubscriptionStatusJson(subscriptionForm.getSubscriptionStatus());
		this.user = new UserSubscriptionResponse(subscriptionForm.getUser());
		
	
	}
	public SubscriptionResponse(int i, Medium medium2, SubscriptionStatus subscriptionStatus2, EducationBoard educationBoard2, User user2, Class subscriptionClass2) {
		this.user=new UserSubscriptionResponse(user2);
		this.subscriptionClass= subscriptionClass2.getClassId();
		this.subscriptionId=i;
		this.medium=medium2.getMediumLanguage();
		this.educationBoard=educationBoard2.getEducationBoardName();
		this.subscriptionStatus=new SubscriptionStatusJson(subscriptionStatus2);
		
	}
	
	

}
