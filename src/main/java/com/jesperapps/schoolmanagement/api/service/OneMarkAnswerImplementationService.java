package com.jesperapps.schoolmanagement.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.OneMarkAnswers;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkAnswerJSON;
import com.jesperapps.schoolmanagement.api.repository.OneMarkAnswersRepository;

@Service
public class OneMarkAnswerImplementationService implements OneMarkAnswerService{

	@Autowired
	private OneMarkAnswersRepository oneMarkAnswersRepository;
	
	
	@Override
	public OneMarkAnswers saveAnswer(OneMarkAnswerJSON eachRequestAnswer) {
		OneMarkAnswers answers=new OneMarkAnswers(eachRequestAnswer);
		return answers;
	}


	@Override
	public OneMarkAnswers getoptionId(Integer optionId) {
		
		return oneMarkAnswersRepository.findByOptionId(optionId);
	}


	@Override
	public void saveAnswer(OneMarkAnswers answerFromDb) {
		
		oneMarkAnswersRepository.save(answerFromDb);
	}

}
