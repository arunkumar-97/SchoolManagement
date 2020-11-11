package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.OneMarkQuestion;

import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkQuestionJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkYearContent;

import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.OneMarkQuestionService;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.service.YearService;

@RestController
public class OneMarkContentUploading {

	

	@Autowired
	private SubjectService subjectService;
	
	
	@Autowired
	private YearService yearService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private OneMarkQuestionService oneMarkQuestionService;
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/oneMark/Year")
	public ResponseEntity postContentByYear(@RequestBody OneMarkYearContent  oneMarkYearContent) {
		
		Response response = new Response(200, "Success");
		
		Year yearFromDb=yearService.findById(oneMarkYearContent.getYear().getYearId());
			if(yearFromDb!=null) {
				Class 	classFromdB=classService.findById(oneMarkYearContent.getClas().getClassId());
					if(classFromdB !=null) {
						Subject subjectFromDB=subjectService.findById(oneMarkYearContent.getSubject().getSubjectId());
							if(subjectFromDB!= null){
								List<OneMarkQuestionJSON>	questionsRequestList = oneMarkYearContent.getMcq();
								questionsRequestList.forEach(questionRequest->{
								OneMarkQuestion newQuestion=oneMarkQuestionService.createQuestionFromRequest(questionRequest);
								oneMarkQuestionService.saveQuestionWithSubjectAndYear(newQuestion, subjectFromDB, yearFromDb, classFromdB);
								});
								
							}else {
								response.setDescription("No such subject with id found");
								response.setStatuscode(409);
								
								return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
							}
						}else {
							response.setDescription("No such class with id found");
							response.setStatuscode(409);
							
							return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
						}
					}else {
						response.setDescription("No such year With Id found");
						response.setStatuscode(409);
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
					}
			return ResponseEntity.status(HttpStatus.OK).body(response);

			}
	
	
	
	@GetMapping("/oneMark/{yearId}/{classId}/{subjectId}")
	private List<OneMarkQuestionJSON> getAllByYearAndSubject(@PathVariable Integer yearId,@PathVariable Integer classId,@PathVariable Integer subjectId){
		List<OneMarkQuestionJSON> responseQuestionList = new ArrayList<>();
		Year yearFromDb=yearService.findById(yearId);
		if(yearFromDb!=null) {
			Class classFromDb=classService.findById(classId);
			if(classFromDb !=null) {
				Subject	subjectFromDb=subjectService.findById(subjectId);
				if(subjectFromDb!=null) {
					List<OneMarkQuestion> questionsList=oneMarkQuestionService.findBySubjectAndYearAndClass(subjectFromDb,classFromDb, yearFromDb);
					questionsList.forEach(question -> {
						responseQuestionList.add(new OneMarkQuestionJSON(question));
					});
				}
			}
			
		}
		return responseQuestionList;
	}
	
	}
	


