package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.internal.CriteriaImpl.Subcriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//import com.jesperapps.schoolmanagement.api.message.ClassBaseResponse;
//import com.jesperapps.schoolmanagement.api.message.ClassListResponse;
//import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.message.UserBaseResponse;
import com.jesperapps.schoolmanagement.api.message.UserListResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
//import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
//import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.SubscriptionFormService;
import com.jesperapps.schoolmanagement.api.service.UserService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubscriptionFormService subscriptionFormService;
	
	@PostMapping("/user")
	public UserResponse addadmin(@RequestBody UserRequestWithProfilePicture userRequestWithProfilePicture){
//		UserResponse response=new UserResponse(userRequestWithProfilePicture);
		User createdUsersList = userService.addadmin(userRequestWithProfilePicture);
		System.out.println(createdUsersList);
		return  new UserResponse(createdUsersList);
	}
	
	
	@PostMapping("/check-otp")
	public List<OtpResponse> checkOTP(@RequestBody List<OtpRequest> emailOtpRequest){
		List<OtpResponse> responseList = userService.validateOTP(emailOtpRequest);
		return responseList;
	}
	

	@GetMapping("/user")
	public UserListResponse  listAllusers()
	{
		UserListResponse response=new UserListResponse();
		
//		ClassResponse cls= new ClassResponse();
	
		userService.findAll().forEach(user->{
			UserResponse userResponse = new UserResponse(user.getUserId(),user.getUserName(),user.getEmail(),user.getPassword(),user.getConfirmPassword(),user.getUserProfile().getPictureName(),user.getAuthentication(),user.getUserType(),user.getSubscriptionForm());
			userResponse.setPhoneNumber(user.getPhoneNumber());
			userResponse.setPassword(user.getPassword());
			response.addusers(userResponse);
		});; 
		if(response.getUsers().size() <= 0) {
			 
		 }
		
		return response;
	}
	
	
	@GetMapping("/user/{userId}")
	public UserBaseResponse viewUser(@PathVariable int userId)
	{
		User user = userService.findById(userId);
		UserBaseResponse response = new UserBaseResponse();
		UserResponse userResponse= new UserResponse();
		response.setUsers(userResponse);
		if(user != null)
		{
			userResponse.setUserId(user.getUserId());
			userResponse.setUserName(user.getUserName());
			userResponse.setEmail(user.getEmail());
			userResponse.setPassword(user.getPassword());
			userResponse.setConfirmPassword(user.getConfirmPassword());
			userResponse.setPhoneNumber(user.getPhoneNumber());
			userResponse.setUserType(user.getUserType().getUserTypeRole());
			userResponse.setUserProfilePicture(user.getUserProfile().getPictureName());
			userResponse.setAuthenticationType(user.getAuthentication());
			userResponse.setSubscriptionFormFromUser(user.getSubscriptionForm());
			
//			Response.setClassId(cls.getClassId());
//			classResponse.setClassName(cls.getClassName());
//			classResponse.setStatus(cls.getStatus());
//			classResponse.setMedium(cls.getMedium().getMediumLanguage());
		}
		response.setUsers(userResponse);
		return response;

	}
	
	@GetMapping("/user/{userId}/{subscriptionId}")
	public SubscriptionResponse getUserSubscriptions(@PathVariable Integer userId, @PathVariable Integer subscriptionId) {
		SubscriptionResponse response = new SubscriptionResponse();
		User requestUser = userService.findById(userId);
		if(requestUser != null) {
			SubscriptionForm userSubscription = subscriptionFormService.findBySubscriptionId(subscriptionId);
			if(userSubscription != null) {
				response.setSubscriptionClass(userSubscription.getSubscriptionClass().getClassId());
				response.setSubscriptionId(userSubscription.getSubscriptionId());
				response.setEducationBoard(userSubscription.getEducationBoard().getEducationBoardName());
				response.setMedium(userSubscription.getMedium().getMediumLanguage());
				
				SubscriptionStatusJson json=new SubscriptionStatusJson();
				json.setSubscriptionStatusid(userSubscription.getSubscriptionId());
				json.setSubscriptionStatus(userSubscription.getSubscriptionStatus().getStatus());
				response.setSubscriptionStatus(json);
				response.setUser(requestUser);
			}
		}
		return response;		
				
	}
	
	
	
	

}

