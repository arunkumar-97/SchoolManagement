package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.SubscriptionFormService;




@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SubscriptionFormController {

	
	@Autowired
	private SubscriptionFormService subscriptionFormService;
	
	
	@Autowired
	private ClassService classService;
	
	
	
	@PostMapping("/subscription-form")
	public SubscriptionResponse createSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
		return subscriptionFormService.createSubscription(subscriptionRequest);
		}
	
	
	@GetMapping("/subcriptionform")
		public List<ClassResponse> listAllClassesBasedOnSubscription(){
		
	List<ClassResponse> response=new ArrayList<>();
	subscriptionFormService.findAll().forEach(subscription ->{
	{
			response.add(new ClassResponse(subscription.getSubscriptionClass()));		
	
		}
		});
	return response;
	}
	
	@GetMapping("/subscriptionform/{classId}")
	public List<SubscriptionResponse> getAllUsersForTheSubscribedClass(@PathVariable Integer classId){
		List<SubscriptionResponse> response=new ArrayList<>();
	Class classFromDb=classService.findById(classId);
	System.out.println(classFromDb.getClassId());
	if(classFromDb != null) {
      subscriptionFormService.findByClass(classFromDb).forEach(clas ->{
			response.add(new SubscriptionResponse(clas.getSubscriptionId(),clas.getMedium(),clas.getSubscriptionStatus(),clas.getEducationBoard(),clas.getUser(),clas.getSubscriptionClass()));
		});
	}
	return response;
		
	}
		

		
	}
	
	

	
