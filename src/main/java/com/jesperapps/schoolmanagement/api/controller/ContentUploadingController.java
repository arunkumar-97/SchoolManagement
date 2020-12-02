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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.YearResponse;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;
import com.jesperapps.schoolmanagement.api.modelmessage.SubjectContent;
import com.jesperapps.schoolmanagement.api.modelmessage.YearContent;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.QuestionService;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.service.YearService;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class ContentUploadingController {

	@Autowired
	private SubjectService subjectService;
	
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private YearService yearService;
	
	@Autowired
	private ClassService classService;
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/content/year")
	private ResponseEntity ContentByYear(@RequestBody YearContent subjectRequestContent) {
		
		System.out.println("Post Method Called");
		//create response
		Response response = new Response(200, "Success");
		//find class from database
		Class classFromDb=classService.findById(subjectRequestContent.getClas().getClassId());
		if(classFromDb !=null) {
			//find subject from database
			Subject subjectFromDb = subjectService.findById(subjectRequestContent.getSubject().getSubjectId());
				if(subjectFromDb != null) {
				//requested subject is on database
					Year yearFromDb= yearService.findById(subjectRequestContent.getYear().getYearId());
						if(yearFromDb != null) {
							//year from database
							List<QuestionJson> questionRequestList = subjectRequestContent.getQuestion();
							questionRequestList.forEach(questionRequest -> {

									Question newQuestion = questionService.createQuestionFromRequest(questionRequest);
									questionService.saveQuestionWithSubjectAndYear(newQuestion, subjectFromDb, yearFromDb,classFromDb);
							});
							}
						else {
							response.setDescription("No such year with id found");
							response.setStatuscode(409);
							//return no year found ERR
							return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
				}
			}else {
				response.setDescription("No such Subject with id found");
				response.setStatuscode(409);
				//no subject found ERR
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		}else {
			response.setDescription("No such Class With Id found");
			response.setStatuscode(409);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(response);

		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/content/subject")
	public ResponseEntity ContentBySubject(@RequestBody SubjectContent requestContent ) {
		Response response=new Response(200,"Successfully Created");
		Subject	subjectFromDb=subjectService.findById(requestContent.getSubject().getSubjectId());
		if(subjectFromDb != null) {
				List<QuestionJson> subjectRequestQuestionsList=requestContent.getQuestion();
				subjectRequestQuestionsList.forEach(eachQuestion ->{
				Question newQuestionCreated=questionService.createQuestionFromRequest(eachQuestion);
				questionService.saveQuestionWithSubject(newQuestionCreated,subjectFromDb);			
			});
		}else {
			response.setStatuscode(409);
			response.setDescription("No Such Subject Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
			return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/content/{yearId}/{classId}/{subjectId}")
	private List<QuestionJson> getAllByYearAndSubject(@PathVariable Integer yearId,@PathVariable Integer classId,@PathVariable Integer subjectId){
		List<QuestionJson> responseQuestionList = new ArrayList<>();
		Year yearFromDb=yearService.findById(yearId);
		if(yearFromDb!=null) {
			Class classFromDb=classService.findById(classId);
				if(classFromDb !=null) {
					Subject	subjectFromDb=subjectService.findById(subjectId);
						if(subjectFromDb!=null) {
							List<Question> questionsList=questionService.findBySubjectAndYearAndClass(subjectFromDb,classFromDb, yearFromDb);
							questionsList.forEach(question -> {
							responseQuestionList.add(new QuestionJson(question));
					});
				}
			}
			
		}
		return responseQuestionList;
	}
	
	@GetMapping("/{subjectId}")
		private List<QuestionJson> getAllBySubject(@PathVariable Integer subjectId){
		List<QuestionJson> responseList=new ArrayList<>();
		Subject	subjectFromDb=subjectService.findById(subjectId);
		if(subjectFromDb !=null) {
			List<Question> questionsList=questionService.findBySubject(subjectFromDb);
			questionsList.forEach(question ->{
			responseList.add(new QuestionJson(question));
			});
		}
		return responseList;
	}
	
	@GetMapping("/Years/{subjectId}")
	public List<YearResponse> getAllYearsForTheSubject(@PathVariable Integer subjectId){
		List<YearResponse> response=new ArrayList<>();
		Subject subjectFromDb=subjectService.findById(subjectId);
		if(subjectFromDb != null) {
			questionService.findBySubject(subjectFromDb).forEach(Year ->{
				response.add(new YearResponse(Year.getYear().getYear(),Year.getYear().getYearId()));
		     
      });
      
      
      }
	return response;
		
	}

	
	
}
