package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequest;
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
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BaseResponse(200,"Login SuccessFull") {
				});
				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse(400,"Password Invalid") {
				});
				
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse(409,"No Such Uer Found") {
		});
		
	}	
}
