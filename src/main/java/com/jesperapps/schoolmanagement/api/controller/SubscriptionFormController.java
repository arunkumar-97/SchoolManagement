package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.service.SubscriptionFormService;



@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SubscriptionFormController {

	
	@Autowired
	private SubscriptionFormService subscriptionFormService;
	
	
	@PostMapping("/subscriptionForm")
	public SubscriptionResponse createSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
		return subscriptionFormService.createSubscription(subscriptionRequest);
}
}