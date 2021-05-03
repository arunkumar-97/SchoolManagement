package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.TopicResponse;
import com.jesperapps.schoolmanagement.api.message.TopicSubscriptionRequest;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicSubscription;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.repository.SubscriptionStatusRepository;
import com.jesperapps.schoolmanagement.api.repository.TopicSubscriptionRepository;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@Service
public class TopicSubscriptionImplementationService  implements TopicSubscriptionService{

	

	@Autowired
	private TopicSubscriptionRepository topicSubscriptionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SubscriptionStatusRepository subscriptionStatusRepository;
	
	@Autowired
	private TopicService topicService;

	@Override
	public ResponseEntity createTopicSubscription(TopicSubscriptionRequest topicSubscriptionRequest) {
		
		
		Response response=new Response();
		TopicSubscription subscription=new TopicSubscription();
		List<TopicSubscription >SubscriptionFromDb=topicSubscriptionRepository.findAllByTopic_topicIdAndUserTopic_userId(topicSubscriptionRequest.getSubscriptionTopic().getTopicId(),topicSubscriptionRequest.getUser().getUserId());
		if(SubscriptionFromDb.isEmpty()==false) {
			response.setStatusCode(409);
			response.setDescription("Topic Already Subscribed For User");
			return new ResponseEntity(response, HttpStatus.CONFLICT);
		}else {
			subscription.setTopic(topicService.findByTopicId(topicSubscriptionRequest.getSubscriptionTopic().getTopicId()));
			User subscriptionUser = userRepository.findByUserId(topicSubscriptionRequest.getUser().getUserId());
			if(subscriptionUser != null) {
				SubscriptionStatus subscribedStatusFromDB = subscriptionStatusRepository.findByStatus(SubscriptionStatusTag.SUBSCRIBED);
				if(topicSubscriptionRequest.getSubscriptionStatus().getSubscriptionStatusid() != null) {
					subscribedStatusFromDB = subscriptionStatusRepository.findBySubscriptionStatusId(topicSubscriptionRequest.getSubscriptionStatus().getSubscriptionStatusid());
				}else if(topicSubscriptionRequest.getSubscriptionStatus().getSubscriptionStatus() != null) {
					subscribedStatusFromDB = subscriptionStatusRepository.findByStatus(topicSubscriptionRequest.getSubscriptionStatus().getSubscriptionStatus());
				}
				subscription.setUserTopic(subscriptionUser);
				subscriptionUser.addSubscription(subscription);
				subscription.setSubscriptionStatus(subscribedStatusFromDB);
				subscriptionUser.addSubscription(subscription);
				userRepository.save(subscriptionUser);
				response.setDescription("Successly subscribed");
				response.setStatusCode(200);
				
				return new ResponseEntity(response, HttpStatus.OK);	
		}
		
		
		
	
		}
		Response response1=new Response();
		response1.setStatusCode(409);
		response1.setDescription("No Such User Found");
		return new ResponseEntity(response1, HttpStatus.CONFLICT);	
	}

	@Override
	public List<TopicSubscription> findAll() {
		
		return topicSubscriptionRepository.findAll();
	}

	@Override
	public boolean checkTopicInResponse(List<TopicResponse> response, Topic topic) {
		for(int i=0;i<response.size();i++) {
			if(response.get(i).getTopicId()==topic.getTopicId()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<TopicSubscription> findByTopic(Topic topicFromDb) {
		
		return topicSubscriptionRepository.findByTopic(topicFromDb);
	}

	@Override
	public TopicSubscription findById(Integer topicSubscriptionId) {
		
		return topicSubscriptionRepository.findByTopicSubscriptionId(topicSubscriptionId);
	}

	@Override
	public boolean saveTopicSubscription(TopicSubscription topicSubscriptionFromDb) {
		try{
			topicSubscriptionRepository.save(topicSubscriptionFromDb);
				return true;
				}
			catch(Exception e) 
				{
				return false;
				}
	}

	@Override
	public List<TopicSubscription> findByUser(User userFromDb) {
	
		return topicSubscriptionRepository.findByUserTopic(userFromDb);
	}

	@Override
	public List<TopicSubscription> findAllByTopic_topicIdAndUserTopic_userId(Integer topicId, Integer userId) {
	
		return topicSubscriptionRepository.findAllByTopic_topicIdAndUserTopic_userId(topicId, userId);
	}

	@Override
	public List<TopicSubscription> findAllByTopic_School(School school) {
		// TODO Auto-generated method stub
		return topicSubscriptionRepository.findAllByTopic_School(school);
	}

}
	

