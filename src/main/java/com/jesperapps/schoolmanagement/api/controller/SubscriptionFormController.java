package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;

import com.jesperapps.schoolmanagement.api.repository.ClassRepository;
import com.jesperapps.schoolmanagement.api.service.SubscriptionFormService;




@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SubscriptionFormController {

	
	@Autowired
	private SubscriptionFormService subscriptionFormService;
	
	@Autowired
	private ClassRepository classRepository;
	
	
	
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
	System.out.println(response);
	

	return response;
	
	
		
		
	}
	
	}
