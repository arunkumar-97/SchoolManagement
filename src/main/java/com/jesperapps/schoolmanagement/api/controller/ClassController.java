package com.jesperapps.schoolmanagement.api.controller;



import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.api.message.ClassListResponse;
import com.jesperapps.schoolmanagement.api.message.ClassRequest;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectListResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.service.SubjectService;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;


@RestController
public class ClassController {


	@Autowired
	private ClassService classService; 

	@Autowired
	private SubjectService subjectService;



	@PostMapping("/class")
	public ClassResponse checkclass(@RequestBody ClassRequest classRequest ) 
	{
		ClassResponse response1= new ClassResponse(200,"ClassIsCreated");		
		//		for(ClassRequest eachclass:classRequest) 
		//		{
		Class classOfName=classService.checkclass( classRequest.getClassName());
		ClassResponse response= new ClassResponse(409,"classexists");

		if(classOfName != null) 
		{
			return response;
		}
		else
		{
			@SuppressWarnings("unused")
			Class newClass =classService.createnewclass(classRequest.getClassName(),classRequest.getClassId(),StatusClass.getStatus(classRequest.getStatus()));
		}


		return response1;
	}

	@PostMapping("/addSubject/{classId}")
	public ClassResponse addSubjectToClass(@PathVariable int classId, @RequestBody List<SubjectRequest> subjectRequestList) {
		ClassResponse response = new ClassResponse(400, "Bad request");
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
			response.setDescription("Success");
			response.setStatuscode(200);
		}
		return response;
	}


	@PutMapping("/class")
	public ClassResponse updateClassName(@RequestBody ClassRequest classRequest)
	{
		ClassResponse response = new ClassResponse(409,"No such Id found");
		if(classRequest.getClassId() != null) 
		{
			Class classFromDatabase = classService.fromClassId(classRequest.getClassId());
			if(classFromDatabase != null) 
			{

				classFromDatabase.setClassName(classRequest.getClassName());

				classService.saveClass(classFromDatabase) ;
				response.setDescription("Successfully updated");
				response.setStatuscode(200);

			}
		}

		return response;
	}




	@GetMapping("/class")
	public List<ClassListResponse>  listAllclasses()
	{
		List<ClassListResponse> res=new ArrayList<ClassListResponse>();

		classService.findAll().forEach(cls->{
			res.add(new ClassListResponse(cls.getClassId(),cls.getClassName(),cls.getStatus()));
		});;
		return res;
	}



 


	@GetMapping("/class/{classId}")
	public ClassListResponse viewClass(@PathVariable int classId)
	{
		Class cls = classService.findById(classId);

		if(cls != null)
		{
			return(new ClassListResponse(cls.getClassId(),cls.getClassName(),cls.getStatus()));
		}else
		{
			cls = new Class();

		}
		return new ClassListResponse(cls.getClassId(),cls.getClassName(),cls.getStatus()) ;

	}


	@DeleteMapping("/Class/{classId}")
	public ClassResponse deleteClassById(@PathVariable int classId)
	{
		ClassResponse response = new ClassResponse(409, "No such Id found");

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
	public List<SubjectListResponse> getClassSubjects(@PathVariable int classId){
		
		List<SubjectListResponse> subjectList= new ArrayList<>();
	
		Class requestClass = classService.findById(classId);
		if(requestClass != null) {
			requestClass.getSubject().forEach(subject -> {
				subjectList.add(new SubjectListResponse(
						subject.getSubjectId(),
						subject.getSubjectName(),
						subject.getStatus()
						));
			
			});
		
		}
		return (subjectList);
		
	}

	
}




