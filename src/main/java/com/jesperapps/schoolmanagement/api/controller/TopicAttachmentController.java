package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.TopicWithAttachmentResponse;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachment;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.TopicJSON;
import com.jesperapps.schoolmanagement.api.service.TopicAttachmentService;
import com.jesperapps.schoolmanagement.api.service.TopicService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TopicAttachmentController {
	
	
	@Autowired
	private TopicService topicService;
	
	
	@Autowired
	private TopicAttachmentService topicAttachmentService;
	
	
	@PostMapping("/add")
	public TopicWithAttachmentResponse addTopicWithAttachment(@RequestBody  TopicJSON requestTopicWithAttachment) {
		TopicWithAttachmentResponse response = new TopicWithAttachmentResponse(200, "Success");
		Topic topicFromDb=topicService.findByTopicName(requestTopicWithAttachment.getTopic().getTopicName());
		if(topicFromDb != null) {
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
		response.setStatuscode(409);
		return null;
		
	
		
	}

}
