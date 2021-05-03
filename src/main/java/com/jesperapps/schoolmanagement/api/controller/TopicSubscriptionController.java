package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;
import com.jesperapps.schoolmanagement.api.model.Topic;
import com.jesperapps.schoolmanagement.api.model.TopicSubscription;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.TopicService;
import com.jesperapps.schoolmanagement.api.service.TopicSubscriptionService;
import com.jesperapps.schoolmanagement.api.service.UserService;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TopicSubscriptionController {

	
	
	@Autowired
	private TopicSubscriptionService  topicSubscriptionService;
	
	
	@Autowired
	private TopicService topicService;
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/topicSubscription")
	public ResponseEntity createTopicSubscription(@RequestBody TopicSubscriptionRequest topicSubscriptionRequest) {
		return topicSubscriptionService.createTopicSubscription(topicSubscriptionRequest);
	}


  @GetMapping("/topicSubscription/school/{schoolId}")
  public ResponseEntity getAllTopicsForSubscriptionRequestBasedOnSchool(@PathVariable("schoolId")Integer schoolId){
	  
	  School school=new School(schoolId);
	  List<TopicResponse> response = new ArrayList<>();
	  List<TopicSubscription> to=topicSubscriptionService.findAllByTopic_School(school);
	  if(to.isEmpty()) {
		  TopicResponse userResponseEntity = new TopicResponse();
			userResponseEntity.setStatusCode(201);
			userResponseEntity.setDescription("No Data is Available");
			return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
	  }
	  to.forEach(topicSubscription ->{
		  if(!this.topicSubscriptionService.checkTopicInResponse(response,topicSubscription.getTopic())) {
			  if(!topicSubscription.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
				  response.add(new TopicResponse(topicSubscription.getTopic()));
				  }
		  }
		 
		  });
	  if(response.isEmpty())
		 {
		  TopicResponse userResponseEntity = new TopicResponse();
				userResponseEntity.setStatusCode(201);
				userResponseEntity.setDescription("No Data is Available");
				return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
		 }
	return  new ResponseEntity(response, HttpStatus.OK);
	  
}
  
  

  @GetMapping("/topicSubscription")
  public ResponseEntity getAllTopicsForSubscriptionRequest(){
	  
	  
	  List<TopicResponse> response = new ArrayList<>();
	  List<TopicSubscription> to=topicSubscriptionService.findAll();
	  if(to.isEmpty()) {
		  TopicResponse userResponseEntity = new TopicResponse();
			userResponseEntity.setStatusCode(201);
			userResponseEntity.setDescription("No Data is Available");
			return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
	  }
	  to.forEach(topicSubscription ->{
		  if(!this.topicSubscriptionService.checkTopicInResponse(response,topicSubscription.getTopic())) {
			  if(!topicSubscription.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
				  response.add(new TopicResponse(topicSubscription.getTopic()));
				  }
		  }
		 
		  });
	  if(response.isEmpty())
		 {
		  TopicResponse userResponseEntity = new TopicResponse();
				userResponseEntity.setStatusCode(201);
				userResponseEntity.setDescription("No Data is Available");
				return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
		 }
	return  new ResponseEntity(response, HttpStatus.OK);
	  
}
  
  
  
  @GetMapping("/topicSubscription/{topicId}")
  public ResponseEntity getAllUsersForTheTopic(@PathVariable Integer topicId){
	  List<TopicSubscriptionResponse> response=new ArrayList<>();
	  
	  Topic topicFromDb=topicService.findByTopicId(topicId);
	  if(topicFromDb != null) {
		  topicSubscriptionService.findByTopic(topicFromDb).forEach(topic->{
			  if(!topic.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.SUBSCRIBED)) {
			  response.add(new TopicSubscriptionResponse(topic.getTopic(),topic.getSubscriptionStatus(),topic.getTopicSubscriptionId(),topic.getUserTopic()));
		
			  }
			  });
	  if(response.isEmpty())
		 {
		  TopicSubscriptionResponse userResponseEntity = new TopicSubscriptionResponse();
				userResponseEntity.setStatusCode(201);
				userResponseEntity.setDescription("No Data is Available");
				return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
		 }
	 
  }else {
	  TopicSubscriptionResponse userResponseEntity = new TopicSubscriptionResponse();
		userResponseEntity.setStatusCode(201);
		userResponseEntity.setDescription("No Data  Not Found");
		return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
	}
return new ResponseEntity(response, HttpStatus.ACCEPTED);

	
  }
  
  @PutMapping("/topicSubscription/{topicSubscriptionId}")
  public Response updateTopicSubscriptionById(@PathVariable Integer topicSubscriptionId ,@RequestBody SubscriptionStatusJson subscriptionStatusRequest) {
	  Response response =new Response(409, "No such Id Found");
	  TopicSubscriptionResponse subscriptionResponse=new TopicSubscriptionResponse();
	  TopicSubscription topicSubscriptionFromDb=topicSubscriptionService.findById(topicSubscriptionId);
	  if(topicSubscriptionFromDb != null) {
		  topicSubscriptionFromDb.setSubscriptionStatus(new SubscriptionStatus(subscriptionStatusRequest));
		  topicSubscriptionService.saveTopicSubscription(topicSubscriptionFromDb);
		  response.setStatusCode(200);
			response.setDescription("Successfully updated the SubscriptionStatus");
			subscriptionResponse.setTopic(topicSubscriptionFromDb.getTopic());
			subscriptionResponse.setTopicSubscriptionId(topicSubscriptionFromDb.getTopicSubscriptionId());
			subscriptionResponse.setSubscriptionStatus(subscriptionStatusRequest);
			subscriptionResponse.setUser(topicSubscriptionFromDb.getUserTopic());
	  }
	return response;
	  
  }
  
  @GetMapping("/topicSubscriptionForUser/{userId}")
  public ResponseEntity getAlltopicsForUser(@PathVariable Integer userId) {
	  List<TopicSubscriptionResponse> response=new ArrayList<>();
	  
	  User userFromDb=userService.findById(userId);
	  if(userFromDb != null) {
		  topicSubscriptionService.findByUser(userFromDb).forEach(user->{
			  if(!user.getSubscriptionStatus().getStatus().equalsIgnoreCase(SubscriptionStatusTag.UNSUBSCRIBED)) {
				  response.add(new TopicSubscriptionResponse(user.getTopic(),user.getSubscriptionStatus(),user.getTopicSubscriptionId(),user.getUserTopic()));

			  }else {
				  
			  }
		  });
		  if(response.isEmpty())
			 {
			  TopicSubscriptionResponse userResponseEntity = new TopicSubscriptionResponse();
					userResponseEntity.setStatusCode(201);
					userResponseEntity.setDescription("No Data is Available");
					return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
			 }
		 
	  }else {
		  TopicSubscriptionResponse userResponseEntity = new TopicSubscriptionResponse();
			userResponseEntity.setStatusCode(201);
			userResponseEntity.setDescription("No Data  Not Found");
			return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
		}
	return new ResponseEntity(response, HttpStatus.ACCEPTED);
	

  }
}