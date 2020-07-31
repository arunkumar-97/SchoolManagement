package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.model.UserType;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;



@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	
	private static final String ADMIN = "ADMIN";
	private static final String SUPERADMIN = "SUPERADMIN";
	private static final String USER = "USER";
	private static final String STUDENT = "STUDENT";

	@GetMapping("/userType")
	public String createUserType() {
		
		UserType user1=new UserType(1,ADMIN);
		UserType user2=new UserType(2,SUPERADMIN);
		UserType user3=new UserType(3,USER);
		UserType user4=new UserType(4,STUDENT);
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		
	
		
		return "created";
		
	}
}
