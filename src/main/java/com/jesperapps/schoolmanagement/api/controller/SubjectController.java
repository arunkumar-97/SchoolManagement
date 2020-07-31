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
import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectBaseResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectListResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.message.SubjectResponse;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.utils.StatusSubject;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	
	@PostMapping("/subject")
	public SubjectBaseResponse checksubject(@RequestBody SubjectRequest subjectRequest) {
		SubjectBaseResponse response=new SubjectBaseResponse(409,"Subject already exists");
		SubjectResponse subjectResponse = new SubjectResponse();
		response.setSubject(subjectResponse);
		
		Subject subjectName=subjectService.checksubject(subjectRequest.getSubjectName());
		
//		SubjectListResponse subjectListResponse = new SubjectListResponse();
	
		
		if(subjectName!=null) {
			subjectResponse.setSubjectId(subjectName.getSubjectId());
			subjectResponse.setSubjectName(subjectRequest.getSubjectName());
			subjectResponse.setStatus(subjectRequest.getStatus());
		}
		else {
		@SuppressWarnings("unused")
		Subject newsubject=	subjectService.createnewSubject(subjectRequest.getSubjectName(),subjectRequest.getSubjectId(),StatusSubject.getStatus(subjectRequest.getStatus()));
		subjectResponse.setSubjectId(newsubject.getSubjectId());
		subjectResponse.setSubjectName(newsubject.getSubjectName());
		subjectResponse.setStatus(newsubject.getStatus());
		response.setStatuscode(200);
		response.setDescription("subject Created successfully");
		}
		
		return response;
		
	}
	
	
	@PutMapping("/subject")
	public SubjectBaseResponse updateSubjectName(@RequestBody SubjectRequest subjectRequest){
		SubjectBaseResponse response=new SubjectBaseResponse(409, "no such id found");
		SubjectResponse subjectResponse = new SubjectResponse();
		response.setSubject(subjectResponse);
		 Subject subjectFromDatabase=subjectService.fromSubjectId(subjectRequest.getSubjectId());
		 if(subjectFromDatabase!=null) {
			subjectFromDatabase.setSubjectName(subjectRequest.getSubjectName());
			subjectService.savesubject(subjectFromDatabase);
			response.setStatuscode(200);
			response.setDescription("successfully updated");
			subjectResponse.setSubjectId(subjectRequest.getSubjectId());
			subjectResponse.setSubjectName(subjectRequest.getSubjectName());
			subjectResponse.setStatus(subjectFromDatabase.getStatus());
		 }
		return response;
		
		
	}
	
	
	@GetMapping("/subject")
	public SubjectListResponse listAllclasses()
	{
		SubjectListResponse res=new SubjectListResponse(200, "Success");
		 subjectService.findAll().forEach(sub->{
			 res.addSubject(new SubjectResponse(sub.getSubjectId(), sub.getSubjectName(), sub.getStatus()));
		 });
		 if(res.getSubjects().size() <= 0) {
			 res.setStatuscode(409);
			 res.setDescription("No subjects found");
		 }
		 return res;
	}
	
	
	
	@GetMapping("/subject/{subjectId}")
	public SubjectBaseResponse viewSubject(@PathVariable int subjectId)
	{
		Subject sub = subjectService.findById(subjectId);
		SubjectBaseResponse response = new SubjectBaseResponse(200, "Success");
		SubjectResponse subjectResponse = new SubjectResponse();
		if(sub != null)
		{
			subjectResponse.setSubjectId(sub.getSubjectId());
			subjectResponse.setSubjectName(sub.getSubjectName());
			subjectResponse.setStatus(sub.getStatus());
		}else
		{
			response.setStatuscode(400);
			response.setDescription("Failure");
			
		}
		response.setSubject(subjectResponse);
		return response;
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
