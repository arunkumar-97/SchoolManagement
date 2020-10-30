package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;

public interface AnswerAttachmentService {
	
	static final String BASE_URL = "/profile";
	
	static final String URL = BASE_URL+ "/";

	boolean saveFile(AnswerAttachmentJSON requestAttachment);
	
	void save(AnswerAttachment newAttachement);
	
	boolean updateFile(AnswerAttachmentJSON updatedAttachment, String oldFileName);
	
	boolean updateAttachmentDetails(AnswerAttachment attachmentFromDb, AnswerAttachmentJSON requestAttachment);

	AnswerAttachment getByPictureId(Integer pictureId);

	byte[] getFileBytes(String pictureName);

}
