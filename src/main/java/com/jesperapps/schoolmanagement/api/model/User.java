package com.jesperapps.schoolmanagement.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;


@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@Column(unique=true)
	private String email;
	private String password;
	private Long phoneNumber;
	private String confirmPassword;
	private String authentication;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	@ManyToOne
	@JoinColumn(name="userTypeId", referencedColumnName ="userTypeId")
	private UserType userType;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private ConfirmationToken otpToken;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userProfilePicture")
	private UserProfilePicture userProfile;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<ClassSubscription> classSubscription;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="userTopic")
	private Set<TopicSubscription> topicSubscription;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="users")
	private Set<TopicAttachmentSubscription> topicAttachmentSubscription;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ConfirmationToken getOtpToken() {
		return otpToken;
	}

	public void setOtpToken(ConfirmationToken otpToken) {
		this.otpToken = otpToken;
	}

	public UserProfilePicture getUserProfile(){
		return this.userProfile;
	}
	
	public void setUserProfile(UserProfilePicture userProfile){
		this.userProfile = userProfile;
	}
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public void addSubscription(ClassSubscription newSubscription) {
		if(classSubscription == null) {
			classSubscription =new HashSet<>();
		}
		this.classSubscription.add(newSubscription);
	}
	
	public void addSubscription(TopicSubscription subscription) {
		if(topicSubscription == null) {
			topicSubscription=new HashSet<>();
		}
		this.topicSubscription.add(subscription);
	}

	

	public Set<ClassSubscription> getSubscriptionForm() {
		return classSubscription;
	}

	/**
	 * @param classSubscription
	 */
	public void setSubscriptionForm(Set<ClassSubscription> classSubscription) {
		this.classSubscription = classSubscription;
	}

	
	public Set<TopicSubscription> getTopicSubscription() {
		return topicSubscription;
	}

	public void setTopicSubscription(Set<TopicSubscription> topicSubscription) {
		this.topicSubscription = topicSubscription;
	}
	
	

	public Set<TopicAttachmentSubscription> getTopicAttachmentSubscription() {
		return topicAttachmentSubscription;
	}

	public void setTopicAttachmentSubscription(Set<TopicAttachmentSubscription> topicAttachmentSubscription) {
		this.topicAttachmentSubscription = topicAttachmentSubscription;
	}

	public User() {
		
	}
	
	public User(UserRequest userRequest) {
		this.email=userRequest.getEmail();
		this.password=userRequest.getPassword();
		this.phoneNumber = userRequest.getPhoneNumber();
		this.userName = userRequest.getUserName();
	}

	public User(UserRequestWithProfilePicture userRequest) {
		this.email=userRequest.getEmail();
		this.password=userRequest.getPassword();
		this.phoneNumber = userRequest.getPhoneNumber();
		this.userName = userRequest.getUserName();	
//		this.userType=userRequest.getUserType().getUserTypeId();
		this.authentication=userRequest.getAuthenticationType();
	}

	
	

	
	

	
	

}
