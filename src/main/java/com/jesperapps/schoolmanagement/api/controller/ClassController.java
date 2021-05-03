package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.api.message.ClassBaseResponse;
import com.jesperapps.schoolmanagement.api.message.ClassRequest;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.EducationBoardService;
import com.jesperapps.schoolmanagement.api.service.MediumService;
import com.jesperapps.schoolmanagement.api.service.SchoolService;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class ClassController {


	@Autowired
	private ClassService classService; 

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private EducationBoardService educationBoardService;
	
	@Autowired
	private MediumService mediumService;
	
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/class")
	public ClassBaseResponse checkclass(@RequestBody ClassRequest classRequest ) 
	{
		ClassBaseResponse response= new ClassBaseResponse(409,"Class Already Exists");
		ClassResponse classResponse=new ClassResponse();
		
		Class classOfName=classService.checkclass(classRequest.getClassName(),classRequest.getEducationBoard(),classRequest.getMedium());
		
		if(classOfName!= null)
		{
			
		}
		else
		{
			Class newClass =classService.createnewclass(classRequest.getClassName(),classRequest.getClassId(),StatusClass.getStatus(classRequest.getStatus()),classRequest.getMedium().getMediumId(),classRequest.getEducationBoard().getEducationBoardId());
			classResponse.setClassId(newClass.getClassId());
			classResponse.setClassName(newClass.getClassName());
			classResponse.setStatus(StatusClass.getStatus(newClass.getStatus()));
			classResponse.setMedium(newClass.getMedium());
			classResponse.setEducationBoard(newClass.getEducationBoard());
//			classResponse.setSchool(newClass.getSchool());
			response.setCls(classResponse);
			response.setStatusCode(200);
			response.setDescription("Class Created Successfully");
		}


		return response;
	}
	
	@PostMapping("/class/subject/{classId}")
	public ClassBaseResponse addSubjectToClass(@PathVariable int classId, @RequestBody List<SubjectRequest> subjectRequestList) {
		ClassBaseResponse response = new ClassBaseResponse(409, "No such ClassId Found");
		Class requestClass = classService.findById(classId);
		if(requestClass != null) {
				List<Subject> classListOfSubject = new ArrayList<>();
					for(SubjectRequest subject : subjectRequestList) {
						Subject subjectFromDB=null;
							if(subject.getSubjectId() == null) {
//								subjectFromDB = subjectService.checksubject(subject.getSubjectName());	
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
//				requestClass.setSubject(classListOfSubject);
				classService.saveClass(requestClass);
				response.setDescription("Subjects added Successfully");
				response.setStatusCode(200);
		}
		return response;
	}

	
	@PutMapping("/class/{classId}")
	public ClassBaseResponse updateClassName(@PathVariable Integer classId, @RequestBody ClassRequest classRequest)
	{
		ClassBaseResponse response = new ClassBaseResponse(409,"No such Id found");
		ClassResponse classResponse=new ClassResponse();
		response.setCls(classResponse);
		if(classId != null) 
		{
			Class classFromDatabase = classService.fromClassId(classId);
			if(classFromDatabase != null) 
			{

				classFromDatabase.setClassName(classRequest.getClassName());

				classService.saveClass(classFromDatabase) ;
				response.setDescription("Successfully updated");
				response.setStatusCode(200);
				classResponse.setClassId(classFromDatabase.getClassId());
				classResponse.setClassName(classRequest.getClassName());
				classResponse.setStatus(classFromDatabase.getStatus());
				classResponse.setMedium(classFromDatabase.getMedium());
				classResponse.setEducationBoard(classFromDatabase.getEducationBoard());
			}
		}

		return response;
	}



	
	@GetMapping("/class")
	public List<ClassResponse>  listAllclasses()
	{
		List<ClassResponse> res=new ArrayList<>();
		
		classService.findAll().forEach(clss->{
			res.add(new ClassResponse(clss.getClassId(),clss.getClassName(),clss.getStatus(), clss.getMedium(),clss.getEducationBoard()));
		});
		return res;
	}



 


	@GetMapping("/class/{classId}")
	public ClassResponse viewClass(@PathVariable int classId)
	{
		Class cls = classService.findById(classId);
		ClassResponse classResponse= new ClassResponse();
		if(cls != null)
		{
			classResponse.setClassId(cls.getClassId());
			classResponse.setClassName(cls.getClassName());
			classResponse.setStatus(cls.getStatus());
			classResponse.setMedium(cls.getMedium());
			classResponse.setEducationBoard(cls.getEducationBoard());
		}
		return classResponse;

	}
	@GetMapping("/class/{educationBoardId}/{mediumId}")
	private ResponseEntity getAllSubscribedClassForUsers(@PathVariable Integer educationBoardId,@PathVariable Integer mediumId){
	
		List<ClassResponse> response=new ArrayList<>();
			Optional<EducationBoard> educationBoardDb=educationBoardService.findById(educationBoardId);
				if(educationBoardDb != null)
				{
			
				Medium	mediumFromDb=mediumService.findById(mediumId);
							if(mediumFromDb != null) {
							
								classService.findAll().forEach(user ->{
									response.add(new ClassResponse(user));
							
//									response.add(new SubscriptionResponse(user.getSubscriptionId(),user.getMedium(),user.getSubscriptionStatus(),user.getEducationBoard(),user.getUser(),user.getSubscriptionClass()));
							
	  
					});
		      
					 if(response.isEmpty())
					 {
						 ClassResponse userResponseEntity = new ClassResponse();
							userResponseEntity.setStatusCode(201);
							userResponseEntity.setDescription("No Data is Available");
							return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
					 }
					
		
				}else {
					ClassResponse userResponseEntity = new ClassResponse();
					userResponseEntity.setStatusCode(201);
					userResponseEntity.setDescription("No Data  Not Found");
					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
				}
							return new ResponseEntity(response, HttpStatus.ACCEPTED);
				}
				return new ResponseEntity(response, HttpStatus.ACCEPTED);
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
			response.setStatusCode(200);
		}
		return response;

	}

	
//	@GetMapping("/subjects/{classId}")
//	public List<SubjectResponse> getClassSubjects(@PathVariable int classId){
//		
//		List<SubjectResponse> subjectList= new ArrayList<>();
//	
//		Class requestClass = classService.findById(classId);
//		if(requestClass != null) {
//			requestClass.getSubject().forEach(subject -> {
//
//				if(!subject.getStatus().equalsIgnoreCase(StatusSubject.DELETED)) {
//					subjectList.add(new SubjectResponse(
//							subject.getSubjectId(),
//							subject.getSubjectName(),
//							subject.getStatus()
//							
//							));
//				}
//			
//			});
//		
//		}
//		return (subjectList);
//		
//	}
}
	
	
	




