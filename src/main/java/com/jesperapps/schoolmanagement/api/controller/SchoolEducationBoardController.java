package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.SchoolEducationBoardService;
import com.jesperapps.schoolmanagement.api.service.SchoolService;
import com.jesperapps.schoolmanagement.api.utils.SubscriptionStatusTag;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SchoolEducationBoardController {
	
	
	@Autowired
	private SchoolEducationBoardService schoolEducationBoardService;
	
	
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/school/educationboard")
	public Response createSchoolEducationBoard(@RequestBody SchoolEducationBoardRequest schoolEducationBoardRequest) {
			return schoolEducationBoardService.createSchoolEducationBoard(schoolEducationBoardRequest);
		}

	
	@GetMapping("/school/educationboard/{schoolId}")
	private ResponseEntity getAllboardsforSchool(@PathVariable Integer schoolId){
	
		List<SchoolEducationBoardResponse> response=new ArrayList<>();
			School schoolFromDb=schoolService.findBySchoolId(schoolId);
				if(schoolFromDb != null)
				{
			
				List<SchoolEducationBoard>	ss=schoolEducationBoardService.findBySchool(schoolFromDb);
				ss.forEach(schooleducationBoard ->{
							
							SchoolEducationBoardResponse res=new SchoolEducationBoardResponse(schooleducationBoard);
							EducationBoard eb=new EducationBoard(res.getEducationBoard());
							res.setEducationBoard(eb);
							
							response.add(res);
	  
					});
		      
					 if(response.isEmpty())
					 {
						 SchoolEducationBoardResponse userResponseEntity = new SchoolEducationBoardResponse();
							userResponseEntity.setStatusCode(201);
							userResponseEntity.setDescription("No Data is Available");
							return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
					 }
					
		
				}else {
					SchoolEducationBoardResponse userResponseEntity = new SchoolEducationBoardResponse();
					userResponseEntity.setStatusCode(201);
					userResponseEntity.setDescription("No Data  Not Found");
					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
				}
	return new ResponseEntity(response, HttpStatus.ACCEPTED);
		}

}
