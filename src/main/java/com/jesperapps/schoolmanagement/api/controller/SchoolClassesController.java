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

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesResponse;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardResponse;
import com.jesperapps.schoolmanagement.api.message.SubscriptionRequest;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;
import com.jesperapps.schoolmanagement.api.service.SchoolClassesService;
import com.jesperapps.schoolmanagement.api.service.SchoolEducationBoardService;
import com.jesperapps.schoolmanagement.api.service.SchoolMediumService;
import com.jesperapps.schoolmanagement.api.service.SchoolService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SchoolClassesController {
	
	
	@Autowired
	private SchoolClassesService schoolClassesServce;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private SchoolEducationBoardService schoolEducationBoardService;
	
	@Autowired
	private SchoolMediumService schoolMediumService;
	
	@PostMapping("/school/class")
	public Response createSchoolClass(@RequestBody SchoolClassesRequest schoolClassesRequest) {
			return schoolClassesServce.createSchoolClass(schoolClassesRequest);
		}
	
	
	@PostMapping("/schools/classes")
	public SchoolClassesResponse createSchoolClasses(@RequestBody List<SchoolClassesRequest> schoolClassesRequest) {
			return schoolClassesServce.createSchoolClasses(schoolClassesRequest);
		}
	
	
	
	@GetMapping("/class/school/{schoolId}")
	private ResponseEntity getAllSubscribedClassForUsers(@PathVariable Integer schoolId){
	
		List<SchoolClassesResponse> response=new ArrayList<>();
		School schoolFromDb=schoolService.findBySchoolId(schoolId);
				if(schoolFromDb != null)
				{
			
					schoolClassesServce.findBySchool(schoolFromDb).forEach(user ->{
	
								response.add(new SchoolClassesResponse(user));
							
	  
					});
		      
					 if(response.isEmpty())
					 {
						 SchoolClassesResponse userResponseEntity = new SchoolClassesResponse();
							userResponseEntity.setStatusCode(201);
							userResponseEntity.setDescription("No Data is Available");
							return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
					 }
					
		
				}else {
					SchoolClassesResponse userResponseEntity = new SchoolClassesResponse();
					userResponseEntity.setStatusCode(201);
					userResponseEntity.setDescription("No Data  Not Found");
					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
				}
	return new ResponseEntity(response, HttpStatus.OK);
		}
	
	

	@GetMapping("/class/school/{schoolId}/{schoolEducationBoardId}/{schoolMediumId}")
	private ResponseEntity getAllSubscribedClassForUsers(@PathVariable Integer schoolId,@PathVariable Integer schoolEducationBoardId,@PathVariable Integer schoolMediumId){
	
		List<SchoolClassesResponse> response=new ArrayList<>();
		School schoolFromDb=schoolService.findBySchoolId(schoolId);
				if(schoolFromDb != null)
				{
			SchoolEducationBoard scheduFromDb=schoolEducationBoardService.findBySchoolEducationBoardId(schoolEducationBoardId);
					if(scheduFromDb != null) {
						SchoolMedium schmedFromDb=	schoolMediumService.findBySchoolMediumId(schoolMediumId);
							if(schmedFromDb != null) {
								schoolClassesServce.findBySchoolAndSchoolEducationBoardAndSchoolMedium(schoolFromDb,scheduFromDb,schmedFromDb).forEach(user ->{
									
									response.add(new SchoolClassesResponse(user));
								
		  
						});
			      
						 if(response.isEmpty())
						 {
							 SchoolClassesResponse userResponseEntity = new SchoolClassesResponse();
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
				
					}else {
						SchoolEducationBoardResponse userResponseEntity = new SchoolEducationBoardResponse();
						userResponseEntity.setStatusCode(201);
						userResponseEntity.setDescription("No Data  Not Found");
						return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
					}
					
					
		
				}else {
					SchoolClassesResponse userResponseEntity = new SchoolClassesResponse();
					userResponseEntity.setStatusCode(201);
					userResponseEntity.setDescription("No Data  Not Found");
					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
				}
	return new ResponseEntity(response, HttpStatus.OK);
		}
	

	


}
