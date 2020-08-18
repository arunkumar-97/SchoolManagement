package com.jesperapps.schoolmanagement.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.jesperapps.schoolmanagement.api.message.SubscriptionBaseResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.repository.SubscriptionRepository;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;

@Service
public class SubscriptionformImplementationService implements SubscriptionFormService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public SubscriptionForm findBySubscriptionId(int subscriptionId) {
		// TODO Auto-generated method stub
		return subscriptionRepository.findBySubscriptionId(subscriptionId);
	}


	@Override
	public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) {
		SubscriptionResponse response= new SubscriptionResponse(200,"Subscription Created successfully");
			
		
		response.setSubscriptionId(subscriptionRequest.getSubscriptionId());
		response.setSubscriptionClass(subscriptionRequest.getSubscriptionClass());
		response.setMedium(subscriptionRequest.getMedium());
		response.setEducationBoard(subscriptionRequest.getEducationBoard());
	
		
		SubscriptionForm subscriptionForm= new SubscriptionForm();
		subscriptionForm.setSubscriptionId(subscriptionRequest.getSubscriptionId());
		subscriptionForm.setSubscriptionClass(subscriptionRequest.getSubscriptionClass());
		subscriptionForm.setMedium(subscriptionRequest.getMedium());
		subscriptionForm.setEducationBoard(subscriptionRequest.getEducationBoard());
		
		User subscriptionUser = userRepository.findByUserId(subscriptionRequest.getUser());
		if(subscriptionUser != null) {
			subscriptionForm.setUser(subscriptionUser);
			subscriptionUser.setSubscriptionForm(subscriptionForm);
			userRepository.save(subscriptionUser);
			response.setUser(subscriptionUser);
			return response;	
		}
//		subscriptionRepository.save(subscriptionForm);
//		subscriptionRequest.
		return null;
	}

}
