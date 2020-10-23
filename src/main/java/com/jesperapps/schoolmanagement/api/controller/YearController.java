package com.jesperapps.schoolmanagement.api.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.YearBaseResponse;
import com.jesperapps.schoolmanagement.api.message.YearRequest;
import com.jesperapps.schoolmanagement.api.message.YearResponse;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.service.YearService;




@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class YearController {
	
	
	
	@Autowired
	private YearService yearService;
	
	
	@PostMapping("/year")
	private YearBaseResponse createYear(@RequestBody YearRequest yearRequest) {
		YearBaseResponse response=new YearBaseResponse(409,"Year Already Exists");
		YearResponse yearResponse=new YearResponse();
		Year yearName=yearService.checkYear(yearRequest.getYear());
		if(yearName == null) {
			Year newYear=yearService.createnewYear(yearRequest.getYear(),yearRequest.getYearId());
			yearResponse.setYearId(newYear.getYearId());
			yearResponse.setYear(newYear.getYear());
			response.setYear(yearResponse);
			response.setStatuscode(200);
			response.setDescription("Year Created Successfully");
			
		}
		return response;
	}
	
	@PostMapping("/years")
	private YearBaseResponse createYears(@RequestBody List<YearRequest> yearRequestList) {
		YearResponse yearResponse= new YearResponse();
		YearBaseResponse response = new YearBaseResponse(200, "Years created successfully");
		response.setYear(null);
		yearRequestList.forEach(yearRequest -> {
			Year yearFromDB = yearService.checkYear(yearRequest.getYear());
			if(yearFromDB == null) {
				yearService.createnewYear(yearRequest.getYear(),yearRequest.getYearId());				
			}else {
				yearResponse.setYearId(yearFromDB.getYearId());
				yearResponse.setYear(yearFromDB.getYear());
				response.setYear(yearResponse);
				response.setStatuscode(409);
				response.setDescription("Year already exists");
			}
		});
		return response;
	}
	
	@GetMapping("/year")
	private List<YearResponse> getAllYears() {
		
		List<YearResponse> response=new ArrayList<>();
			yearService.findAll().forEach(year ->{
				response.add(new YearResponse(year.getYearId(),year.getYear()));
			});
			return response;
	}
	
	@GetMapping("/year/{yearId}")
		private YearResponse getYearById(@PathVariable Integer yearId) {
			Year YearFromDb=yearService.findById(yearId);
			YearResponse response =new YearResponse();
			if(YearFromDb != null) {
				response.setYearId(YearFromDb.getYearId());
				response.setYear(YearFromDb.getYear());
				}
		return response;
	}
	
}
