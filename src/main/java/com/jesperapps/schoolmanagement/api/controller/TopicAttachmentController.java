package com.jesperapps.schoolmanagement.api.controller;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jesperapps.schoolmanagement.api.message.TopicWithAttachmentResponse;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;

import com.jesperapps.schoolmanagement.api.modelmessage.TopicJSON;
import com.jesperapps.schoolmanagement.api.service.TopicAttachmentService;
import com.jesperapps.schoolmanagement.api.service.TopicService;
import com.jesperapps.schoolmanagement.api.utils.StorageUtils;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TopicAttachmentController {
	
	
	private static final String Paths = StorageUtils.getFolderLocation("video_answers");;


	@Autowired
	private TopicService topicService;
	
	
	@SuppressWarnings("unused")
	@Autowired
	private TopicAttachmentService topicAttachmentService;
	
	
	@PostMapping("/add")
	public TopicWithAttachmentResponse addTopicWithAttachment(@RequestBody  TopicJSON requestTopicWithAttachment) {
		TopicWithAttachmentResponse response = new TopicWithAttachmentResponse(200, "Success");
		Topic topicFromDb=topicService.findByTopicName(requestTopicWithAttachment.getTopic().getTopicName());
		if(topicFromDb != null) {
			System.out.println(requestTopicWithAttachment.getTopic().getTopicName());

			List<TopicAttachment> existingAttachmentFromDB = topicFromDb.getTopicAttachment();
			List<TopicAttachment> newAttachmentsListForDB = this.topicService.addTopicAttachment(topicFromDb,requestTopicWithAttachment.getAttachment());
			if(existingAttachmentFromDB != null) {
				if(newAttachmentsListForDB != null) {
					existingAttachmentFromDB.addAll(newAttachmentsListForDB);
				}
				topicFromDb.setTopicAttachment(existingAttachmentFromDB);
			}
			this.topicService.saveTopic(topicFromDb);
			response.addTopic(topicFromDb);
			return response;
		}
		response.setDescription("error");
		response.setStatusCode(409);
		return null;
		
	
		
	}

	
	
	@GetMapping("/attachment/{topicId}")
	public TopicJSON getAllAttachments(@PathVariable Integer topicId) {
		
	Topic IdFromDb=topicService.findByTopicId(topicId);
List<TopicAttachment>	AttachmentFromDb=IdFromDb.getTopicAttachment();
	TopicJSON topic=new TopicJSON();
	if(AttachmentFromDb != null) {
		topic=new TopicJSON(IdFromDb);
	}
	return topic;
		
		
	}
	
	@DeleteMapping("/attachments/{topicId}")
		public TopicJSON deleteAllAttachments(@PathVariable Integer topicId) {
		System.out.println("Id" + topicId);
		Topic IdFromDb=topicService.findByTopicId(topicId);
		List<TopicAttachment>	AttachmentFromDb=IdFromDb.getTopicAttachment();
//		for(TopicAttachment each:AttachmentFromDb) {
//			
//		}
	if(AttachmentFromDb != null) {
		for(TopicAttachment each:AttachmentFromDb) {
//			each.getPictureName();
			System.out.println(Paths +each.getPictureName() + "//"+each.getPreviewName());
			File file = new File(Paths +each.getPictureName());
//			File file1=new File(Paths +each.getPreviewName()); 
			if(file.exists()) {
				 if (file.delete()) {
					 System.out.println("file" + file.getName());
		               System.out.println(file.getName() + " is deleted!");
		           } else {
		               System.out.println("Sorry, unable to delete the file.");
		           }
			}
			
//			 if (file1.delete()) {
//	               System.out.println(file1.getName() + " is deleted!");
//	           } else {
//	               System.out.println("Sorry, unable to delete the file.");
//	           }
		}
		
	
	}
		
			
		return null;
		
		
		
	}
}
