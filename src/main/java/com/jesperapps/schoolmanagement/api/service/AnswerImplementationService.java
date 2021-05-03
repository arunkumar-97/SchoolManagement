package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jesperapps.schoolmanagement.api.model.AnswerContent;
import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerContentJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;
import com.jesperapps.schoolmanagement.api.repository.AnswerRepository;


@Service
public class AnswerImplementationService implements AnswerService {
	
	@Autowired
	private AnswerContentService answerContentService;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public Answers saveAnswer(AnswerJson requestAnswer) {
		
			Answers newAnswer = new Answers(requestAnswer);
			
		try {
			List<AnswerContent> newContentListForDB = new ArrayList<AnswerContent>();
			List<AnswerContentJSON> requestContentList= requestAnswer.getAnswerContent();
			for(AnswerContentJSON eachContent: requestContentList) {
			System.out.println("For Loop" );
				AnswerContent newAnswerContent = this.answerContentService.save(eachContent);
				if(newAnswerContent != null) {
					System.out.println("if" );
					newAnswerContent.setAnswer(newAnswer);
					newContentListForDB.add(newAnswerContent);
				}else {
					System.out.println("else" );
				}
			}
			newAnswer.setAnswerContent(newContentListForDB);
			return newAnswer;
		}catch(Exception e) {
			return null;
		}
	}


	@Override
	public Answers getAnswerId(Integer answerId) {
		// TODO Auto-generated method stub
		return answerRepository.findByAnswerId(answerId);
	}


	@Override
	public Answers saveAnswer(Answers answerFromDb) {
		System.out.println("repository funcion called" );
		return answerRepository.save(answerFromDb);
		
	}

}
