package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.TopicResponse;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachmentSubscription;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.repository.TopicAttachmentSubscriptionRepository;

@Service
public class TopicAtachmentSubscriptionImplService implements TopicAttachmentSubscriptionService {
	
	@Autowired
	private TopicAttachmentSubscriptionRepository topicAttachmentSubscriptionRepository;
	
	



	@Override
	public TopicAttachmentSubscription createSubscription(TopicAttachmentSubscription topicAttachmentSubscription) {
		
		return topicAttachmentSubscriptionRepository.save(topicAttachmentSubscription);
	}




	@Override
	public List<TopicAttachmentSubscription> findAll() {
		
		return topicAttachmentSubscriptionRepository.findAll();
	}




	@Override
	public boolean checkTopicInResponse(List<TopicResponse> response, Topic topics) {
		for(int i=0;i<response.size();i++) {
			if(response.get(i).getTopicId()==topics.getTopicId()) {
				return true;
			}
		}
		return false;
	}




	@Override
	public List<TopicAttachmentSubscription> findByTopic(Topic topicFromDb) {
	
		return topicAttachmentSubscriptionRepository.findByTopics(topicFromDb);
	}




	@Override
	public boolean saveTopicSubscription(TopicAttachmentSubscription topicSubscriptionFromDb) {
		try{
			topicAttachmentSubscriptionRepository.save(topicSubscriptionFromDb);
				return true;
				}
			catch(Exception e) 
				{
				return false;
				}
	}




	@Override
	public TopicAttachmentSubscription findById(Integer subscriptionId) {
		
		return topicAttachmentSubscriptionRepository.findBySubscriptionId(subscriptionId);
	}




	@Override
	public List<TopicAttachmentSubscription> findByUser(User userFromDb) {
		
		return topicAttachmentSubscriptionRepository.findByUsers(userFromDb);
	}

}
