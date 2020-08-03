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
	
	
	@PostMapping("/login")
	public UserResponse loginuser(@RequestBody UserRequest adminRequest) {
		User emailFromDb=userService.findByEmail(adminRequest.getEmail());
		if(emailFromDb!=null) {
			System.out.println(emailFromDb.getEmail()+","+adminRequest.getEmail());
			if(userService.checkPasswordIsSame(adminRequest.getPassword(), emailFromDb.getPassword())) {
				return new UserResponse(emailFromDb);
			}
			
			}
		return new UserResponse();

	}	
}
