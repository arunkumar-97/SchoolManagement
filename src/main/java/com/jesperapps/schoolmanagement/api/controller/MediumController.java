package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.ClassListResponse;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.repository.MediumRepository;
import com.jesperapps.schoolmanagement.api.service.MediumService;
import com.jesperapps.schoolmanagement.api.utils.Mediums;

@RestController
public class MediumController {
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private MediumService mediumService;
	
	@GetMapping("/medium")
	public BaseResponse createMedium(){
		BaseResponse response=new BaseResponse(200,"Mediums Created Successfully") {
		};
		Medium medium1=new Medium(11,Mediums.ENGLISH);
		Medium medium2=new Medium(12,Mediums.TAMIL);
		mediumRepository.save(medium1);
		mediumRepository.save(medium2);
		return response;
		
	}
	
	@GetMapping("/medium/{mediumId}")
	public ClassListResponse getAllClasses(@PathVariable int mediumId) {
		ClassListResponse response = new ClassListResponse();
		response.setClasses(mediumService.findMediumClasses(mediumId));
		return response;
	}
	

}
