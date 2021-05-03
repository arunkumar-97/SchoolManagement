package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.OneMarkQuestionResponse;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkQuestionJSON;

import com.jesperapps.schoolmanagement.api.service.OneMarkQuestionService;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class OneMarkQuestionController {

	
	
	@Autowired
	private OneMarkQuestionService oneMarkQuestionService;
	
	@PostMapping("/oneMarkQuestion")
	public OneMarkQuestionResponse addOneMarkQuestions(@RequestBody List<OneMarkQuestionJSON> requestOneMarkQuestionsList) {
		OneMarkQuestionResponse response=new OneMarkQuestionResponse(200, "Success");
		oneMarkQuestionService.saveAllOneMarkQuestions(requestOneMarkQuestionsList);
		for(OneMarkQuestionJSON eachQuestion : requestOneMarkQuestionsList) {
			
			
			response.setQuestion(eachQuestion);
		
			
		}
		
		return response;
	}
}
