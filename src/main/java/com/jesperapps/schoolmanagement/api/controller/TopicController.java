package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.TopicBaseResponse;
import com.jesperapps.schoolmanagement.api.message.TopicRequest;
import com.jesperapps.schoolmanagement.api.message.TopicResponse;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.service.TopicService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TopicController {

	
	
	@Autowired
	private TopicService topicService;
	
	
	
	@PostMapping("/topic")
	private TopicBaseResponse createTopic(@RequestBody List<TopicRequest> topicRequestList) {
		TopicResponse topicResponse= new TopicResponse();
		TopicBaseResponse response = new TopicBaseResponse(200, "Topics created successfully");
		response.setTopic(null);
		topicRequestList.forEach(topicRequest -> {
			Topic topicFromDB = topicService.checkTopic(topicRequest.getTopicName());
			if(topicFromDB == null) {
				topicService.createnewTopic(topicRequest.getTopicId(),topicRequest.getTopicName());				
			}else {
				topicResponse.setTopicId(topicFromDB.getTopicId());
				topicResponse.setTopicName(topicFromDB.getTopicName());
				response.setTopic(topicResponse);
				response.setStatuscode(409);
				response.setDescription("topic already exists");
			}
		});
		return response;
	}
}
