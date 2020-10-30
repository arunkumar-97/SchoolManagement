package com.jesperapps.schoolmanagement.api.service;


import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;;

public interface TopicAttachmentService {
	
static final String BASE_URL = "/topic";
	
	static final String URL = BASE_URL+ "/";

	boolean saveFile(AnswerAttachmentJSON requestAttachment);
	
	void save(TopicAttachment newAttachement);
	
	boolean updateFile(AnswerAttachmentJSON updatedAttachment, String oldFileName);
	
	boolean updateAttachmentDetails(TopicAttachment attachmentFromDb, AnswerAttachmentJSON requestAttachment);

	TopicAttachment getByPictureId(Integer pictureId);

	byte[] getFileBytes(String pictureName);


}
