package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

	Topic findByTopicName(String topicName);

}
