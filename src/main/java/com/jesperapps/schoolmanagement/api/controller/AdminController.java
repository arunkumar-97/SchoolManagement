package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.AdminRequest;
import com.jesperapps.schoolmanagement.api.message.AdminResponse;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public List<AdminResponse>  addadmin(@RequestBody List<User> admin){
		adminService.addadmin(admin);
		return admin.stream().map(eachadmin -> new AdminResponse(eachadmin)).collect(Collectors.toList());
	}
	
	@PostMapping("/admin_login")
	public AdminResponse loginadmin(@RequestBody AdminRequest adminRequest) {
		User emailFromDb=adminService.findByEmail(adminRequest.getEmail());
		if(emailFromDb!=null) {
			if(adminService.checkPasswordIsSame(adminRequest.getPassword(), emailFromDb.getPassword())) {
				return new AdminResponse(emailFromDb);
			}
			


			
	}
		return new AdminResponse();

}
	}
