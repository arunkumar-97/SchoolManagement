package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.model.TopicAttachmentSubscription;
import com.jesperapps.schoolmanagement.api.service.TopicAttachmentSubscriptionService;

@RestController
public class TopicAttachmentSubscriptionController {

	
	@Autowired
	private TopicAttachmentSubscriptionService topicAttachmentSubscriptionService;
	
	@PostMapping("/attachmentSubscription")
	public TopicAttachmentSubscription createSubscriptionForAttachment(@RequestBody TopicAttachmentSubscription topicAttSub) {
		TopicAttachmentSubscription topicAttachmentSubscription = new TopicAttachmentSubscription(topicAttSub);
		return topicAttachmentSubscriptionService.createSubscription(topicAttachmentSubscription);
	}
}
