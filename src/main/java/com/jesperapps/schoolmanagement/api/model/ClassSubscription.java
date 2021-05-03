package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class ClassSubscription extends AbstractAuditingEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subscriptionId;
	
	@OneToOne
	@JoinColumn(name="subscriptionStatusId")
	private SubscriptionStatus subscriptionStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	@OneToOne
	@JoinColumn(name="schoolClassesId" ,referencedColumnName ="schoolClassesId")
	private SchoolClasses subscriptionClass;
	
//	@OneToOne
//	@JoinColumn(name="mediumId" ,referencedColumnName ="mediumId")
//	private Medium medium;
//	
//	@OneToOne
//	@JoinColumn(name="educationBoardId" ,referencedColumnName ="educationBoardId")
//	private EducationBoard educationBoard;
	
	
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
	
	public SchoolClasses getSubscriptionClass() {
		return subscriptionClass;
	}
	public void setSubscriptionClass(SchoolClasses subscriptionClass) {
		this.subscriptionClass = subscriptionClass;
	}
//	public Medium getMedium() {
//		return medium;
//	}
//	public void setMedium(Medium medium) {
//		this.medium = medium;
//	}
//	public EducationBoard getEducationBoard() {
//		return educationBoard;
//	}
//	public void setEducationBoard(EducationBoard educationBoard) {
//		this.educationBoard = educationBoard;
//	}
	public SubscriptionStatus getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
//	@Override
//	public String toString() {
//		return "ClassSubscription [subscriptionId=" + subscriptionId + ", subscriptionStatus=" + subscriptionStatus
//				+ ", user=" + user + ", subscriptionClass=" + subscriptionClass + ", medium=" + medium
//				+ ", educationBoard=" + educationBoard + "]";
//	}
//	
	
	
	
	
	
	
}
