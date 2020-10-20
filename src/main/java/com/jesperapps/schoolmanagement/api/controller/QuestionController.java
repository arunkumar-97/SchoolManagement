package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.QuestionRequest;
import com.jesperapps.schoolmanagement.api.message.QuestionResponse;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;
import com.jesperapps.schoolmanagement.api.service.QuestionService;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;



@RestController
@RequestMapping("/questions")
@CrossOrigin(origins="*",allowedHeaders="*")
public class QuestionController {
	
	
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/add")
	public QuestionResponse addQuestions(@RequestBody List<QuestionJson> requestQuestionsList) {
		QuestionResponse response = new QuestionResponse(200, "Success");
		questionService.saveAllQuestions(requestQuestionsList);
		for(QuestionJson eachQuestion : requestQuestionsList) {
			
		
			response.setQuestion(eachQuestion);
		//System.out.println(eachQuestion.getQuestionId());
			
		}
		
		return response;
	}
	
	@PutMapping("/update")
	public QuestionResponse updateQuestioByID(@RequestBody QuestionRequest questionRequest) {
		QuestionResponse response=new QuestionResponse(200,"Successfully Updated");
		if(questionRequest.getQuestionId()!=null) {
			Question QuestionFromDB=questionService.getQuestionId(questionRequest.getQuestionId());
			if(QuestionFromDB != null) {
				QuestionFromDB.setQuestionId(questionRequest.getQuestionId());
				QuestionFromDB.setQuestion(questionRequest.getQuestion());
//				QuestionFromDB.setStatus();
				questionService.saveQuestion(QuestionFromDB);
//				response.setQuestion(QuestionFromDB);
				response.setStatuscode(200);
				response.setDescription("Success");
				response.setQuestion(new QuestionJson(QuestionFromDB));
			}
		}
			
		return response;
	}
	
	@GetMapping("/all")
	public List<QuestionJson> listAllQuestions(){
		
		List<QuestionJson> response= new ArrayList<>();
		
		questionService. findAll().forEach(question->{
			if(!question.getStatus().equalsIgnoreCase(StatusQuestion.DELETED)) {
			QuestionJson questionJson=new QuestionJson(question.getQuestionId(),question.getQuestion(),question.getStatus(),question.getAnswers());
			
			response.add(questionJson);
			}
		});
		
		// @formatter:on

		return response;
	}

	@GetMapping("/question/{questionId}")
	public QuestionJson getQuestion(@PathVariable Integer questionId) {
		
	Question question=questionService.getQuestionId(questionId);
	QuestionJson questionJson=new QuestionJson();
	if(question!=null) {
		questionJson=new QuestionJson(question.getQuestionId(), question.getQuestion(), question.getStatus(), question.getAnswers());
//		questionJson.setAnswer(question.getAnswers(List<AnswerJson>) );

	}
	return questionJson;
	}
	
	@DeleteMapping("/question/{questionId}")
	public QuestionResponse deleteClassById(@PathVariable int questionId)
	{
		QuestionResponse response = new QuestionResponse(409, "No such Id found");

		Question questionFromId = questionService.getQuestionId(questionId);
		if(questionFromId != null)
		{
			questionService.deleteQuestion(questionFromId);
			response.setDescription("deleted Successfully");
			response.setStatuscode(200);
		}
		return response;

	}


}
