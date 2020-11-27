package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.TopicResponse;
import com.jesperapps.schoolmanagement.api.message.TopicSubscriptionRequest;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicSubscription;
import com.jesperapps.schoolmanagement.api.model.User;

public interface TopicSubscriptionService {

	Response createTopicSubscription(TopicSubscriptionRequest topicSubscriptionRequest);

	List<TopicSubscription> findAll();

	boolean checkTopicInResponse(List<TopicResponse> response, Topic topic);

	List<TopicSubscription> findByTopic(Topic topicFromDb);

	TopicSubscription findById(Integer topicSubscriptionId);

	boolean saveTopicSubscription(TopicSubscription topicSubscriptionFromDb);

	List<TopicSubscription> findByUser(User userFromDb);

	List<TopicSubscription> findAllByTopic_topicIdAndUserTopic_userId(Integer topicId, Integer userId);
}
