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

import com.jesperapps.schoolmanagement.api.message.ClassBaseResponse;
import com.jesperapps.schoolmanagement.api.message.ClassListResponse;
import com.jesperapps.schoolmanagement.api.message.ClassRequest;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;

import com.jesperapps.schoolmanagement.api.message.SubjectResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;
import com.jesperapps.schoolmanagement.api.utils.StatusSubject;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class ClassController {


	@Autowired
	private ClassService classService; 

	@Autowired
	private SubjectService subjectService;

	
	@PostMapping("/class")
	public ClassBaseResponse checkclass(@RequestBody ClassRequest classRequest ) 
	{
		ClassBaseResponse response= new ClassBaseResponse(409,"Class Already Exists");
		ClassResponse classResponse=new ClassResponse();
		//		for(ClassRequest eachclass:classRequest) 
		//		{
		Class classOfName=classService.checkclass( classRequest.getClassName());
		

		if(classOfName != null)
		{
			/*
			 * classResponse.setClassName(classRequest.getClassName());
			 * classResponse.setClassId(classOfName.getClassId());
			 * classResponse.setStatus(classRequest.getStatus());
			 * classResponse.setMedium(classRequest.getMedium());
			 * classResponse.setEducationBoard(classRequest.getEducationBoard());
			 */
		}
		else
		{
			@SuppressWarnings("unused")
			Class newClass =classService.createnewclass(classRequest.getClassName(),classRequest.getClassId(),StatusClass.getStatus(classRequest.getStatus()),classRequest.getMedium(),classRequest.getEducationBoard());
			classResponse.setClassId(newClass.getClassId());
			classResponse.setClassName(newClass.getClassName());
			classResponse.setStatus(newClass.getStatus());
			classResponse.setMedium(newClass.getMedium().getMediumLanguage());
			classResponse.setEducationBoard(newClass.getEducationBoard().getEducationBoardName());
			response.setCls(classResponse);
			response.setStatuscode(200);
			response.setDescription("Class Created Successfully");
		}


		return response;
	}
	
	@PostMapping("/addSubject/{classId}")
	public ClassBaseResponse addSubjectToClass(@PathVariable int classId, @RequestBody List<SubjectRequest> subjectRequestList) {
		ClassBaseResponse response = new ClassBaseResponse(409, "No such ClassId Found");
		Class requestClass = classService.findById(classId);
		if(requestClass != null) {
			List<Subject> classListOfSubject = new ArrayList<>();
			for(SubjectRequest subject : subjectRequestList) {
				Subject subjectFromDB=null;
				if(subject.getSubjectId() == null) {
					subjectFromDB = subjectService.checksubject(subject.getSubjectName());	
				}else {
					subjectFromDB = subjectService.findById(subject.getSubjectId());
				}
				if(subjectFromDB != null) {
					subjectFromDB.setCls(requestClass);
					classListOfSubject.add(subjectFromDB);
				}else {
					Subject newSubject = new Subject(subject);
					newSubject.setCls(requestClass);
					classListOfSubject.add(newSubject);
				}
			}
			requestClass.setSubject(classListOfSubject);
			classService.saveClass(requestClass);
			response.setDescription("Subjects added Successfully");
			response.setStatuscode(200);
		}
		return response;
	}

	
	@PutMapping("/class")
	public ClassBaseResponse updateClassName(@RequestBody ClassRequest classRequest)
	{
		ClassBaseResponse response = new ClassBaseResponse(409,"No such Id found");
		ClassResponse classResponse=new ClassResponse();
		response.setCls(classResponse);
		if(classRequest.getClassId() != null) 
		{
			Class classFromDatabase = classService.fromClassId(classRequest.getClassId());
			if(classFromDatabase != null) 
			{

				classFromDatabase.setClassName(classRequest.getClassName());

				classService.saveClass(classFromDatabase) ;
				response.setDescription("Successfully updated");
				response.setStatuscode(200);
				classResponse.setClassId(classRequest.getClassId());
				classResponse.setClassName(classRequest.getClassName());
				classResponse.setStatus(classFromDatabase.getStatus());
				classResponse.setMedium(classFromDatabase.getMedium().getMediumLanguage());
				classResponse.setEducationBoard(classFromDatabase.getEducationBoard().getEducationBoardName());
			}
		}

		return response;
	}



	
	@GetMapping("/class")
	public ClassListResponse  listAllclasses()
	{
		ClassListResponse res=new ClassListResponse(200, "Success");
		
//		ClassResponse cls= new ClassResponse();
	

		classService.findAll().forEach(clss->{
			res.addclss(new ClassResponse(clss.getClassId(),clss.getClassName(),clss.getStatus(), clss.getMedium().getMediumLanguage(),clss.getEducationBoard().getEducationBoardName()));
		});; 
		if(res.getClasses().size() <= 0) {
			 res.setStatuscode(409);
			 res.setDescription(" No classes found");
		 }
		
		return res;
	}



 


	@GetMapping("/class/{classId}")
	public ClassBaseResponse viewClass(@PathVariable int classId)
	{
		Class cls = classService.findById(classId);
		ClassBaseResponse response = new ClassBaseResponse(200, "Success");
		ClassResponse classResponse= new ClassResponse();
		response.setCls(classResponse);
		if(cls != null)
		{
			classResponse.setClassId(cls.getClassId());
			classResponse.setClassName(cls.getClassName());
			classResponse.setStatus(cls.getStatus());
			classResponse.setMedium(cls.getMedium().getMediumLanguage());
		}else
		{
			response.setStatuscode(400);
			response.setDescription("Failure");
			
		}
		response.setCls(classResponse);
		return response;

	}

	
	@DeleteMapping("/class/{classId}")
	public ClassBaseResponse deleteClassById(@PathVariable int classId)
	{
		ClassBaseResponse response = new ClassBaseResponse(409, "No such Id found");

		Class classFromId = classService.fromClassId(classId);
		if(classFromId != null)
		{
			classService.deleteClass(classFromId);
			response.setDescription("deleted Successfully");
			response.setStatuscode(200);
		}
		return response;

	}

	
	@GetMapping("/subjects/{classId}")
	public List<SubjectResponse> getClassSubjects(@PathVariable int classId){
		
		List<SubjectResponse> subjectList= new ArrayList<>();
	
		Class requestClass = classService.findById(classId);
		if(requestClass != null) {
			requestClass.getSubject().forEach(subject -> {
				if(!subject.getStatus().equalsIgnoreCase(StatusSubject.DELETED)) {
					subjectList.add(new SubjectResponse(
							subject.getSubjectId(),
							subject.getSubjectName(),
							subject.getStatus()
							));
				}
			
			});
		
		}
		return (subjectList);
		
	}

	
}




