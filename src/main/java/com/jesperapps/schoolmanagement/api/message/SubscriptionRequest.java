package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.Class;

public class SubscriptionRequest {
	
	
	
	private SchoolClasses subscriptionClass;
//	private Medium medium;
//	private EducationBoard educationBoard;
	private SubscriptionStatusJson subscriptionStatus;
	private UserRequest user;


	


	public SchoolClasses getSubscriptionClass() {
		return subscriptionClass;
	}


	public void setSubscriptionClass(SchoolClasses subscriptionClass) {
		this.subscriptionClass = subscriptionClass;
	}


//	public Medium getMedium() {
//		return medium;
//	}
//
//
//	public void setMedium(Medium medium) {
//		this.medium = medium;
//	}
//
//
//	public EducationBoard getEducationBoard() {
//		return educationBoard;
//	}
//
//
//	public void setEducationBoard(EducationBoard educationBoard) {
//		this.educationBoard = educationBoard;
//	}


	public UserRequest getUser() {
		return user;
	}


	public void setUser(UserRequest user) {
		this.user = user;
	}


	public SubscriptionStatusJson getSubscriptionStatus() {
		return subscriptionStatus;
	}


	public void setSubscriptionStatus(SubscriptionStatusJson subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}


//	@Override
//	public String toString() {
//		return "SubscriptionRequest [subscriptionClass=" + subscriptionClass + ", medium=" + medium
//				+ ", educationBoard=" + educationBoard + ", subscriptionStatus=" + subscriptionStatus + ", user=" + user
//				+ "]";
//	}

	
	
}
