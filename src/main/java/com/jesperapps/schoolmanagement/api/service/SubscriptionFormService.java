package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;

public interface SubscriptionFormService {
	
	SubscriptionForm findBySubscriptionId(int subscriptionId);

	SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest);

	List<SubscriptionForm> findAll();

}
