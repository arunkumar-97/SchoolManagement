package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;
import com.jesperapps.schoolmanagement.api.service.AnswerAttachmentService;
import com.jesperapps.schoolmanagement.api.service.AnswerService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AnswerAttachmementController {
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private AnswerAttachmentService answerAttachmentService;
	
	
//	@PutMapping("/update")
//	public AnswerJson updateAnswer(@RequestBody AnswerJson answerJsonRequest) {
//		// eg: /update/answerId
//		// eg2: /update/answerId/contentId
//		AnswerJson response=new AnswerJson();
//			Answers answerFromDb = answerService.getAnswerId(answerJsonRequest.getAnswerId());
//			answerFromDb.setAnswerContent(null);
//	if(answerFromDb != null)
//	{
//		answerFromDb.set;
//			if(answerJsonRequest.getAnswerId() != null)
//				{
//					answerFromDb.setAnswerId(answerJsonRequest.getAnswerId());	
//				}
//		answerFromDb.setLabel(answerJsonRequest.getLabel());
//		AnswerAttachmentJSON requestAnswerImage = answerJsonRequest.getAnswerAttachment();
//			if(requestAnswerImage != null) {
//				AnswerAttachment attachmentFromDb = answerFromDb.getImageAttachment();
//					if(attachmentFromDb != null) {
//							if(answerAttachmentService.updateAttachmentDetails(attachmentFromDb, requestAnswerImage)){
//									attachmentFromDb.setPictureName(requestAnswerImage.getName());
//									answerAttachmentService.save(attachmentFromDb);
//					
//							}else {
//									return new AnswerJson();
//									//error updating the file
//							}
//					}else {
//						AnswerAttachment newAttachment = new AnswerAttachment(requestAnswerImage);
//							if(answerAttachmentService.saveFile(requestAnswerImage)) {
//								answerFromDb.setImageAttachment(newAttachment);
//								newAttachment.setAnswer(answerFromDb);
//							}
//							else {
//								return new AnswerJson();
//								//error saving new file
//							}
//					}			
//			}
//		response.setAnswerId(answerJsonRequest.getAnswerId());
//		response.setAnswer(answerJsonRequest.getAnswer());
//		response.setLabel(answerJsonRequest.getLabel());
//		response.setAnswerAttachment(answerJsonRequest.getAnswerAttachment());
//		answerService.saveAnswer(answerFromDb);
//		return new AnswerJson(answerFromDb);
//	}
//	return new AnswerJson();
//	}
	
	
}
	


