package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

	Topic findByTopicName(String topicName);

	Topic findByTopicId(Integer topicId);

	Topic findByTopicNameAndSchool(String topicName, School school);

}
