package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.SubscriptionFormService;
import com.jesperapps.schoolmanagement.api.service.UserService;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class ClassSubscriptionController {

	
	@Autowired
	private SubscriptionFormService subscriptionFormService;
	
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private UserService userService;
	

	
	@PostMapping("/subscriptionForm")
	public Response createSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
			return subscriptionFormService.createSubscription(subscriptionRequest);
		}
	
	
	@GetMapping("/subcriptionform")
		public ResponseEntity listAllClassesBasedOnSubscription(){
		List<ClassResponse> response=new ArrayList<>();
	List<ClassSubscription> su=subscriptionFormService.findAll();
//	System.out.println("Check" + su);
	if (su.isEmpty()) {
//		System.out.println("empty" + su);
		ClassResponse userResponseEntity = new ClassResponse();
		userResponseEntity.setStatuscode(201);
		userResponseEntity.setDescription("No Data is Available");
		return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
	}else {
		
		su.forEach(subscription ->{
			if(!this.subscriptionFormService.checkClassInResponse(response, subscription.getSubscriptionClass())) {
				if(!subscription.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
					response.add(new ClassResponse(subscription.getSubscriptionClass()));			
				}
				
			}
	
	
		});
		
		 if(response.isEmpty())
		 {
			 ClassResponse userResponseEntity = new ClassResponse();
				userResponseEntity.setStatuscode(201);
				userResponseEntity.setDescription("No Data is Available");
				return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
		 }
	}

	return new ResponseEntity(response, HttpStatus.OK);
	}

	
	
	@GetMapping("/subscriptionform/{classId}")
		public ResponseEntity getAllUsersForTheSubscribedClass(@PathVariable Integer classId){
		
		List<SubscriptionResponse> response=new ArrayList<>();
		Class classFromDb=classService.findById(classId);
	
		if(classFromDb != null) {
			subscriptionFormService.findByClass(classFromDb).forEach(clas ->{
				if(!clas.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
					response.add(new SubscriptionResponse(clas.getSubscriptionId(),clas.getMedium(),clas.getSubscriptionStatus(),clas.getEducationBoard(),clas.getUser(),clas.getSubscriptionClass()));
				}else {
					return;
				}
			});
      
			 if(response.isEmpty())
			 {
				 ClassResponse userResponseEntity = new ClassResponse();
					userResponseEntity.setStatuscode(201);
					userResponseEntity.setDescription("No Data is Available");
					return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
			 }
		}else {
			SubscriptionResponse userResponseEntity = new SubscriptionResponse();
			userResponseEntity.setStatuscode(201);
			userResponseEntity.setDescription("No Data  Not Found");
			return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
		}
				
			
			
			
		
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
		
	}
		
	
	@PutMapping("/subscriptionform/{subscriptionId}")
	public Response updateSubscriptionStatus(@PathVariable Integer subscriptionId,@RequestBody SubscriptionStatusJson updateJson) {
		
		Response response=new Response(409,"No such Id Found");
		SubscriptionResponse subscriptionResponse=new SubscriptionResponse();
				ClassSubscription subscriptionFromDb=subscriptionFormService.findBySubscriptionId(subscriptionId);
					if(subscriptionFromDb != null) {
						
						subscriptionFromDb.setSubscriptionStatus(new SubscriptionStatus(updateJson));
						subscriptionFormService.saveSubscriptionForm(subscriptionFromDb);
						response.setStatuscode(200);
						response.setDescription("Successfully updated the SubscriptionStatus");
						subscriptionResponse.setUser(subscriptionFromDb.getUser());
						subscriptionResponse.setSubscriptionClass(subscriptionFromDb.getSubscriptionClass());
//						subscriptionResponse.setEducationBoard(subscriptionFromDb.getEducationBoard().getEducationBoardName());
						subscriptionResponse.setSubscriptionStatus(updateJson);
//						subscriptionResponse.setMedium(subscriptionFromDb.getMedium().getMediumLanguage());
						subscriptionResponse.setSubscriptionId(subscriptionFromDb.getSubscriptionId());
					
					}
					return response;
					
	}
	
	
	
	@GetMapping("/subscriptionForm/{userId}")
	private ResponseEntity getAllSubscribedClassForUsers(@PathVariable Integer userId){
	
		List<SubscriptionResponse> response=new ArrayList<>();
			User userFromDb=userService.findById(userId);
				if(userFromDb != null)
				{
			
					subscriptionFormService.findByUser(userFromDb).forEach(user ->{
							if(!user.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.UNSUBSCRIBED)) {
									response.add(new SubscriptionResponse(user.getSubscriptionId(),user.getMedium(),user.getSubscriptionStatus(),user.getEducationBoard(),user.getUser(),user.getSubscriptionClass()));
							}else {
		    		
							}
	  
					});
		      
					 if(response.isEmpty())
					 {
						 SubscriptionResponse userResponseEntity = new SubscriptionResponse();
							userResponseEntity.setStatuscode(201);
							userResponseEntity.setDescription("No Data is Available");
							return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
					 }
					
		
				}else {
					SubscriptionResponse userResponseEntity = new SubscriptionResponse();
					userResponseEntity.setStatuscode(201);
					userResponseEntity.setDescription("No Data  Not Found");
					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
				}
	return new ResponseEntity(response, HttpStatus.ACCEPTED);
		}

}
	
	

	
