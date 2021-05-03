package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.service.SchoolService;
import com.jesperapps.schoolmanagement.api.service.SubscriptionFormService;
import com.jesperapps.schoolmanagement.api.service.UserService;



@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubscriptionFormService subscriptionFormService;
	
	
	@Autowired
	private SchoolService schoolService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/user")
	public ResponseEntity addadmin(@RequestBody UserRequestWithProfilePicture userRequestWithProfilePicture){

		UserResponse createdUsersList = userService.addadmin(userRequestWithProfilePicture);
		if(createdUsersList != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(createdUsersList);
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(createdUsersList);
		}
	}
	
	@PostMapping("/user/multiple")
	public ResponseEntity addMultipleUser(@RequestBody List<UserRequestWithProfilePicture> userRequestWithProfilePicture){

		UserResponse createdUsersList = userService.addMultipleUser(userRequestWithProfilePicture);
		if(createdUsersList != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(createdUsersList);
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(createdUsersList);
		}
	}
	
	
	@PostMapping("/check-otp")
	public ResponseEntity checkOTP(@RequestBody List<OtpRequest> emailOtpRequest){
		
		List<OtpResponse> responseList = userService.validateOTP(emailOtpRequest);
		for(OtpResponse each:responseList) {
			if(each.getStatusCode()==200) {
				return new ResponseEntity(each,HttpStatus.ACCEPTED);
			}else if(each.getStatusCode()==400) {
				return new ResponseEntity(each,HttpStatus.CONFLICT);
			}
		}
		OtpResponse response=new OtpResponse();
		response.setStatusCode(409);
		response.setDescription("Email Id Does Not Exists");
		return new ResponseEntity(response,HttpStatus.CONFLICT);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/user/{userId}")
	public ResponseEntity updateUser(@RequestBody UserRequest userRequestEntity) {
		if (userRequestEntity.getUserId() == null) {
			UserRequest userResponseEntity = new UserRequest();
			userResponseEntity.setStatusCode(404);
			userResponseEntity.setDescription("UserId Not Found");
			return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
		}
		User userDatas = userService.findById(userRequestEntity.getUserId());
		if (userDatas != null) {
			User users = new User(userRequestEntity.getUserId(),userDatas.getPassword(),userDatas.getVerificationStatus(),userDatas.getAuthentication(),userDatas.getCreatedBy(),userRequestEntity.getUpdatedBy(),userDatas.getUserType(),userDatas.getUserProfile(),userDatas.getSchool(),userRequestEntity);
//			users.setCreatedByUser(userDatas.get().getCreatedByUser());
//			if (userRequestEntity.getAttachment() == null) {
//			} else {
//				if (userDatas.get().getAttachment() == null) {
//					Attachment attachment = new Attachment(userRequestEntity.getAttachment());
//					Attachment att = attachmentService.save(attachment);
//					String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
//							.path("/download_image/").path(att.getAttachmentId().toString()).toUriString();
//
//					String fileViewUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/view_image/")
//							.path(att.getAttachmentId().toString()).toUriString();
//					att.setFileDownloadUrl(fileDownloadUrl);
//					att.setFileViewUrl(fileViewUrl);
//					users.setAttachment(att);
//				} else {
//					Attachment attachment = new Attachment(userRequestEntity.getAttachment());
//					users.setAttachment(attachment);
//				}
//			}
//			users.setPasscode(userDatas.get().getPasscode());
			System.out.println("UserDatas "+ userDatas);
			User userData = userService.save(users);
			if (userData != null) {
				
				UserRequest userReqEntity = new UserRequest(userData);
				UserResponse userResponseEntity = new UserResponse(userReqEntity);
//				UserType uTypes = userRequestEntity.getUserType();
//				for (UserType ut : userResponseEntity.getData().getUserType()) {
//					UserType userType = new UserType(ut, ut);
//					uTypes.add(userType);
//				}
//				userResponseEntity.setUserType(uTypes);
				userResponseEntity.setStatusCode(200);
				userResponseEntity.setDescription("User Updated Successfully");
				return new ResponseEntity(userResponseEntity, HttpStatus.OK);
			} else {
				UserResponse userResponseEntity = new UserResponse();
				userResponseEntity.setStatusCode(400);
				userResponseEntity.setDescription("Unable to Update User");
				return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
			}
		} else {
			UserResponse userResponseEntity = new UserResponse();
				userResponseEntity.setStatusCode(404);
				userResponseEntity.setDescription("User Not Found");
				return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
		}
	}

	

	@GetMapping("/user")
	private List<UserResponse> getAllYears() {
		
		List<UserResponse> response=new ArrayList<>();
		userService.findAll().forEach(year ->{
			response.add(new UserResponse(year));
			});
			return response;
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity viewUser(@PathVariable int userId)
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
//			userResponse.setUserProfilePicture(user.getUserProfile().getPictureName());
			userResponse.setAuthenticationType(user.getAuthentication());
			userResponse.setSchool(user.getSchool());
			UserProfilePicture		attachment	=				user.getUserProfile();
			if(attachment != null) {
				userResponse.setAttachment(new AnswerAttachmentJSON(attachment));
			}
			userResponse.setStatusCode(200);
			userResponse.setDescription("User Listed Successfully");
//			userResponse.setSubscriptionFormFromUser(user.getSubscriptionForm());
			

		}
		return new ResponseEntity(userResponse,HttpStatus.OK);

	}
	
	@GetMapping("/user/{userId}/{subscriptionId}")
	public SubscriptionResponse getUserSubscriptions(@PathVariable Integer userId, @PathVariable Integer subscriptionId) {
		SubscriptionResponse response = new SubscriptionResponse();
		User requestUser = userService.findById(userId);
		if(requestUser != null) {
			ClassSubscription userSubscription = subscriptionFormService.findBySubscriptionId(subscriptionId);
			if(userSubscription != null) {
				response.setSubscriptionClass(userSubscription.getSubscriptionClass());
				response.setSubscriptionId(userSubscription.getSubscriptionId());
//				response.setEducationBoard(userSubscription.getEducationBoard().getEducationBoardName());
//				response.setMedium(userSubscription.getMedium().getMediumLanguage());
				
				SubscriptionStatusJson json=new SubscriptionStatusJson();
				json.setSubscriptionStatusid(userSubscription.getSubscriptionId());
				json.setSubscriptionStatus(userSubscription.getSubscriptionStatus().getStatus());
				response.setSubscriptionStatus(json);
				response.setUser(requestUser);
			}
		}
		return response;		
				
	}
	

	
	@GetMapping("/user/school/{schoolId}")
	private ResponseEntity getAllSubscribedClassForUsers(@PathVariable Integer schoolId){
	
		List<UserResponse> response=new ArrayList<>();
			School schoolFromDb=schoolService.findBySchoolId(schoolId);
				if(schoolFromDb != null)
				{
			
					userService.findBySchool(schoolFromDb).forEach(user ->{
	
									response.add(new UserResponse(user));
							
	  
					});
		      
					 if(response.isEmpty())
					 {
						 UserResponse userResponseEntity = new UserResponse();
							userResponseEntity.setStatusCode(201);
							userResponseEntity.setDescription("No Data is Available");
							return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
					 }
					
		
				}else {
					UserResponse userResponseEntity = new UserResponse();
					userResponseEntity.setStatusCode(201);
					userResponseEntity.setDescription("No Data  Not Found");
					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
				}
	return new ResponseEntity(response, HttpStatus.OK);
		}
	

	
	
	

}

