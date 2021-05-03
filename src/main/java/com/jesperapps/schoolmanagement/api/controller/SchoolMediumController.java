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
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardResponse;
import com.jesperapps.schoolmanagement.api.message.SchoolMediumRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolMediumResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;
import com.jesperapps.schoolmanagement.api.service.SchoolMediumService;
import com.jesperapps.schoolmanagement.api.service.SchoolService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SchoolMediumController {

	
	
	@Autowired
	private SchoolMediumService schoolMediumService;
	
	@Autowired
	private SchoolService schoolService;
	
	
	
	@PostMapping("/school/medium")
	public Response createSchoolMedium(@RequestBody SchoolMediumRequest schoolMediumRequest) {
			return schoolMediumService.createSchoolMedium(schoolMediumRequest);
		}
	
	@GetMapping("/school/medium/{schoolId}")
	private ResponseEntity getAllboardsforSchool(@PathVariable Integer schoolId){
	
		List<SchoolMediumResponse> response=new ArrayList<>();
			School schoolFromDb=schoolService.findBySchoolId(schoolId);
				if(schoolFromDb != null)
				{
			
				List<SchoolMedium>	ss=schoolMediumService.findBySchool(schoolFromDb);
				ss.forEach(schoolmedium ->{
							
					SchoolMediumResponse res=new SchoolMediumResponse(schoolmedium);
							Medium eb=new Medium(res.getMedium());
							res.setMedium(eb);;
							
							response.add(res);
	  
					});
		      
					 if(response.isEmpty())
					 {
						 SchoolMediumResponse userResponseEntity = new SchoolMediumResponse();
							userResponseEntity.setStatusCode(201);
							userResponseEntity.setDescription("No Data is Available");
							return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
					 }
					
		
				}else {
					SchoolMediumResponse userResponseEntity = new SchoolMediumResponse();
					userResponseEntity.setStatusCode(201);
					userResponseEntity.setDescription("No Data  Not Found");
					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
				}
	return new ResponseEntity(response, HttpStatus.ACCEPTED);
		}

}
