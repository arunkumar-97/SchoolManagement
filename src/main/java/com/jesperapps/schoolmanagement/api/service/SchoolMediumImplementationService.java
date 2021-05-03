package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolMediumRequest;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;
import com.jesperapps.schoolmanagement.api.repository.SchoolMediumRepository;

@Service
public class SchoolMediumImplementationService implements SchoolMediumService {

	
	@Autowired
	private SchoolMediumRepository schoolMediumRepository;
	
	
	@Autowired
	private MediumService mediumService;
	
	@Autowired
	private SchoolService schoolService;

	@Override
	public Response createSchoolMedium(SchoolMediumRequest schoolMediumRequest) {
		Response response= new Response(409,"Error While Creating");
		
		
	SchoolMedium mediums=new SchoolMedium();
		List <SchoolMedium>  Schoolmediums = schoolMediumRepository.findAllByMedium_mediumIdAndSchoolMedium_schoolId(schoolMediumRequest.getMedium().getMediumId(),schoolMediumRequest.getSchool().getSchoolId());
//		  System.out.println("userSubscription"+userSubscription.toString());
//		  System.out.println("userSubscription"+userSubscription.size());
		if(Schoolmediums.isEmpty() == false)
		{
			   response.setStatusCode(409);
			   response.setDescription("Medium is Already Assigned for the School");
			   return response;
		}
		mediums.setMedium(mediumService.findMediumFromId(schoolMediumRequest.getMedium().getMediumId()));
//		classes.setClas(classService.fromClassId(schoolClassesRequest.getClas().getClassId()));
		mediums.setSchoolMedium(schoolService.findBySchoolId(schoolMediumRequest.getSchool().getSchoolId()));
		schoolMediumRepository.save(mediums);
		response.setStatusCode(200);
		response.setDescription("Successfully Created");
		return response;
	}

	@Override
	public void save(SchoolMedium sm) {
		// TODO Auto-generated method stub
		schoolMediumRepository.save(sm);
	}

	@Override
	public List<SchoolMedium> findBySchool(School schoolFromDb) {
		// TODO Auto-generated method stub
		return schoolMediumRepository.findBySchoolMedium(schoolFromDb);
	}

	@Override
	public SchoolMedium findBySchoolMediumId(Integer schoolMediumId) {
		// TODO Auto-generated method stub
		return schoolMediumRepository.findBySchoolMediumId(schoolMediumId);
	}
	
	
	
}
