package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachmentSubscription;
import com.jesperapps.schoolmanagement.api.model.User;

public interface TopicAttachmentSubscriptionRepository  extends JpaRepository<TopicAttachmentSubscription, Integer>{

	List<TopicAttachmentSubscription> findByTopics(Topic topicFromDb);

	TopicAttachmentSubscription findBySubscriptionId(Integer subscriptionId);

	List<TopicAttachmentSubscription> findByUsers(User userFromDb);

	List<TopicAttachmentSubscription> findAllByUsers_userIdAndTopics_topicIdAndTopicAttachment_pictureId(int userId,
			Integer topicId, Integer pictureId);

}
