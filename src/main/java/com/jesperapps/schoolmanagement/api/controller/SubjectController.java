package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.message.SubjectResponse;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;

@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/subject")
	public SubjectResponse checksubject(@RequestBody SubjectRequest subjectRequest) {
		SubjectResponse response1=new SubjectResponse(200,"Subject Created");
		Subject subjectName=subjectService.checksubject(subjectRequest.getSubjectName());
		
		SubjectResponse response=new SubjectResponse(409,"Subject already exists");
		
		if(subjectName!=null) {
			return response;
		}
		else {
		@SuppressWarnings("unused")
		Subject newsubject=	subjectService.createnewSubject(subjectRequest.getSubjectName(),subjectRequest.getSubjectId(),subjectRequest.getStatus());
		}
		
		return response1;
		
	}
	
	
	@PutMapping("/subject")
	public SubjectResponse updateSubjectName(@RequestBody SubjectRequest subjectRequest){
		SubjectResponse response=new SubjectResponse(409,"No Such Id Found");
		 Subject subjectFromDatabase=subjectService.fromSubjectId(subjectRequest.getSubjectId());
		 if(subjectFromDatabase!=null) {
			subjectFromDatabase.setSubjectName(subjectRequest.getSubjectName());
			subjectService.savesubject(subjectFromDatabase);
			response.setStatuscode(200);
			response.setDescription("successfully updated");
			
		 }
		return response;
		
	}

}
