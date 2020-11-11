package com.jesperapps.schoolmanagement.api.service;


import com.jesperapps.schoolmanagement.api.model.OneMarkAnswers;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkAnswerJSON;

public interface OneMarkAnswerService {

	OneMarkAnswers saveAnswer(OneMarkAnswerJSON eachRequestAnswer);
	
	OneMarkAnswers getoptionId(Integer optionId);

	void saveAnswer(OneMarkAnswers answerFromDb);


}
