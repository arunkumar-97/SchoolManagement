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
	public SubjectResponse checksubject(@RequestBody SubjectRequest subjectRequest) {
		SubjectResponse response1=new SubjectResponse(200,"Subject Created Successfully");
		Subject subjectName=subjectService.checksubject(subjectRequest.getSubjectName());
		
		SubjectResponse response=new SubjectResponse(409,"Subject already exists");
		
		if(subjectName!=null) {
			return response;
		}
		else {
		@SuppressWarnings("unused")
		Subject newsubject=	subjectService.createnewSubject(subjectRequest.getSubjectName(),subjectRequest.getSubjectId(),StatusSubject.getStatus(subjectRequest.getStatus()));
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
	
	
	@GetMapping("/subject")
	public List<SubjectListResponse>  listAllclasses()
	{
		List<SubjectListResponse> res=new ArrayList<SubjectListResponse>();
 
		 subjectService.findAll().forEach(sub->{
			 res.add(new SubjectListResponse(sub.getSubjectId(),sub.getSubjectName(),sub.getStatus()));
		 });;
		 return res;
	}
	
	
	
	@GetMapping("/subject/{subjectId}")
	public Subject viewSubject(@PathVariable int subjectId)
	{
		Subject sub = subjectService.findById(subjectId);
		
		if(sub != null)
		{
			return(sub) ;
		}else
		{
			sub = new Subject();
			
		}
		return sub;
	}
	
	
	@DeleteMapping("/subject/{subjectId}")
	public SubjectResponse deleteClassById(@PathVariable int subjectId)
	{
		SubjectResponse response = new SubjectResponse(409, "No such Id found");
		
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
