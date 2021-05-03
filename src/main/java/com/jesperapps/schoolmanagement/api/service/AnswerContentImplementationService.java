package com.jesperapps.schoolmanagement.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.AnswerContent;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerContentJSON;
import com.jesperapps.schoolmanagement.api.repository.AnswerContentRepository;

import javassist.expr.NewArray;

@Service
public class AnswerContentImplementationService implements AnswerContentService{

	
	@Autowired
	private AnswerContentRepository answerContentRepository;
	
	@Autowired
	private AnswerAttachmentService answerAttachmentService;

	@Override
	public void save(AnswerContent newAttachement) {
		// TODO Auto-generated method stub
		this.answerContentRepository.save(newAttachement);
		
	}

	@Override
	public AnswerContent save(AnswerContentJSON requestContent) {
		// TODO Auto-generated method stub
		AnswerContent newAnswerContent = new AnswerContent(requestContent);
	
		AnswerAttachmentJSON requestAttachment = requestContent.getAnswerAttachmentJSON();
		if(requestAttachment != null) {
			if(this.answerAttachmentService.saveFile(requestAttachment)) {
				//saved file locally
				System.out.println();
				AnswerAttachment newAttachment = new AnswerAttachment(requestAttachment);
				answerAttachmentService.save(newAttachment);
				System.out.println("id" + newAttachment.getPictureId());
				newAttachment.setPictureLocation(AnswerAttachmentService.BASE_URL+"/"+newAttachment.getPictureId()
				);
				newAttachment.setAnswerContent(newAnswerContent);
				newAnswerContent.setImageAttachment(newAttachment);
			}
			else {
				return newAnswerContent;
			}
		}
		return newAnswerContent;
	}
	
}
