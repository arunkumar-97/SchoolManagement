package com.jesperapps.schoolmanagement.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.jesperapps.schoolmanagement.api.message.SubscriptionBaseResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.repository.SubscriptionRepository;
import com.jesperapps.schoolmanagement.api.repository.SubscriptionStatusRepository;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@Service
public class SubscriptionformImplementationService implements SubscriptionFormService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
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
		return subscriptionRepository.findBySubscriptionId(subscriptionId);
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

}