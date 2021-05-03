package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import com.jesperapps.schoolmanagement.api.service.TopicAttachmentService;
import com.jesperapps.schoolmanagement.api.service.UserProfilePictureService;

@RequestMapping(UserProfilePictureService.BASE_URL)
@RestController
public class ViewProfileAttachmentController {
	
	@Autowired
	private UserProfilePictureService userService;
	
	@SuppressWarnings("rawtypes")

	@GetMapping("/{pictureId}")
	public ResponseEntity viewTopicAttachments(@PathVariable Integer pictureId) {
		  System.out.println("pictureFromDB"+pictureId);
		UserProfilePicture pictureFromDB = this.userService.getByPictureId(pictureId);
		  System.out.println("pictureFromDB"+pictureFromDB.getPictureId());
		if(pictureFromDB != null) {
			  
		if(pictureFromDB.getPictureName().toLowerCase().contains("mp4")) {
					return ResponseEntity.status(HttpStatus.OK)

					.header("Content-Type", "video/mp4")
					.header("Content-Length", String.valueOf(this.userService.getFileSize(pictureFromDB.getPictureName()) - 1))
					.body(userService.getFileBytes(pictureFromDB.getPictureName()));
		}else if(pictureFromDB.getPictureName().toLowerCase().contains("gif")){
			return ResponseEntity.status(HttpStatus.OK)
					
					.contentType(MediaType.IMAGE_GIF)
					.body(new ByteArrayResource(userService.getFileBytes(pictureFromDB.getPictureName())));
		}else if(pictureFromDB.getPictureName().toLowerCase().contains("png")){
			return ResponseEntity.status(HttpStatus.OK)
					
					.contentType(MediaType.IMAGE_PNG)
					.body(new ByteArrayResource(userService.getFileBytes(pictureFromDB.getPictureName())));
		}
		else {
			return ResponseEntity.status(HttpStatus.OK)
                       
					
					.contentType(MediaType.IMAGE_JPEG)

					.body(new ByteArrayResource(userService.getFileBytes(pictureFromDB.getPictureName())));
			
		}
		
		}
		return ResponseEntity.status(HttpStatus.OK).body("No picture found");
	}

	
//	@GetMapping("/download_attachment/{pictureId}")
//	public ResponseEntity downloadImage(@PathVariable Integer pictureId) {
//		TopicAttachment pictureFromDB = this.topicAttachmentService.getByPictureId(pictureId);
//		if (pictureFromDB  != null) {
//			return ResponseEntity.ok().header("Content-Type", "video/mp4")
//					.header(HttpHeaders.CONTENT_DISPOSITION,
//							"attachment; filename=\"" + pictureFromDB.getPictureName())
//					.body(new ByteArrayResource(topicAttachmentService.getFileBytes(pictureFromDB.getPictureName())));
//			
//	}
//		return ResponseEntity.status(HttpStatus.OK).body("No picture found");
//}

}
