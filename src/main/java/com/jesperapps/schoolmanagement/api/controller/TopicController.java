package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.TopicBaseResponse;
import com.jesperapps.schoolmanagement.api.message.TopicResponse;

import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.modelmessage.TopicJSON;
import com.jesperapps.schoolmanagement.api.service.TopicService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TopicController {

	
	
	@Autowired
	private TopicService topicService;
	
	
	
	@PostMapping("/topic")
	private TopicBaseResponse createTopic(@RequestBody List<TopicJSON> topicRequestList) {
		TopicResponse topicResponse= new TopicResponse();
		TopicBaseResponse response = new TopicBaseResponse(200, "Topics created successfully");
		response.setTopic(null);
		topicRequestList.forEach(topicRequest -> {
			Topic topicFromDB = topicService.checkTopic(topicRequest.getTopic().getTopicName(),topicRequest.getTopic().getSchool());
			if(topicFromDB == null) {
				topicFromDB = topicService.createnewTopic(topicRequest.getTopic().getTopicId(),topicRequest.getTopic().getTopicName(),topicRequest.getTopic().getSchool());
				if(topicRequest.getAttachment() != null) {
					this.topicService.addTopicAttachment(topicFromDB, topicRequest.getAttachment());
				}
			}else {
				if(topicRequest.getAttachment() != null) {
					this.topicService.addTopicAttachment(topicFromDB, topicRequest.getAttachment());
					
				}
				topicResponse.setTopicId(topicFromDB.getTopicId());
				topicResponse.setTopicName(topicFromDB.getTopicName());
				response.setTopic(topicResponse);
				response.setStatusCode(409);
				response.setDescription("topic already exists");
			}
			this.topicService.saveTopic(topicFromDB);
		});
		return response;
	}
	
	
	@GetMapping("/topic")
	private List<TopicResponse> getAllTopics() {
		
		List<TopicResponse> response=new ArrayList<>();
		topicService.findAll().forEach(topic ->{
				response.add(new TopicResponse(topic.getTopicId(),topic.getTopicName()));
			});
			return response;
	}
	
	@GetMapping("/All/{topicId}")
	private TopicResponse getYearById(@PathVariable Integer topicId) {
		Topic TopicFromDb=topicService.findByTopicId(topicId);
		TopicResponse response =new TopicResponse();
		if(TopicFromDb != null) {
			response.setTopicId(TopicFromDb.getTopicId());
			response.setTopicName(TopicFromDb.getTopicName());
			}
	return response;
}
}
