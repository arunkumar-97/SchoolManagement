package com.jesperapps.schoolmanagement.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;
import com.jesperapps.schoolmanagement.api.repository.AnswerRepository;


@Service
public class AnswerImplementationService implements AnswerService {
	
	@Autowired
	private AnswerAttachmentService answerAttachmentService;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public Answers saveAnswer(AnswerJson requestAnswer) {
		try {
			Answers newAnswer = new Answers(requestAnswer);
			if(requestAnswer.getAnswerAttachment()!=null) {
				if(answerAttachmentService.saveFile(requestAnswer.getAnswerAttachment())) {
					AnswerAttachment imageAttachment=new AnswerAttachment(requestAnswer.getAnswerAttachment());
					newAnswer.setImageAttachment(imageAttachment);
					imageAttachment.setAnswer(newAnswer);
				}
			}
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
	public void saveAnswer(Answers answerFromDb) {
		// TODO Auto-generated method stub
		answerRepository.save(answerFromDb);
		
	}

}
