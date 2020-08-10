package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
//import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.UserService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public List<UserResponse> addadmin(@ModelAttribute UserRequestWithProfilePicture userRequestWithProfilePicture){
		List<User> createdUsersList = userService.addadmin(userRequestWithProfilePicture.getProfilePicture(), userRequestWithProfilePicture.getUsers());
		return  createdUsersList.stream().map(eachadmin -> new UserResponse(eachadmin)).collect(Collectors.toList());
	}
	
	
	@PostMapping("/check-otp")
	public List<OtpResponse> checkOTP(@RequestBody List<OtpRequest> emailOtpRequest){
		List<OtpResponse> responseList = userService.validateOTP(emailOtpRequest);
		return responseList;
	}
	

}

