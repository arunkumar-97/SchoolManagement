package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.UserService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity loginuser(@RequestBody UserRequest adminRequest) {

		
		User emailFromDb=userService.findByEmail(adminRequest.getEmail());
		if(emailFromDb!=null) {
			
			if(userService.checkPasswordIsSame(adminRequest.getPassword(), emailFromDb.getPassword())) {
				
			User userFromDb=userService.findByEmailAndPassword(emailFromDb.getEmail(),emailFromDb.getPassword());
			System.out.println(userFromDb);	
			
			UserResponse response=new UserResponse(userFromDb.getUserId(),userFromDb.getUserName(),userFromDb.getEmail(),userFromDb.getPhoneNumber(),userFromDb.getAuthentication(),userFromDb.getUserProfile().getPictureName(),userFromDb.getUserType().getUserTypeRole());
				
				
//				response.setUserId(userFromDb.getUserId());
//				response.setUserName(userFromDb.getUserName());
//				response.setEmail(userFromDb.getEmail());
//				response.setPhoneNumber(userFromDb.getPhoneNumber());
//				response.setUserProfilePicture(userFromDb.getUserProfile().getPictureName());
//				response.setAuthenticationType(userFromDb.getAuthentication());
//				response.setUserType(userFromDb.getUserType().getUserTypeRole());
//				response.setStatuscode(200);
//				response.setDescription("Login Successfull");
			response.setStatuscode(200);
			response.setDescription("Login Successfull");
			return new ResponseEntity(response,HttpStatus.OK);
			
			}else {
				UserResponse response1=new UserResponse();
				response1.setStatuscode(409);
				response1.setDescription("Password Invalid");
				return new ResponseEntity(response1,HttpStatus.BAD_REQUEST);
				
		}

		
		
	}
		UserResponse response3=new UserResponse();
		response3.setStatuscode(409);
		response3.setDescription("Email does not exists");
		 return new ResponseEntity(response3,HttpStatus.BAD_REQUEST);
	}
}
