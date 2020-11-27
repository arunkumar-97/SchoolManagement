package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.TopicResponse;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachmentSubscription;
import com.jesperapps.schoolmanagement.api.model.User;

public interface TopicAttachmentSubscriptionService {


	TopicAttachmentSubscription createSubscription(TopicAttachmentSubscription topicAttachmentSubscription);

	List<TopicAttachmentSubscription> findAll();

	boolean checkTopicInResponse(List<TopicResponse> response, Topic topics);

	List<TopicAttachmentSubscription> findByTopic(Topic topicFromDb);

	boolean saveTopicSubscription(TopicAttachmentSubscription topicSubscriptionFromDb);

	TopicAttachmentSubscription findById(Integer subscriptionId);

	List<TopicAttachmentSubscription> findByUser(User userFromDb);

}
