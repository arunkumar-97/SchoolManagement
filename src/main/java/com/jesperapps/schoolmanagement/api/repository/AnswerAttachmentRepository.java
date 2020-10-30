package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;

public interface AnswerAttachmentRepository extends CrudRepository<AnswerAttachment, Integer>{

	AnswerAttachment findByPictureId(Integer pictureId);

}
