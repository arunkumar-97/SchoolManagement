package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

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
	public UserResponse loginuser(@RequestBody UserRequest adminRequest) {

		UserResponse res=new UserResponse(400, "No Such User Found");
		User emailFromDb=userService.findByEmail(adminRequest.getEmail());
		if(emailFromDb!=null) {
			
			if(userService.checkPasswordIsSame(adminRequest.getPassword(), emailFromDb.getPassword())) {
				
			User userFromDb=userService.findByEmailAndPassword(emailFromDb.getEmail(),emailFromDb.getPassword());
			System.out.println(userFromDb);	
			
			UserResponse response=new UserResponse();
				
				
				response.setUserId(userFromDb.getUserId());
				response.setUserName(userFromDb.getUserName());
				response.setEmail(userFromDb.getEmail());
				response.setPhoneNumber(userFromDb.getPhoneNumber());
				response.setUserProfilePicture(userFromDb.getUserProfile().getPictureName());
				response.setAuthenticationType(userFromDb.getAuthentication());
				response.setUserType(userFromDb.getUserType().getUserTypeRole());
				response.setStatuscode(200);
				response.setDescription("Login Successfull");
			return response;
			
			}else {
				UserResponse response1=new UserResponse();
				response1.setStatuscode(409);
				response1.setDescription("Password Invalid");
				return response1;
				
		}

		
		
	}
		return res;	
	}
}
