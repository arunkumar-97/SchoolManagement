package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.model.UserType;
import com.jesperapps.schoolmanagement.api.repository.UserTypeRepository;
import com.jesperapps.schoolmanagement.api.utils.UserTypes;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class UserTypeController {
	
	@Autowired
	private UserTypeRepository userRepository;


	@GetMapping("/userType")
	public BaseResponse createUserType() {
		BaseResponse response=new BaseResponse(200,"UserType Created Successfully") {
		};
		UserType user1=new UserType(1,UserTypes.ADMIN);
		UserType user2=new UserType(2,UserTypes.SUPERADMIN);
		UserType user3=new UserType(3,UserTypes.USER);
		UserType user4=new UserType(4,UserTypes.STUDENT);
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		
	
		
		return response  ;
		
	}
}
