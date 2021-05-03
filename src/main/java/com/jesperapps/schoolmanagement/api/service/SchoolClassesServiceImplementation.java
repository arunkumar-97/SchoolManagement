package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesResponse;
import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;
import com.jesperapps.schoolmanagement.api.repository.SchoolClassesRepository;

@Service
public class SchoolClassesServiceImplementation implements SchoolClassesService {

	
	@Autowired
	private SchoolClassesRepository schoolClassesRepository;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private SchoolEducationBoardService schoolEducationBoardService;
	
	@Autowired
	private SchoolMediumService schoolMediumService;

	@Override
	public Response createSchoolClass(SchoolClassesRequest schoolClassesRequest) {
		// TODO Auto-generated method stub
		Response response= new Response(409,"Error While Creating");
	
			
			SchoolClasses classes=new SchoolClasses();
			List <SchoolClasses>  SchoolClasses = schoolClassesRepository.findAllByClas_classIdAndSchool_schoolIdAndSchoolEducationBoard_schoolEducationBoardIdAndSchoolMedium_schoolMediumId(schoolClassesRequest.getClas().getClassId(),schoolClassesRequest.getSchool().getSchoolId(),schoolClassesRequest.getSchoolEducationBoard().getSchoolEducationBoardId(),schoolClassesRequest.getSchoolMedium().getSchoolMediumId());
//			  System.out.println("userSubscription"+userSubscription.toString());
//			  System.out.println("userSubscription"+userSubscription.size());
			if(SchoolClasses.isEmpty() == false)
			{
				   response.setStatusCode(409);
				   response.setDescription("Class is Already Assigned for the School");
				   return response;
			}
			classes.setClas(classService.fromClassId(schoolClassesRequest.getClas().getClassId()));
			classes.setSchool(schoolService.findBySchoolId(schoolClassesRequest.getSchool().getSchoolId()));
			classes.setSchoolEducationBoard(schoolEducationBoardService.findBySchoolEducationBoardId(schoolClassesRequest.getSchoolEducationBoard().getSchoolEducationBoardId()));
			classes.setSchoolMedium(schoolMediumService.findBySchoolMediumId(schoolClassesRequest.getSchoolMedium().getSchoolMediumId()));
			schoolClassesRepository.save(classes);
			response.setStatusCode(200);
			response.setDescription("Successfully Created");
			return response;
		
	
		
	}

	
	
	@Override
	public SchoolClassesResponse createSchoolClasses(List<SchoolClassesRequest> schoolClassesRequest) {
		// TODO Auto-generated method stub
		SchoolClassesResponse response= new SchoolClassesResponse(409,"Error While Creating");
		
		List<SchoolClassesResponse> clas=new ArrayList<>();
		for(SchoolClassesRequest each:schoolClassesRequest) {
			
			SchoolClasses classes=new SchoolClasses(each);
			List <SchoolClasses>  SchoolClasses = schoolClassesRepository.findAllByClas_classIdAndSchool_schoolIdAndSchoolEducationBoard_schoolEducationBoardIdAndSchoolMedium_schoolMediumId(each.getClas().getClassId(),each.getSchool().getSchoolId(),each.getSchoolEducationBoard().getSchoolEducationBoardId(),each.getSchoolMedium().getSchoolMediumId());
//			  System.out.println("userSubscription"+userSubscription.toString());
//			  System.out.println("userSubscription"+userSubscription.size());
			if(SchoolClasses.isEmpty() == false)
			{
				SchoolClassesResponse res=new SchoolClassesResponse(SchoolClasses.get(0));	
				System.out.println("RESPONSE" +res.getSchoolEducationBoard());
				   clas.add(res);
			}else {
				schoolClassesRepository.save(classes);
			}
			
		}
		   System.out.println("clas"+clas.size());
		if(clas.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("Successfully Created");
			return response;
		}else {
			String descrption = null;
			 for(SchoolClassesResponse cl :  clas)
			 {     
				 if(descrption != null) 
				 {
					 descrption = descrption +","+ cl.getClas().getClassName();
				 }else {
					 descrption =  cl.getClas().getClassName();
				 }
				 
			 }
			response.setStatusCode(409);
			response.setDescription(descrption +" " +"Classes  is Already Assigned for the School");
			return response;
		}
		
	}
	
	
	@Override
	public List<SchoolClasses> findBySchool(School schoolFromDb) {
		// TODO Auto-generated method stub
		return this.schoolClassesRepository.findBySchool(schoolFromDb);
	}



	@Override
	public SchoolClasses findSchoolClassesFromId(Integer schoolClassesId) {
		// TODO Auto-generated method stub
		return schoolClassesRepository.findBySchoolClassesId(schoolClassesId);
	}



	@Override
	public SchoolClasses findByShoolClassesId(Integer schoolClassesId) {
		return schoolClassesRepository.findBySchoolClassesId(schoolClassesId);
	}



	@Override
	public Iterable<SchoolClasses> findBySchoolAndSchoolEducationBoardAndSchoolMedium(School schoolFromDb,
			SchoolEducationBoard scheduFromDb, SchoolMedium schmedFromDb2) {
		return schoolClassesRepository.findBySchoolAndSchoolEducationBoardAndSchoolMedium(schoolFromDb,scheduFromDb,schmedFromDb2);
	}

	
}
