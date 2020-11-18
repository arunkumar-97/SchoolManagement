package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.Response;

import com.jesperapps.schoolmanagement.api.message.SubscriptionStatusJson;
import com.jesperapps.schoolmanagement.api.message.TopicResponse;
import com.jesperapps.schoolmanagement.api.message.TopicSubscriptionRequest;
import com.jesperapps.schoolmanagement.api.message.TopicSubscriptionResponse;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicSubscription;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.TopicService;
import com.jesperapps.schoolmanagement.api.service.TopicSubscriptionService;
import com.jesperapps.schoolmanagement.api.service.UserService;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@RestController
public class TopicSubscriptionController {

	
	
	@Autowired
	private TopicSubscriptionService  topicSubscriptionService;
	
	
	@Autowired
	private TopicService topicService;
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/topicSubscription")
	public Response createTopicSubscription(@RequestBody TopicSubscriptionRequest topicSubscriptionRequest) {
		return topicSubscriptionService.createTopicSubscription(topicSubscriptionRequest);
	}


  @GetMapping("/topicSubscription")
  public List<TopicResponse> getAllTopicsForSubscriptionRequest(){
	  
	  
	  List<TopicResponse> response = new ArrayList<>();
	  topicSubscriptionService.findAll().forEach(topicSubscription ->{
		  if(!this.topicSubscriptionService.checkTopicInResponse(response,topicSubscription.getTopic())) {
			  if(!topicSubscription.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
				  response.add(new TopicResponse(topicSubscription.getTopic()));
				  }
		  }
		 
		  });
	return response;
	  
}
  
  
  @GetMapping("/topicSubscription/{topicId}")
  public List<TopicSubscriptionResponse> getAllUsersForTheTopic(@PathVariable Integer topicId){
	  List<TopicSubscriptionResponse> response=new ArrayList<>();
	  
	  Topic topicFromDb=topicService.findByTopicId(topicId);
	  if(topicFromDb != null) {
		  topicSubscriptionService.findByTopic(topicFromDb).forEach(topic->{
			  if(!topic.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
			  response.add(new TopicSubscriptionResponse(topic.getTopic(),topic.getSubscriptionStatus(),topic.getTopicSubscriptionId(),topic.getUserTopic()));
		
			  }
			  });
	  }
	return response;
  
  }
  
  @PutMapping("/topicSubscription/{topicSubscriptionId}")
  public Response updateTopicSubscriptionById(@PathVariable Integer topicSubscriptionId ,@RequestBody SubscriptionStatusJson subscriptionStatusRequest) {
	  Response response =new Response(409, "No such Id Found");
	  TopicSubscriptionResponse subscriptionResponse=new TopicSubscriptionResponse();
	  TopicSubscription topicSubscriptionFromDb=topicSubscriptionService.findById(topicSubscriptionId);
	  if(topicSubscriptionFromDb != null) {
		  topicSubscriptionFromDb.setSubscriptionStatus(new SubscriptionStatus(subscriptionStatusRequest));
		  topicSubscriptionService.saveTopicSubscription(topicSubscriptionFromDb);
		  response.setStatuscode(200);
			response.setDescription("Successfully updated the SubscriptionStatus");
			subscriptionResponse.setTopicId(topicSubscriptionFromDb.getTopic().getTopicId());
			subscriptionResponse.setTopicSubscriptionId(topicSubscriptionFromDb.getTopicSubscriptionId());
			subscriptionResponse.setSubscriptionStatus(subscriptionStatusRequest);
			subscriptionResponse.setUser(topicSubscriptionFromDb.getUserTopic());
	  }
	return response;
	  
  }
  
  @GetMapping("/topicSubscriptionForUser/{userId}")
  public List<TopicSubscriptionResponse> getAlltopicsForUser(@PathVariable Integer userId) {
	  List<TopicSubscriptionResponse> response=new ArrayList<>();
	  
	  User userFromDb=userService.findById(userId);
	  if(userFromDb != null) {
		  topicSubscriptionService.findByUser(userFromDb).forEach(user->{
			  if(!user.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.UNSUBSCRIBED)) {
				  response.add(new TopicSubscriptionResponse(user.getTopic(),user.getSubscriptionStatus(),user.getTopicSubscriptionId(),user.getUserTopic()));

			  }else {
				  
			  }
		  });
	  }
	return response;
	

  }
}