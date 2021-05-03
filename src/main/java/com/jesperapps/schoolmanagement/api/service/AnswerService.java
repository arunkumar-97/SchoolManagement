package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;

public interface AnswerService {
static final String BASE_URL = "/profile";
	
	static final String URL = BASE_URL+ "/";


	Answers saveAnswer(AnswerJson requestAnswer);

	Answers getAnswerId(Integer answerId);

	Answers saveAnswer(Answers answerFromDb);


}
