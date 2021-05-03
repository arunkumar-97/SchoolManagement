package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardResponse;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.repository.SchoolEducationBoardRepository;
import com.jesperapps.schoolmanagement.api.repository.SchoolRepository;


@Service
public class SchoolEducationBoardImplementationService implements SchoolEducationBoardService{
	
	
	@Autowired
	private SchoolEducationBoardRepository schoolEducationBoardRepository;

	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	
	@Autowired
	private EducationBoardService educationBoardService;
	
	@Override
	public Response createSchoolEducationBoard(SchoolEducationBoardRequest schoolEducationBoardRequest) {
		Response response= new Response(409,"Error While Creating");
		
		
		SchoolEducationBoard boards=new SchoolEducationBoard();
		List <SchoolEducationBoard>  Schoolboards = schoolEducationBoardRepository.findAllByEducationBoards_educationBoardIdAndSchool_schoolId(schoolEducationBoardRequest.getEducationBoard().getEducationBoardId(),schoolEducationBoardRequest.getSchool().getSchoolId());
//		  System.out.println("userSubscription"+userSubscription.toString());
//		  System.out.println("userSubscription"+userSubscription.size());
		if(Schoolboards.isEmpty() == false)
		{
			   response.setStatusCode(409);
			   response.setDescription("EducationBoard is Already Assigned for the School");
			   return response;
		}
		boards.setEducationBoards(educationBoardService.findEducationBoardFromId(schoolEducationBoardRequest.getEducationBoard().getEducationBoardId()));
//		classes.setClas(classService.fromClassId(schoolClassesRequest.getClas().getClassId()));
		boards.setSchool(schoolService.findBySchoolId(schoolEducationBoardRequest.getSchool().getSchoolId()));
		schoolEducationBoardRepository.save(boards);
		response.setStatusCode(200);
		response.setDescription("Successfully Created");
		return response;
	}

	@Override
	public void save(SchoolEducationBoard se) {
		// TODO Auto-generated method stub
		schoolEducationBoardRepository.save(se);
	}

//	@Override
//	public SchoolEducationBoard findBySchoolId(Integer schoolId) {
//		// TODO Auto-generated method stub
//		return schoolEducationBoardRepository.findBySchoolId(schoolId);
//	}

	@Override
	public List<SchoolEducationBoard> findBySchool(School schoolFromDb) {
		// TODO Auto-generated method stub
		return schoolEducationBoardRepository.findBySchool(schoolFromDb);
	}

	@Override
	public SchoolEducationBoard findBySchoolEducationBoardId(Integer schoolEducationBoardId) {
		// TODO Auto-generated method stub
		return schoolEducationBoardRepository.findBySchoolEducationBoardId(schoolEducationBoardId);
	}

}
