package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;

import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.Class;


public interface SubscriptionFormService {
	
	

	List<SubscriptionForm> findByClass(Class cls);
	
	
	SubscriptionForm findBySubscriptionId(int subscriptionId);

	SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest);

	List<SubscriptionForm> findAll();


	boolean saveSubscriptionForm(SubscriptionForm subscriptionFromDb);


	List<SubscriptionForm> findByUser(User userFromDb);
	
	boolean checkClassInResponse(List<ClassResponse> classListFroResponse, Class cls);

	
	

}
