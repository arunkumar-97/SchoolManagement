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

import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.service.TopicAttachmentService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(TopicAttachmentService.BASE_URL)
public class ViewTopicAttachmentController {
	
	@Autowired
	private TopicAttachmentService topicAttachmentService;
	
	@SuppressWarnings("rawtypes")

	@GetMapping("/{pictureId}")
	public ResponseEntity viewTopicAttachments(@PathVariable Integer pictureId) {
		TopicAttachment pictureFromDB = this.topicAttachmentService.getByPictureId(pictureId);
		if(pictureFromDB != null) {
		if(pictureFromDB.getPictureName().toLowerCase().contains("mp4")) {
					return ResponseEntity.status(HttpStatus.OK)

					.header("Content-Type", "video/mp4")
					.header("Content-Length", String.valueOf(this.topicAttachmentService.getFileSize(pictureFromDB.getPictureName()) - 1))
					.body(topicAttachmentService.getFileBytes(pictureFromDB.getPictureName()));
		}else if(pictureFromDB.getPictureName().toLowerCase().contains("gif")){
			return ResponseEntity.status(HttpStatus.OK)
					
					.contentType(MediaType.IMAGE_GIF)
					.body(new ByteArrayResource(topicAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
		}else if(pictureFromDB.getPictureName().toLowerCase().contains("png")){
			return ResponseEntity.status(HttpStatus.OK)
					
					.contentType(MediaType.IMAGE_PNG)
					.body(new ByteArrayResource(topicAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
		}
		else {
			return ResponseEntity.status(HttpStatus.OK)

					
					.contentType(MediaType.IMAGE_JPEG)

					.body(new ByteArrayResource(topicAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
			
		}
		
		}
		return ResponseEntity.status(HttpStatus.OK).body("No picture found");
	}

}
