package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	@PutMapping("/update")
	public AnswerJson updateAnswer(@RequestBody AnswerJson answerJsonRequest) {
		AnswerJson response=new AnswerJson();
			Answers answerFromDb = answerService.getAnswerId(answerJsonRequest.getAnswerId());
			
	if(answerFromDb != null) {
		answerFromDb.setAnswer(answerJsonRequest.getAnswer());
		if(answerJsonRequest.getAnswerId() != null) {
			answerFromDb.setAnswerId(answerJsonRequest.getAnswerId());	
		}
		answerFromDb.setLabel(answerJsonRequest.getLabel());
		AnswerAttachmentJSON requestAnswerImage = answerJsonRequest.getImage();
		if(requestAnswerImage != null) {
			AnswerAttachment attachmentFromDb = answerFromDb.getImageAttachment();
			if(attachmentFromDb != null) {
				if(answerAttachmentService.updateAttachmentDetails(attachmentFromDb, requestAnswerImage)){
					attachmentFromDb.setPictureName(requestAnswerImage.getName());
					answerAttachmentService.save(attachmentFromDb);
					
				}else {
					return new AnswerJson();
					//error updating the file
				}
			}else {
				AnswerAttachment newAttachment = new AnswerAttachment(requestAnswerImage);
				if(answerAttachmentService.saveFile(requestAnswerImage)) {
					answerFromDb.setImageAttachment(newAttachment);
					newAttachment.setAnswer(answerFromDb);
				}
				else {
					return new AnswerJson();
					//error saving new file
				}
			}			
		}
		response.setAnswerId(answerJsonRequest.getAnswerId());
		response.setAnswer(answerJsonRequest.getAnswer());
		response.setLabel(answerJsonRequest.getLabel());
		response.setImage(answerJsonRequest.getImage());
		answerService.saveAnswer(answerFromDb);
		return new AnswerJson(answerFromDb);
	}
	return new AnswerJson();
	}
	
	
}
	


