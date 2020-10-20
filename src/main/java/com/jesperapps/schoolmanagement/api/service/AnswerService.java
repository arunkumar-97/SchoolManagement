package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;

public interface AnswerService {


	Answers saveAnswer(AnswerJson requestAnswer);

	Answers getAnswerId(Integer answerId);

	void saveAnswer(Answers answerFromDb);


}
