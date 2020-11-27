package com.jesperapps.schoolmanagement.api.service;



import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;

import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.Class;


public interface SubscriptionFormService {
	
	

	List<ClassSubscription> findByClass(Class cls);
	
	
	ClassSubscription findBySubscriptionId(int subscriptionId);

	Response createSubscription(SubscriptionRequest subscriptionRequest);

	List<ClassSubscription> findAll();


	boolean saveSubscriptionForm(ClassSubscription subscriptionFromDb);


	List<ClassSubscription> findByUser(User userFromDb);
	
	boolean checkClassInResponse(List<ClassResponse> classListFroResponse, Class cls);

	List<ClassSubscription> findAllBySubscriptionClass_classIdAndUser_userId(int ClassID , int UserID);
	

}
