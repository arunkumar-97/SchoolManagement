package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;

public interface AnswerAttachmentService {

	boolean saveFile(AnswerAttachmentJSON requestAttachment);
	
	void save(AnswerAttachment newAttachement);
	
	boolean updateFile(AnswerAttachmentJSON updatedAttachment, String oldFileName);
	
	AnswerAttachment updateAttachmentDetails(AnswerAttachment attachmentFromDb, AnswerAttachmentJSON requestAttachment);

}
