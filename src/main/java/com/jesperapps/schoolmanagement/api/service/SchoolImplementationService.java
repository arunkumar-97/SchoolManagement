package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SchoolRequest;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.model.Attachment;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import com.jesperapps.schoolmanagement.api.repository.SchoolRepository;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;
//import com.jesperapps.schoolmanagement.api.utils.StatusClass;

@Service
public class SchoolImplementationService implements SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;

	
	@Autowired
	private UserProfilePictureService userProfilePictureService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Autowired
	private SchoolEducationBoardService schoolEducationBoardService;
	
	
	@Autowired
	private SchoolMediumService schoolMediumService;
	
	
	
	UserResponse res=new UserResponse();
	@Override
	public School checkSchool(String schoolShortName) {
		
		return schoolRepository.findBySchoolShortNameAndStatusNot(schoolShortName, StatusClass.DELETED);
	}

	@Override
	public School createnewSchool(SchoolRequest schoolRequest) {
		School school=new School();
		school.setSchoolId(schoolRequest.getSchoolId());
		school.setSchoolName(schoolRequest.getSchoolName());
		school.setSchoolShortName(schoolRequest.getSchoolShortName());
		school.setAddress(schoolRequest.getAddress());
		school.setStatus(schoolRequest.getStatus());
		school.setEmail(schoolRequest.getEmail());
		school.setMobileNumber(schoolRequest.getMobileNumber());
		school.setCity(schoolRequest.getCity());
		school.setState(schoolRequest.getState());
		school.setCountry(schoolRequest.getCountry());
		school.setPincode(schoolRequest.getPincode());
		
//	school.setMedium(schoolRequest.getMedium());	
//	school.setEducationBoard(schoolRequest.getEducationBoard());
		schoolRepository.save(school);
		return school;
	}

	@Override
	public School findBySchoolId(Integer integer) {
		// TODO Auto-generated method stub
		return schoolRepository.findBySchoolId(integer);
	}

	@Override
	public Iterable<School> findAll() {
		// TODO Auto-generated method stub
		return schoolRepository.findAll();
	}

	/**
	 *
	 */
	@Override
	public ResponseEntity addSchool(SchoolRequest scRequest) {
		School school=new School();
	School ss	=this.checkSchool(scRequest.getSchoolShortName());
		
	
	
	if(ss != null) {
		ObjectNode jsonObject = objectMapper.createObjectNode();
		jsonObject.put("statusCode", res.SUCCESS);
		jsonObject.put("description", res.setDescription("School Already Exists"));
		return new ResponseEntity(jsonObject, HttpStatus.OK);
	}
	User userWithSameEmailId = userService.findByEmail(scRequest.getUser().getEmail());
	System.out.println("from add admin"+","+ userWithSameEmailId);
	if(userWithSameEmailId == null) {
	Optional<User>	userWithPhNum=userService.findByPhoneNumber(scRequest.getUser().getPhoneNumber());
		if(userWithPhNum.isPresent()) {
			ObjectNode jsonObject = objectMapper.createObjectNode();
			jsonObject.put("statusCode", res.SUCCESS);
			jsonObject.put("description", res.setDescription("User with PhoneNumber Already Exists"));
			return new ResponseEntity(jsonObject, HttpStatus.OK);
		}
	}else {
		ObjectNode jsonObject = objectMapper.createObjectNode();
		jsonObject.put("statusCode", res.SUCCESS);
		jsonObject.put("description", res.setDescription("User with Email Already Exists"));
		return new ResponseEntity(jsonObject, HttpStatus.OK);
	}
		school.setSchoolName(scRequest.getSchoolName());
		school.setSchoolShortName(scRequest.getSchoolShortName());
		school.setAddress(scRequest.getAddress());
		school.setEmail(scRequest.getEmail());
		school.setMobileNumber(scRequest.getMobileNumber());
		school.setStatus(scRequest.getStatus());
		school.setCity(scRequest.getCity());
		school.setState(scRequest.getState());
		school.setCountry(scRequest.getCountry());
		school.setPincode(scRequest.getPincode());
//		school.setEducationBoard(scRequest.getEducationBoard());
//		school.setMedium(scRequest.getMedium());
		School schoolFromDb	=schoolRepository.save(school);
		UserRequestWithProfilePicture newUser=scRequest.getUser();
		System.out.println("User" + scRequest.getUser().toString());
		Set<EducationBoard> eb=scRequest.getEducationBoard();
		if(eb != null) {
			
			School school1=new School(schoolFromDb.getSchoolId());
		for(EducationBoard  e:eb) {
			SchoolEducationBoard se=new SchoolEducationBoard();
			se.setEducationBoards(e);
			se.setSchool(school1);
//			se.setSchool(e.ge);
			schoolEducationBoardService.save(se);
		}
		
		}
		
		Set<Medium> med=scRequest.getMedium();
		if(med != null) {
			School school1=new School(schoolFromDb.getSchoolId());
			
			for(Medium m:med) {
				SchoolMedium sm=new SchoolMedium();
				sm.setMedium(m);
				sm.setSchoolMedium(school1);
				
				schoolMediumService.save(sm);
			}
			
		}
		
		if(newUser != null) {
		
			School school1=new School(schoolFromDb.getSchoolId());
			
			newUser.setSchool(school1);
			UserResponse userResponse =   userService.addadmin(newUser);
		      System.out.println("userResponse"+userResponse.getStatusCode());
		      if(userResponse.getStatusCode() == 200) {
		    		ObjectNode jsonObject = objectMapper.createObjectNode();
					jsonObject.put("statusCode", res.SUCCESS);
					jsonObject.put("description", res.setDescription("User and School Created Successfully"));
					return new ResponseEntity(jsonObject, HttpStatus.OK);
		      }else if(userResponse.getStatusCode() == 409) {
		    	  ObjectNode jsonObject = objectMapper.createObjectNode();
					jsonObject.put("statusCode", res.SUCCESS);
					jsonObject.put("description", res.setDescription("Email Already Exists"));
					return new ResponseEntity(jsonObject, HttpStatus.FORBIDDEN);
		      }
		}
		
		ObjectNode jsonObject = objectMapper.createObjectNode();
		jsonObject.put("statusCode", res.SUCCESS);
		jsonObject.put("description", res.setDescription("User and School Created Successfully"));
		return new ResponseEntity(jsonObject, HttpStatus.OK);
	}

	@Override
	public void deleteSchool(School schoolFromDb) {
		// TODO Auto-generated method stub
		schoolRepository.delete(schoolFromDb);
	}

//	@Override
//	public Iterable<EducationBoard> findBySchool(SchoolEducationBoard schoolFromDb) {
//		// TODO Auto-generated method stub
//		return schoolRepository.findBySchool(schoolFromDb);
//	}



	

	
	

}
