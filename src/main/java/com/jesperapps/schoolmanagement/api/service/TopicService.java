package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;;


public interface TopicService {

	Topic checkTopic(String topicName);

	Topic createnewTopic(Integer topicId, String topicName);


	void saveTopic(Topic newTopic);


	Topic findByTopicName(String topicName);

	List<TopicAttachment> addTopicAttachment(Topic topicFromDb, List<AnswerAttachmentJSON> topicAttachmentList);

}
