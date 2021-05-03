package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolBaseResponse;
import com.jesperapps.schoolmanagement.api.message.SchoolRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolResponse;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.service.EducationBoardService;
import com.jesperapps.schoolmanagement.api.service.MediumService;
import com.jesperapps.schoolmanagement.api.service.SchoolClassesService;
import com.jesperapps.schoolmanagement.api.service.SchoolService;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private EducationBoardService educationBoardService;
	
	@Autowired
	private SchoolClassesService schoolClassesService;
	
	@Autowired
	private MediumService mediumService;
	
	
	/**
	 * @param schoolRequest
	 * @return
	 */
	
	
	@PostMapping("/school/registration")
	public ResponseEntity createSchool(@RequestBody SchoolRequest scRequest) {
		
		School school=schoolService.checkSchool(scRequest.getSchoolShortName());
		if(school!= null)
		{
			Response response=new Response();
			response.setStatusCode(409);
			response.setDescription("School Already Exists");
			return  (ResponseEntity) ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
		}
		else
		{
		ResponseEntity createdSchool=schoolService.addSchool(scRequest);
		return createdSchool;
		}
		
	}
	
	
	
	
	@PostMapping("/school")
	public SchoolBaseResponse checkclass(@RequestBody SchoolRequest schoolRequest ) 
	{
		SchoolBaseResponse response= new SchoolBaseResponse(409,"School Already Exists");
		SchoolResponse schoolResponse=new SchoolResponse();
		
		School school=schoolService.checkSchool(schoolRequest.getSchoolShortName());
		
		if(school!= null)
		{
			response.setStatusCode(409);
			response.setDescription("School Already Exists");
			return response;
		}
		else
		{
			School newClass =schoolService.createnewSchool(schoolRequest);
			schoolResponse.setSchoolName(newClass.getSchoolName());
			schoolResponse.setSchoolShortName(newClass.getSchoolShortName());
			
			
//			classResponse.setClassName(newClass.getClassName());
//			classResponse.setStatus(StatusClass.getStatus(newClass.getStatus()));
//			classResponse.setMedium(newClass.getMedium().getMediumLanguage());
//			classResponse.setEducationBoard(newClass.getEducationBoard().getEducationBoardName());
			
//			response.setCls(classResponse);
			response.setSchools(schoolResponse);
			response.setStatusCode(200);
			response.setDescription("School Created Successfully");
		}


		return response;
	}
	
	


	

	
//	@GetMapping("/medium/{schoolId}")
//	private ResponseEntity getAllMediumForSchool(@PathVariable Integer schoolId){
//	
//		List<Medium> response=new ArrayList<>();
//			School schoolFromDb=schoolService.findBySchoolId(schoolId);
//				if(schoolFromDb != null)
//				{
//			
//					mediumService.findBySchool(schoolFromDb).forEach(board ->{
//	
//										response.add(new Medium(board));
//							
//	  
//					});
//		      
//					 if(response.isEmpty())
//					 {
//						 Medium userResponseEntity = new Medium();
//							userResponseEntity.setStatusCode(201);
//							userResponseEntity.setDescription("No Data is Available");
//							return new ResponseEntity(userResponseEntity, HttpStatus.NOT_FOUND);
//					 }
//					
//		
//				}else {
//					Medium userResponseEntity = new Medium();
//					userResponseEntity.setStatusCode(201);
//					userResponseEntity.setDescription("No Data  Not Found");
//					return new ResponseEntity(userResponseEntity, HttpStatus.CONFLICT);
//				}
//	return new ResponseEntity(response, HttpStatus.OK);
//		}

	

	@GetMapping("/school")
	private List<SchoolResponse> getAllSchools() {
		
		List<SchoolResponse> response=new ArrayList<>();
		schoolService.findAll().forEach(year ->{
			response.add(new SchoolResponse(year));
			});
			return response;
	}
	
	
	@GetMapping("/school/{schoolId}")
	public ResponseEntity viewUser(@PathVariable int schoolId)
	{
		School schoolFromDb=schoolService.findBySchoolId(schoolId);
		SchoolResponse schoolResponse= new SchoolResponse();
		if(schoolFromDb != null)
		{
			
			schoolResponse.setSchoolId(schoolFromDb.getSchoolId());
			schoolResponse.setSchoolName(schoolFromDb.getSchoolName());
			schoolResponse.setSchoolShortName(schoolFromDb.getSchoolShortName());
			schoolResponse.setAddress(schoolFromDb.getAddress());
			schoolResponse.setEmail(schoolFromDb.getEmail());
			schoolResponse.setMobileNumber(schoolFromDb.getMobileNumber());
			schoolResponse.setStatus(schoolFromDb.getStatus());
			schoolResponse.setCity(schoolFromDb.getCity());
			schoolResponse.setCountry(schoolFromDb.getCountry());
			schoolResponse.setState(schoolFromDb.getState());
//			schoolResponse.setEducationBoard(schoolFromDb.getEducationBoard());
//			schoolResponse.setMedium(schoolFromDb.getMedium());
//			
//			userResponse.setUserId(user.getUserId());
//			userResponse.setUserName(user.getUserName());
//			userResponse.setEmail(user.getEmail());
//
//			userResponse.setPhoneNumber(user.getPhoneNumber());
//			userResponse.setUserType(user.getUserType().getUserTypeRole());
//			userResponse.setUserProfilePicture(user.getUserProfile().getPictureName());
//			userResponse.setAuthenticationType(user.getAuthentication());
//			userResponse.setStatusCode(200);
//			userResponse.setDescription("User Listed Successfully");
//			userResponse.setSubscriptionFormFromUser(user.getSubscriptionForm());
			

		}
		return new ResponseEntity(schoolResponse,HttpStatus.OK);

	}
	
	
	@DeleteMapping("/school/{schoolId}")
	public SchoolBaseResponse deleteYearById(@PathVariable Integer schoolId)
	{
		SchoolBaseResponse response = new SchoolBaseResponse(409, "No such Id found");

		School schoolFromDb=schoolService.findBySchoolId(schoolId);
		if(schoolFromDb != null)
		{
			schoolService.deleteSchool(schoolFromDb);
//			yearService.deleteYear(YearFromDb);
			response.setDescription("deleted Successfully");
			response.setStatusCode(200);
		}
		return response;

	}
	

}
