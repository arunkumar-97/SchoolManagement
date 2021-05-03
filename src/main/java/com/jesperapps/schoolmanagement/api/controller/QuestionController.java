package com.jesperapps.schoolmanagement.api.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.Question;

import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;
import com.jesperapps.schoolmanagement.api.service.ClassSubjectsService;
import com.jesperapps.schoolmanagement.api.service.QuestionService;
import com.jesperapps.schoolmanagement.api.service.YearService;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;



@RestController
@RequestMapping("/questions")
@CrossOrigin(origins="*",allowedHeaders="*")
public class QuestionController {
	
	
	@Autowired
	private YearService yearService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ClassSubjectsService classSubjectsService;
	
	
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
			Optional<Question> QuestionFromDB=questionService.getQuestionId(questionRequest.getQuestionId());
			Question question = new Question(QuestionFromDB.get());
			if(question != null) {
				question.setQuestionId(questionRequest.getQuestionId());
				question.setQuestion(questionRequest.getQuestion());
//				QuestionFromDB.setStatus();
				questionService.saveQuestion(question);
//				response.setQuestion(QuestionFromDB);
				response.setStatusCode(200);
				response.setDescription("Success");
				response.setQuestion(new QuestionJson(question));
			}
		}
			
		return response;
	}
	
	@GetMapping("/all")
	public List<QuestionJson> listAllQuestions(){
		
		List<QuestionJson> response= new ArrayList<>();
		
		questionService. findAll().forEach(question->{
			if(!question.getStatus().equalsIgnoreCase(StatusQuestion.DELETED)) {
			QuestionJson questionJson=new QuestionJson(question.getQuestionId(),question.getQuestion(),question.getStatus(),new AnswerJson(question.getAnswers()));
			
			response.add(questionJson);
			}
		});
		

		return response;
	}

//	@GetMapping("/question/{questionId}")
//	public QuestionJson getQuestion(@PathVariable Integer questionId) {
//		
//	Optional<Question> question=questionService.getQuestionId(questionId);
//	  System.out.println("question"+question);
//	QuestionJson questionJson=new QuestionJson();
//	if(question.isPresent()) {
//		questionJson=new QuestionJson(question.get());
//		System.out.println("questionJson"+questionJson);
//
//	}
//	return questionJson;
//	}
	
	@GetMapping("/question/{questionId}")
	public QuestionJson getByQuestionId(@PathVariable Integer questionId) {
		QuestionJson response=new QuestionJson();
		
					Question questionFromDb=questionService.findByQuestionId(questionId);
					if(questionFromDb != null) {
						response.setQuestionId(questionFromDb.getQuestionId());
						response.setQuestion(questionFromDb.getQuestion());
						response.setStatus(questionFromDb.getStatus());
						response.setYear(questionFromDb.getYear());
						response.setClassSubjects(questionFromDb.getClassSubjects());
						System.out.println(questionFromDb.getAnswers() == null);
//						System.out.println("questionFromDb.getAnswers()"+questionFromDb.getAnswers());
						System.out.println("questionFromDb.getAnswers()"+questionFromDb.getAnswers().getAnswerContent().get(0));
						response.setAnswer(new AnswerJson(questionFromDb.getAnswers()));
					}
					return response;
	}
	
	
//	@GetMapping("/question/{yearId}/{classSubjectsId}")
//	public QuestionJson getByQuestionId(@PathVariable Integer yearId,@PathVariable Integer classSubjectsId ) {
//
//		com.jesperapps.schoolmanagement.api.model.Year yearFromdb=yearService.findByYearId(yearId);
//	
//	if(yearFromdb !=null) {
//ClassSubjects	classSubjectsFromDb=classSubjectsService.findClassSubjectsFromId(classSubjectsId);
//		if(classSubjectsFromDb !=null) {
//			
//			List<Question> questions=questionService.findByYearAndClassSubjects(yearFromdb, classSubjectsFromDb);
//			
//			QuestionJson response=new QuestionJson();
//			
////			Question questionFromDb=questionService.findByQuestionId(classSubjectsFromDb.questionId);
//			if(questions != null) {
//				for(Question questionFromDb:questions) {
//					response.setQuestionId(questionFromDb.getQuestionId());
//					response.setQuestion(questionFromDb.getQuestion());
//					response.setStatus(questionFromDb.getStatus());
//					response.setYear(questionFromDb.getYear());
//					response.setClassSubjects(questionFromDb.getClassSubjects());
//					System.out.println(questionFromDb.getAnswers() == null);
////					System.out.println("questionFromDb.getAnswers()"+questionFromDb.getAnswers());
//					System.out.println("questionFromDb.getAnswers()"+questionFromDb.getAnswers().getAnswerContent().get(0));
//					response.setAnswer(new AnswerJson(questionFromDb.getAnswers()));
//				}
//				
//			}
//			return response;
//		}
//	
//	}
//	
//	return null;
//		
//	}
	
	
	
	@DeleteMapping("/question/{questionId}")
	public QuestionResponse deleteClassById(@PathVariable int questionId)
	{
		QuestionResponse response = new QuestionResponse(409, "No such Id found");

		Optional<Question> questionFromId = questionService.getQuestionId(questionId);
		if(questionFromId != null)
		{
			questionService.deleteQuestion(questionFromId.get());
			response.setDescription("deleted Successfully");
			response.setStatusCode(200);
		}
		return response;

	}
	


}
