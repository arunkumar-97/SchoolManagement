package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

public interface TopicAttachmentRepository extends CrudRepository<TopicAttachment, Integer>{

	TopicAttachment findByPictureId(Integer pictureId);
}
