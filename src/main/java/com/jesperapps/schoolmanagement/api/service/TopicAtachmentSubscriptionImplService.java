package com.jesperapps.schoolmanagement.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.TopicAttachmentSubscription;
import com.jesperapps.schoolmanagement.api.repository.TopicAttachmentSubscriptionRepository;

@Service
public class TopicAtachmentSubscriptionImplService implements TopicAttachmentSubscriptionService {
	
	@Autowired
	private TopicAttachmentSubscriptionRepository topicAttachmentSubscriptionRepository;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TopicAttachmentService topicAttachmentService;
	



	@Override
	public TopicAttachmentSubscription createSubscription(TopicAttachmentSubscription topicAttachmentSubscription) {
		
		return topicAttachmentSubscriptionRepository.save(topicAttachmentSubscription);
	}

}
