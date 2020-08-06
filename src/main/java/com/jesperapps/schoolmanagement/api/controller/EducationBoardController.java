package com.jesperapps.schoolmanagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.ClassListResponse;
import com.jesperapps.schoolmanagement.api.message.MediumListResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
//import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.repository.EducationBoardRepository;
import com.jesperapps.schoolmanagement.api.service.EducationBoardService;
import com.jesperapps.schoolmanagement.api.utils.EducationBoards;
//import com.jesperapps.schoolmanagement.api.utils.Mediums;

@RestController
public class EducationBoardController {
	
	@Autowired
	private EducationBoardService educationBoardService;
	
	@Autowired
	private EducationBoardRepository educationBoardRepository;
	
	@GetMapping("/educationBoard")
	public BaseResponse createMedium(){
		BaseResponse response=new BaseResponse(200,"EducationBoards Created Successfully") {
		};
		EducationBoard eb1=new EducationBoard(1,EducationBoards.STATEBOARD);
		EducationBoard eb2=new EducationBoard(2,EducationBoards.CBSEBOARD);
		EducationBoard eb3=new EducationBoard(3,EducationBoards.ICSE);
		EducationBoard eb4=new EducationBoard(4,EducationBoards.ISC);
		EducationBoard eb5=new EducationBoard(5,EducationBoards.IB);
		EducationBoard eb6=new EducationBoard(6,EducationBoards.CVE);
		educationBoardRepository.save(eb1);
		educationBoardRepository.save(eb2);
		educationBoardRepository.save(eb3);
		educationBoardRepository.save(eb4);
		educationBoardRepository.save(eb5);
		educationBoardRepository.save(eb6);

		
		return response;
		
	}

	
	@GetMapping("/educationBoard/{educationBoardId}")
	public MediumListResponse getAllmediums(@PathVariable int educationBoardId) {
	      MediumListResponse response = new MediumListResponse();
		response.setMediums(educationBoardService.findeducationBoardMediums(educationBoardId));
		return response;
	}
}
