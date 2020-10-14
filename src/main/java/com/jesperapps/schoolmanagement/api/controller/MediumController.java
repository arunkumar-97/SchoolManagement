package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.repository.MediumRepository;
import com.jesperapps.schoolmanagement.api.service.MediumService;
import com.jesperapps.schoolmanagement.api.utils.Mediums;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class MediumController {
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private MediumService mediumService;

	@PostMapping("/medium")
	public BaseResponse createMedium(){
		BaseResponse response=new BaseResponse(200,"Mediums Created Successfully") {
		};
		Medium medium1=new Medium(11,Mediums.ENGLISH);
		Medium medium2=new Medium(12,Mediums.TAMIL);
		mediumRepository.save(medium1);
		mediumRepository.save(medium2);
		return response;
		
	}
	
	//
	@GetMapping("/class/medium/{mediumId}")
	public List<ClassResponse> getAllClasses(@PathVariable int mediumId) {
		List<ClassResponse> response=new ArrayList<>();

		response.addAll(mediumService.findMediumClasses(mediumId));
		return response;
	}
	
	
	@GetMapping("/medium")
	public List<MediumResponse>  listAllclasses()
	{
		List<MediumResponse> res=new ArrayList<> ();
		
		mediumService.findAll().forEach(medium->{
			res.add(new MediumResponse(medium));
		});
		
		return res;
	}

	//post, GET, DELETE ;/ medium
	//put, GETBYID, DELETEBYID; /medium/{mediumId}
	
	//total medium listing required
	

}
