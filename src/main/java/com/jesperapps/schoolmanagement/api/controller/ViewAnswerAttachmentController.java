package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;

import com.jesperapps.schoolmanagement.api.service.AnswerAttachmentService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(AnswerAttachmentService.BASE_URL)
public class ViewAnswerAttachmentController {

	
	@Autowired
	private AnswerAttachmentService answerAttachmentService;
	
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/{pictureId}")
	public ResponseEntity viewAnswer(@PathVariable Integer pictureId) {
		AnswerAttachment pictureFromDB = this.answerAttachmentService.getByPictureId(pictureId);
		if(pictureFromDB != null) {
		if(pictureFromDB.getPictureName().toLowerCase().contains("mp4")) {
					return ResponseEntity.status(HttpStatus.OK)

					.header("Content-Type", "video/mp4")

					.body(new ByteArrayResource(answerAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
		}else if(pictureFromDB.getPictureName().toLowerCase().contains("gif")){
			return ResponseEntity.status(HttpStatus.OK)
					
					.contentType(MediaType.IMAGE_GIF)
					.body(new ByteArrayResource(answerAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
		}else if(pictureFromDB.getPictureName().toLowerCase().contains("png")){
			return ResponseEntity.status(HttpStatus.OK)
					
					.contentType(MediaType.IMAGE_PNG)
					.body(new ByteArrayResource(answerAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
		}
		else {
			return ResponseEntity.status(HttpStatus.OK)

					
					.contentType(MediaType.IMAGE_JPEG)

					.body(new ByteArrayResource(answerAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
			
		}
		
		}
		return ResponseEntity.status(HttpStatus.OK).body("No picture found");
	}
	
	
	
}
