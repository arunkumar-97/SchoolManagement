package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.repository.SubscriptionStatusRepository;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SubscriptionStatusController {
	
	@Autowired
	private SubscriptionStatusRepository subscriptionStatusRepository;

	@GetMapping("/subscriptionStatus")
	public BaseResponse createsubscriptionStatus(){
		BaseResponse response=new BaseResponse(200,"subscriptionStatus Created Successfully") {
		};
		SubscriptionStatus subscriptionStatus1=new SubscriptionStatus(1,SubscriptionStatusTag.SUBSCRIBED);
		SubscriptionStatus subscriptionStatus2=new SubscriptionStatus(1,SubscriptionStatusTag.UNSUBSCRIBED);
		 subscriptionStatusRepository.save(subscriptionStatus1);
		 subscriptionStatusRepository.save(subscriptionStatus2);
		return response;
		
	}
	
	
}
