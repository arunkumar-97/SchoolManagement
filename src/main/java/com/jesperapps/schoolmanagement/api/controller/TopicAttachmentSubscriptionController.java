package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.message.TopicAttachmentSubscriptionResponse;
import com.jesperapps.schoolmanagement.api.message.TopicResponse;
import com.jesperapps.schoolmanagement.api.message.TopicSubscriptionResponse;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicAttachmentSubscription;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.TopicAttachmentSubscriptionService;
import com.jesperapps.schoolmanagement.api.service.TopicService;
import com.jesperapps.schoolmanagement.api.service.UserService;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TopicAttachmentSubscriptionController {

	
	@Autowired
	private TopicAttachmentSubscriptionService topicAttachmentSubscriptionService;
	
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/attachmentSubscription")
	public TopicAttachmentSubscription createSubscriptionForAttachment(@RequestBody TopicAttachmentSubscription topicAttSub) {
		TopicAttachmentSubscription topicAttachmentSubscription = new TopicAttachmentSubscription(topicAttSub);
		return topicAttachmentSubscriptionService.createSubscription(topicAttachmentSubscription);
	}
	

	 @GetMapping("/attachmentSubscription")
	  public List<TopicResponse> getAllTopicsForSubscriptionRequest(){
		  
		  
		  List<TopicResponse> response = new ArrayList<>();
		  topicAttachmentSubscriptionService.findAll().forEach(topicSubscription ->{
			  if(!this.topicAttachmentSubscriptionService.checkTopicInResponse(response,topicSubscription.getTopics())) {
				  if(!topicSubscription.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
					  response.add(new TopicResponse(topicSubscription.getTopics()));
					  }
			  }
			 
			  });
		return response;
		  
	} 
	 
	 
	 
	  @GetMapping("/attachmentSubscription/{topicId}")
	  public List<TopicAttachmentSubscriptionResponse> getAllUsersForTheTopic(@PathVariable Integer topicId){
		  List<TopicAttachmentSubscriptionResponse> response=new ArrayList<>();
		  
		  Topic topicFromDb=topicService.findByTopicId(topicId);
		  if(topicFromDb != null) {
			  topicAttachmentSubscriptionService.findByTopic(topicFromDb).forEach(topic->{
				  if(!topic.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
			  response.add(new TopicAttachmentSubscriptionResponse(topic.getSubscriptionId(),topic.getTopics().getTopicId(),topic.getTopicAttachment(),topic.getSubscriptionStatus(),topic.getUsers()));
				  }
				  });
		  }
		return response;
	  }
	  
	  @PutMapping("/attachmentSubscription/{subscriptionId}")
	  public Response updateTopicSubscriptionById(@PathVariable Integer subscriptionId ,@RequestBody SubscriptionStatusJson subscriptionStatusRequest) {
		  Response response =new Response(409, "No such Id Found");
		  TopicAttachmentSubscriptionResponse subscriptionResponse=new TopicAttachmentSubscriptionResponse();
		  TopicAttachmentSubscription topicSubscriptionFromDb=topicAttachmentSubscriptionService.findById(subscriptionId);
		  if(topicSubscriptionFromDb != null) {
			  topicSubscriptionFromDb.setSubscriptionStatus(new SubscriptionStatus(subscriptionStatusRequest));
			  topicAttachmentSubscriptionService.saveTopicSubscription(topicSubscriptionFromDb);
			  response.setStatuscode(200);
				response.setDescription("Successfully updated the SubscriptionStatus");
				subscriptionResponse.setTopicId(topicSubscriptionFromDb.getTopics().getTopicId());
				subscriptionResponse.setSubscriptionId(topicSubscriptionFromDb.getSubscriptionId());
				subscriptionResponse.setSubscriptionStatus(subscriptionStatusRequest);
				subscriptionResponse.setUser(topicSubscriptionFromDb.getUsers());
		  }
		return response;
		  
	  }
	  
	  
	  @GetMapping("/attachmentSubscriptionForUser/{userId}")
	  public List<TopicAttachmentSubscriptionResponse> getAlltopicsForUser(@PathVariable Integer userId) {
		  List<TopicAttachmentSubscriptionResponse> response=new ArrayList<>();
		  
		  User userFromDb=userService.findById(userId);
		  if(userFromDb != null) {
			  topicAttachmentSubscriptionService.findByUser(userFromDb).forEach(user->{
				  if(!user.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.UNSUBSCRIBED)) {
					  response.add(new TopicAttachmentSubscriptionResponse(user.getSubscriptionId(),user.getTopics().getTopicId(),user.getTopicAttachment(),user.getSubscriptionStatus(),user.getUsers()));

				  }else {
					  
				  }
			  });
		  }
		return response;
		

	  }
}
