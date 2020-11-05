package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.jesperapps.schoolmanagement.api.message.SubscriptionBaseResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;

import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.User;

import com.jesperapps.schoolmanagement.api.repository.SubscriptionFormRepository;
import com.jesperapps.schoolmanagement.api.repository.SubscriptionStatusRepository;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

import com.jesperapps.schoolmanagement.api.model.Class;

@Service
public class SubscriptionformImplementationService implements SubscriptionFormService {

	@Autowired
	private SubscriptionFormRepository subscriptionFormRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClassService classService;
	
	
	
	@Autowired
	private MediumService mediumService;
	
	@Autowired
	private EducationBoardService educationBoardService;
	
	@Autowired
	private SubscriptionStatusRepository subscriptionStatusRepository;
	
	
	@Override
	public SubscriptionForm findBySubscriptionId(int subscriptionId) {
		// TODO Auto-generated method stub
		return subscriptionFormRepository.findBySubscriptionId(subscriptionId);
	}


	@Override
	public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) {
		SubscriptionResponse response= new SubscriptionResponse();
		
		SubscriptionForm subscriptionForm= new SubscriptionForm();
		subscriptionForm.setSubscriptionId(subscriptionRequest.getSubscriptionId());
		subscriptionForm.setSubscriptionClass(classService.fromClassId(subscriptionRequest.getSubscriptionClass().getClassId()));
		subscriptionForm.setMedium(mediumService.findMediumFromId(subscriptionRequest.getMedium().getMediumId()));
		subscriptionForm.setEducationBoard(educationBoardService.findEducationBoardFromId(subscriptionRequest.getEducationBoard().getEducationBoardId()));
//		subscriptionForm.getSubscriptionStatus()
		User subscriptionUser = userRepository.findByUserId(subscriptionRequest.getUser().getUserId());
		if(subscriptionUser != null) {
			SubscriptionStatus subscribedStatusFromDB = subscriptionStatusRepository.findByStatus(SubscriptionStatusTag.SUBSCRIBED);
			if(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatusid() != null) {
				subscribedStatusFromDB = subscriptionStatusRepository.findBySubscriptionStatusId(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatusid());
			}else if(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatus() != null) {
				subscribedStatusFromDB = subscriptionStatusRepository.findByStatus(subscriptionRequest.getSubscriptionStatus().getSubscriptionStatus());
			}
			subscriptionForm.setUser(subscriptionUser);
			subscriptionUser.addSubscription(subscriptionForm);
			subscriptionForm.setSubscriptionStatus(subscribedStatusFromDB);
			subscriptionUser.addSubscription(subscriptionForm);
			userRepository.save(subscriptionUser);
			response.setSubscriptionId(subscriptionForm.getSubscriptionId());
			response.setSubscriptionClass(subscriptionForm.getSubscriptionClass().getClassId());
			response.setMedium(subscriptionForm.getMedium().getMediumLanguage());
			response.setEducationBoard(subscriptionForm.getEducationBoard().getEducationBoardName());
			response.setUser(subscriptionUser);
			response.setSubscriptionStatus(new SubscriptionStatusJson(subscribedStatusFromDB));
			return response;	
		}
//		subscriptionRepository.save(subscriptionForm);
//		subscriptionRequest.
		return null;
	}


	@Override
	public List<SubscriptionForm> findAll() {
		
		return subscriptionFormRepository.findAll();
	}


	@Override
	public List<SubscriptionForm> findByClass(Class cls) {
		// TODO Auto-generated method stub
		return this.subscriptionFormRepository.findBySubscriptionClass(cls);
	}


	

	



}
