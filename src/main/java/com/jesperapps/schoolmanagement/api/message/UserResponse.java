package com.jesperapps.schoolmanagement.api.message;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jesperapps.schoolmanagement.api.model.Attachment;
import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
//import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import com.jesperapps.schoolmanagement.api.model.UserType;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;



public class UserResponse extends BaseResponse{

	
	private Integer userId;
	private String userName;
	private String email;
//	private String password;
	private Long phoneNumber;
	private String userType;
	private String userProfilePicture;
//	private String confirmPassword;
	private String authenticationType;
	private AnswerAttachmentJSON attachment;
	private School school;
	
	
	private List<SubscriptionResponse> subscriptionForm;

	
	public UserResponse() {
		
	}
	public UserResponse(int statuscode,String decription) {
		super(statuscode,decription);
	}
	
	public UserResponse(User user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
//		this.password = user.getPassword();
		this.phoneNumber = user.getPhoneNumber();
		this.userType = user.getUserType() != null? user.getUserType().getUserTypeRole() : null;
		this.userProfilePicture=user.getUserProfile() != null ? user.getUserProfile().getPictureName() : null;
		this.authenticationType=user.getAuthentication();
		this.setSubscriptionFormFromUser(user.getSubscriptionForm());
	}
	
	
	
	public UserResponse(int userId2, String userName2, String email2, String password2, String confirmPassword2,
			String pictureName, String authentication, UserType userType2, Set<ClassSubscription> subscriptionList) {
		this.userId=userId2;
		this.userName=userName2;
		this.email=email2;
//		this.confirmPassword=confirmPassword2;
		this.userProfilePicture=pictureName;
		this.authenticationType=authentication;
		this.userType=userType2.getUserTypeRole();
		this.setSubscriptionFormFromUser(subscriptionList);
		
	}
	
	public UserResponse(int userId2, String userName2, String email2, Long phoneNumber2, String authentication,
			String pictureName, String userTypeRole) {
		userId=userId2;
		userName=userName2;
		email=email2;
		phoneNumber=phoneNumber2;
		authenticationType=authentication;
		userProfilePicture=pictureName;
		userType=userTypeRole;
		
	}
	public UserResponse(User userFromDb, User userFromDb2) {
		this.userId = userFromDb2.getUserId();
		this.userName = userFromDb.getUserName();
		this.email = userFromDb.getEmail();
//		this.password = user.getPassword();
		this.phoneNumber = userFromDb.getPhoneNumber();
		this.userType = userFromDb.getUserType() != null? userFromDb.getUserType().getUserTypeRole() : null;
//		this.userProfilePicture=user.getUserProfile() != null ? user.getUserProfile().getPictureName() : null;
		this.authenticationType=userFromDb.getAuthentication();
		this.school=userFromDb2.getSchool();
	}
	public UserResponse(UserRequest userFromDb) {
		// TODO Auto-generated constructor stub
		this.userId = userFromDb.getUserId();
		this.userName = userFromDb.getUserName();
		this.email = userFromDb.getEmail();
//		this.password = userFromDb.getPassword();
		this.phoneNumber = userFromDb.getPhoneNumber();
		this.userType = userFromDb.getUserType() != null? userFromDb.getUserType().getUserTypeRole() : null;
		Attachment topicAttachmentFromDB = userFromDb.getAttachment();
		if(topicAttachmentFromDB !=null) {
			this.setAttachment(new AnswerAttachmentJSON(attachment));
		}
//		if(topicAttachmentFromDB !=null) {
//			topicAttachmentFromDB.forEach(attachment -> {
//				this.addTopicAttachment(new AnswerAttachmentJSON(attachment));
//			});
//		}					
	}

//	public UserResponse(int userId2, String userName2, String email2, String authentication, UserType userType2) {
//		// TODO Auto-generated constructor stub
//		this.userType=userType2.getUserTypeRole();
//	}
	public String getUserProfilePicture() {
		return userProfilePicture;
	}

	public void setUserProfilePicture(String userProfilePicture) {
		this.userProfilePicture = userProfilePicture;
	}

	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}

	public String getAuthenticationType() {
		return authenticationType;
	}

	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}
	public List<SubscriptionResponse> getSubscriptionForm() {
		return subscriptionForm;
	}
	public void setSubscriptionForm(List<SubscriptionResponse> subscriptionForm) {
		this.subscriptionForm = subscriptionForm;
	}
	public AnswerAttachmentJSON getAttachment() {
		return attachment;
	}
	public void setAttachment(AnswerAttachmentJSON attachment) {
		this.attachment = attachment;
	}
	
	public void setSubscriptionFormFromUser(Set<ClassSubscription> subscriptionFormList) {
		if(subscriptionFormList == null) {
			this.subscriptionForm = null;
		}else {
		this.subscriptionForm = subscriptionFormList.stream().map((subscription) -> new SubscriptionResponse(subscription)).collect(Collectors.toList());
		}
		
		}
	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", getStatusCode()=" + getStatusCode() + ", userName=" + userName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", userType=" + userType + ", userProfilePicture=" + userProfilePicture
				+ ", authenticationType=" + authenticationType + ", school=" + school + ", subscriptionForm="
				+ subscriptionForm  + "]";
	}
	
	
	
}
