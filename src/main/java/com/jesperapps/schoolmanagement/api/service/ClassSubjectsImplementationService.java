package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.ClassSubjectsRequest;
import com.jesperapps.schoolmanagement.api.message.ClassSubjectsResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesResponse;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.repository.ClassSubjectsRepository;

@Service
public class ClassSubjectsImplementationService implements ClassSubjectsService {
	
	@Autowired
	private ClassSubjectsRepository classSubjectsRepository;

	@Autowired
	private SchoolClassesService schoolClassesService;
	
	@Autowired
	private SubjectService subjectService;
	
	
	@Override
	public Response createSubjectsToClass(ClassSubjectsRequest classSubjectsRequest) {
		// TODO Auto-generated method stub
				Response response= new Response(409,"Error While Creating");
			
					
					ClassSubjects subjects=new ClassSubjects();
					List <ClassSubjects>  classSubjects = classSubjectsRepository.findAllBySchoolClasses_schoolClassesIdAndSubject_subjectId(classSubjectsRequest.getSchoolClasses().getSchoolClassesId(),classSubjectsRequest.getSubject().getSubjectId());
//					  System.out.println("userSubscription"+userSubscription.toString());
//					  System.out.println("userSubscription"+userSubscription.size());
					if(classSubjects.isEmpty() == false)
					{
						   response.setStatusCode(409);
						   response.setDescription("Subject is Already Assigned for the Class");
						   return response;
					}
					subjects.setStatus("Acticve");
					subjects.setSchoolClasses(schoolClassesService.findSchoolClassesFromId(classSubjectsRequest.getSchoolClasses().getSchoolClassesId()));
					subjects.setSubject(subjectService.fromSubjectId(classSubjectsRequest.getSubject().getSubjectId()));
					classSubjectsRepository.save(subjects);
					response.setStatusCode(200);
					response.setDescription("Successfully Created");
					return response;
				
	}


	@Override
	public ClassSubjects findClassSubjectsFromId(Integer classSubjectsId) {
		// TODO Auto-generated method stub
		return classSubjectsRepository.findByClassSubjectsId(classSubjectsId);
	}


	@Override
	public Iterable<ClassSubjects> findBySchoolClasses(SchoolClasses schoolFromDb) {
		// TODO Auto-generated method stub
		return classSubjectsRepository.findBySchoolClasses(schoolFromDb);
	}


	@Override
	public ClassSubjects save(ClassSubjects users) {
		// TODO Auto-generated method stub
		return classSubjectsRepository.save(users);
	}


	@Override
	public ClassSubjectsResponse createMultipleSubjectsToClass(List<ClassSubjectsRequest> classSubjectsRequest) {
		// TODO Auto-generated method stub
		ClassSubjectsResponse response= new ClassSubjectsResponse(409,"Error While Creating");
		
		List<ClassSubjectsResponse> clas=new ArrayList<>();
		for(ClassSubjectsRequest each:classSubjectsRequest) {
			
			ClassSubjects classes=new ClassSubjects(each);
			List <ClassSubjects>  classSubjects = classSubjectsRepository.findAllBySchoolClasses_schoolClassesIdAndSubject_subjectId(each.getSchoolClasses().getSchoolClassesId(),each.getSubject().getSubjectId());
//			  System.out.println("userSubscription"+userSubscription.toString());
//			  System.out.println("userSubscription"+userSubscription.size());
			if(classSubjects.isEmpty() == false)
			{
				ClassSubjectsResponse res=new ClassSubjectsResponse(classSubjects.get(0));	
//				System.out.println("RESPONSE" +res.getSchoolEducationBoard());
				   clas.add(res);
			}else {
				classSubjectsRepository.save(classes);
			}
			
		}
		   System.out.println("clas"+clas.size());
		if(clas.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("Successfully Created");
			return response;
		}else {
			String descrption = null;
			 for(ClassSubjectsResponse cl :  clas)
			 {     
				 if(descrption != null) 
				 {
					 descrption = descrption +","+ cl.getSubject().getSubjectName();
				 }else {
					 descrption =  cl.getSubject().getSubjectName();
				 }
				 
			 }
			response.setStatusCode(409);
			response.setDescription(descrption +" " +"Subject  is Already Assigned for the School");
			return response;
		}
	}

}
