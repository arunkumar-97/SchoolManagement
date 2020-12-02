package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
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
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/user")
	public ResponseEntity addadmin(@RequestBody UserRequestWithProfilePicture userRequestWithProfilePicture){

		User createdUsersList = userService.addadmin(userRequestWithProfilePicture);
		if(createdUsersList != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new UserResponse(createdUsersList));
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Response(409, "Email already exsists"));
		}
	}
	
	
	@PostMapping("/check-otp")
	public List<OtpResponse> checkOTP(@RequestBody List<OtpRequest> emailOtpRequest){
		List<OtpResponse> responseList = userService.validateOTP(emailOtpRequest);
		return responseList;
	}
	

	@GetMapping("/user")
	public List<UserResponse>  listAllusers()
	{
		List<UserResponse> response=new ArrayList<>();
		

	
		userService.findAll().forEach(user->{
			UserResponse userResponse = new UserResponse(user.getUserId(),user.getUserName(),user.getEmail(),user.getPassword(),user.getConfirmPassword(),user.getUserProfile().getPictureName(),user.getAuthentication(),user.getUserType(),user.getSubscriptionForm());
			userResponse.setPhoneNumber(user.getPhoneNumber());

			response.add(userResponse);
		});
		
		return response;
	}
	
	
	@GetMapping("/user/{userId}")
	public UserResponse viewUser(@PathVariable int userId)
	{
		User user = userService.findById(userId);
		UserResponse userResponse= new UserResponse();
		if(user != null)
		{
			userResponse.setUserId(user.getUserId());
			userResponse.setUserName(user.getUserName());
			userResponse.setEmail(user.getEmail());

			userResponse.setPhoneNumber(user.getPhoneNumber());
			userResponse.setUserType(user.getUserType().getUserTypeRole());
			userResponse.setUserProfilePicture(user.getUserProfile().getPictureName());
			userResponse.setAuthenticationType(user.getAuthentication());
			userResponse.setSubscriptionFormFromUser(user.getSubscriptionForm());
			

		}
		return userResponse;

	}
	
	@GetMapping("/user/{userId}/{subscriptionId}")
	public SubscriptionResponse getUserSubscriptions(@PathVariable Integer userId, @PathVariable Integer subscriptionId) {
		SubscriptionResponse response = new SubscriptionResponse();
		User requestUser = userService.findById(userId);
		if(requestUser != null) {
			ClassSubscription userSubscription = subscriptionFormService.findBySubscriptionId(subscriptionId);
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

