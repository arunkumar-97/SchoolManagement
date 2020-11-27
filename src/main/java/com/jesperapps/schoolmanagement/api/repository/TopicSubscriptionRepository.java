package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicSubscription;
import com.jesperapps.schoolmanagement.api.model.User;

public interface TopicSubscriptionRepository  extends JpaRepository<TopicSubscription, Integer>{

	List<TopicSubscription> findByTopic(Topic topicFromDb);

	TopicSubscription findByTopicSubscriptionId(Integer topicSubscriptionId);

	

	List<TopicSubscription> findByUserTopic(User userFromDb);

	List<TopicSubscription> findAllByTopic_topicIdAndUserTopic_userId(Integer topicId, Integer userId);
}
