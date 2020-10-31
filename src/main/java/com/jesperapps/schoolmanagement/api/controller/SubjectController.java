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
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.ClassJSON;
import com.jesperapps.schoolmanagement.api.message.SubjectBaseResponse;

import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.message.SubjectResponse;

import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.utils.StatusSubject;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@SuppressWarnings("unused")
	@Autowired
	private ClassService classService;
	
	
	@PostMapping("/subject")
	public SubjectBaseResponse checksubject(@RequestBody SubjectRequest subjectRequest) {
		SubjectBaseResponse response=new SubjectBaseResponse(409,"Subject already exists");
		SubjectResponse subjectResponse = new SubjectResponse();
		response.setSubject(subjectResponse);
		Class classFromDb=classService.findById(subjectRequest.getClas().getClassId());
		if(classFromDb !=null) {
			
			Subject subjectName=subjectService.checksubject(subjectRequest.getSubjectName(),classFromDb);
			
//			SubjectListResponse subjectListResponse = new SubjectListResponse();
		
			
			if(subjectName!=null) {
				subjectResponse.setSubjectId(subjectName.getSubjectId());
				subjectResponse.setSubjectName(subjectRequest.getSubjectName());
				subjectResponse.setStatus(subjectRequest.getStatus());
				
			}
			else {
			@SuppressWarnings("unused")
			Subject newsubject=	subjectService.createnewSubject(subjectRequest.getSubjectName(),subjectRequest.getSubjectId(),StatusSubject.getStatus(subjectRequest.getStatus()),subjectRequest.getClas().getClassId());

			subjectResponse.setSubjectId(newsubject.getSubjectId());
			subjectResponse.setSubjectName(newsubject.getSubjectName());
			subjectResponse.setStatus(StatusSubject.getStatus(newsubject.getStatus()));
			subjectResponse.setClas(new ClassJSON(newsubject.getClasses()));
			response.setStatuscode(200);
			response.setDescription("subject Created successfully");
			}
		}
		
		
		return response;
		
	}
	
	
	@PutMapping("/subject/{subjectId}")
	public SubjectBaseResponse updateSubjectName(@PathVariable Integer subjectId,@RequestBody SubjectRequest subjectRequest)
	{
		SubjectBaseResponse response=new SubjectBaseResponse(409, "no such id found");
		SubjectResponse subjectResponse = new SubjectResponse();
		 response.setSubject(subjectResponse);
		if(subjectId != null)
		{
	
		
		 Subject subjectFromDatabase=subjectService.fromSubjectId(subjectId);
		 if(subjectFromDatabase!=null) {
			subjectFromDatabase.setSubjectName(subjectRequest.getSubjectName());
			subjectService.savesubject(subjectFromDatabase);
			response.setStatuscode(200);
			response.setDescription("successfully updated");
			subjectResponse.setSubjectId(subjectFromDatabase.getSubjectId());
			subjectResponse.setSubjectName(subjectRequest.getSubjectName());
			subjectResponse.setStatus(subjectFromDatabase.getStatus());
			
		 }
		
		}
		return response;
	}
	
	
	@GetMapping("/subject")
	public List<SubjectResponse> listAllclasses()
	{
		List<SubjectResponse> res=new ArrayList<>();
		 subjectService.findAll().forEach(sub->{
			 res.add(new SubjectResponse(sub.getSubjectId(), sub.getSubjectName(), sub.getStatus()));
		 });
		 
		 return res;
	}
	
	
	
	@GetMapping("/subject/{subjectId}")
	public SubjectResponse viewSubject(@PathVariable int subjectId)
	{
		Subject sub = subjectService.findById(subjectId);
//		SubjectBaseResponse response = new SubjectBaseResponse();
		SubjectResponse subjectResponse = new SubjectResponse();
		if(sub != null)
		{
			subjectResponse.setSubjectId(sub.getSubjectId());
			subjectResponse.setSubjectName(sub.getSubjectName());
			subjectResponse.setStatus(sub.getStatus());
			subjectResponse.setClas(new ClassJSON(sub.getCls()));
		}
		return subjectResponse;
	}
	
	
	@DeleteMapping("/subject/{subjectId}")
	public SubjectBaseResponse deleteClassById(@PathVariable int subjectId)
	{
		SubjectBaseResponse response = new SubjectBaseResponse(400,"Failure");
		
		Subject subjectFromId = subjectService.fromSubjectId(subjectId);
			if(subjectFromId != null)
				{
					subjectService.deleteSubject(subjectFromId);
					response.setDescription("deleted Successfully");
					response.setStatuscode(200);
				}
		return response;
		
	}
	
	
	
	
	
}
