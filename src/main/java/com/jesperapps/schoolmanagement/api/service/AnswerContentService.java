package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.model.AnswerContent;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerContentJSON;

public interface AnswerContentService {
	
	void save(AnswerContent newAttachement);
	
	AnswerContent save(AnswerContentJSON requestContent);

}
