package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.EducationBoardBaseResponse;
import com.jesperapps.schoolmanagement.api.message.EducationBoardJson;
import com.jesperapps.schoolmanagement.api.message.EducationBoardResponse;
import com.jesperapps.schoolmanagement.api.message.MediumListResponse;
import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.message.YearBaseResponse;
import com.jesperapps.schoolmanagement.api.message.YearRequest;
import com.jesperapps.schoolmanagement.api.message.YearResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.Year;
//import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.repository.EducationBoardRepository;
import com.jesperapps.schoolmanagement.api.service.EducationBoardService;
import com.jesperapps.schoolmanagement.api.utils.EducationBoards;
//import com.jesperapps.schoolmanagement.api.utils.Mediums;
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class EducationBoardController {
	
	@Autowired
	private EducationBoardService educationBoardService;
	
	@Autowired
	private EducationBoardRepository educationBoardRepository;
	
	
//	@CrossOrigin(origins="*",allowedHeaders="*")
//	@PostMapping("/education-board")
//	public BaseResponse createEducationBoard(){
//		BaseResponse response=new BaseResponse(200,"EducationBoards Created Successfully") {
//		};
//		EducationBoard eb1=new EducationBoard(1,EducationBoards.STATEBOARD);
//		EducationBoard eb2=new EducationBoard(2,EducationBoards.CBSEBOARD);
//		EducationBoard eb3=new EducationBoard(3,EducationBoards.ICSE);
//		EducationBoard eb4=new EducationBoard(4,EducationBoards.ISC);
//		EducationBoard eb5=new EducationBoard(5,EducationBoards.IB);
//		EducationBoard eb6=new EducationBoard(6,EducationBoards.CVE);
//		educationBoardRepository.save(eb1);
//		educationBoardRepository.save(eb2);
//		educationBoardRepository.save(eb3);
//		educationBoardRepository.save(eb4);
//		educationBoardRepository.save(eb5);
//		educationBoardRepository.save(eb6);
//
//		
//		return response;
//		
//	}

	@PostMapping("/educationboards")
	private EducationBoardResponse createEducationBoards(@RequestBody List<EducationBoardJson> boardRequestList) {
//		List<EducationBoardResponse> boardResponse= new ArrayList<>();
//		EducationBoardBaseResponse brresponse = new EducationBoardBaseResponse();
//		EducationBoardBaseResponse response = new EducationBoardBaseResponse(200, "Boards created successfully");
////		response.setEducationBoard(null);
//		boardRequestList.forEach(boardRequest -> {
//			EducationBoard boardFromDB = educationBoardService.checkEducationBoardName(boardRequest.getEducationBoardName());
//			if(boardFromDB == null) {
//				educationBoardService.createnewEducationBoard(boardRequest.getEducationBoardId(),boardRequest.getEducationBoardName());				
//			}else {
//				for(EducationBoardResponse each:boardResponse) {
//					System.out.println("each" + each.getEducationBoardName());
//					each.setEducationBoardId(boardFromDB.getEducationBoardId());
//					each.setEducationBoardName(boardFromDB.getEducationBoardName());
////					yearResponse.setYearId(yearFromDB.getYearId());
////					yearResponse.setYear(yearFromDB.getYear());
//					
//					
//					
//					
//				}
//				
//				boardResponse.add(each);
//				brresponse.setStatusCode(409);
//				brresponse.setDescription("Board already exists");
//				return brresponse;
//				
//				
//			}
//			
//			});
//		return response;
//			
//		
		
		
		
		

		// TODO Auto-generated method stub
		EducationBoardResponse response= new EducationBoardResponse(409,"Error While Creating");
		
		List<EducationBoardResponse> clas=new ArrayList<>();
		for(EducationBoardJson each:boardRequestList) {
			
			EducationBoard boards=new EducationBoard(each);
			List <EducationBoard>  eduboards = educationBoardService.findAllByEducationBoardName(boards.getEducationBoardName());
//			  System.out.println("userSubscription"+userSubscription.toString());
//			  System.out.println("userSubscription"+userSubscription.size());
			if(eduboards.isEmpty() == false)
			{
				EducationBoardResponse res=new EducationBoardResponse(eduboards.get(0));	
//				System.out.println("RESPONSE" +res.getSchoolEducationBoard());
				   clas.add(res);
			}else {
				educationBoardService.save(boards);
			}
			
		}
		   System.out.println("clas"+clas.size());
		if(clas.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("Successfully Created");
			return response;
		}else {
			String descrption = null;
			 for(EducationBoardResponse cl :  clas)
			 {     
				 if(descrption != null) 
				 {
					 descrption = descrption +","+ cl.getEducationBoardName();
				 }else {
					 descrption =  cl.getEducationBoardName();
				 }
				 
			 }
			response.setStatusCode(409);
			response.setDescription(descrption +" " +"Boards  is Already exists");
			return response;
		}
		
	
			}

	
	
	@GetMapping("/medium/education-board/{educationBoardId}")
	public MediumListResponse getAllmediums(@PathVariable int educationBoardId) {
	      MediumListResponse response = new MediumListResponse();
		response.setMediums(educationBoardService.findeducationBoardMediums(educationBoardId));
		return response;
	}
	
	//list
	@GetMapping("/education-board")
	public List<EducationBoardJson> getAllEductionBoardDetails(){
		return educationBoardService.findAll().stream().map(educationBoard -> new EducationBoardJson(educationBoard)).collect(Collectors.toList());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/educationBoard/{educationBoardId}")
	public ResponseEntity updateEducationBoard(@RequestBody EducationBoardJson boardRequestEntity) {
		if (boardRequestEntity.getEducationBoardId() == null) {
			EducationBoardResponse boardResponseEntity = new EducationBoardResponse();
			boardResponseEntity.setStatusCode(404);
			boardResponseEntity.setDescription("UserId Not Found");
			return new ResponseEntity(boardRequestEntity, HttpStatus.CONFLICT);
		}
		Optional<EducationBoard> educationBoardDatas = educationBoardService.findById(boardRequestEntity.getEducationBoardId());
		if (educationBoardDatas != null) {
			EducationBoard educationBoard = new EducationBoard(boardRequestEntity.getEducationBoardId(),boardRequestEntity.getEducationBoardName(),boardRequestEntity);
			EducationBoard boardData = educationBoardService.save(educationBoard);
			if (boardData != null) {
				EducationBoardJson boardReqEntity = new EducationBoardJson(boardData);
				EducationBoardResponse boardResponseEntity = new EducationBoardResponse(boardReqEntity);

				boardResponseEntity.setStatusCode(200);
				boardResponseEntity.setDescription("EducationBoard Updated Successfully");
				return new ResponseEntity(boardResponseEntity, HttpStatus.OK);
			}else {
				EducationBoardResponse boardResponseEntity = new EducationBoardResponse();
				boardResponseEntity.setStatusCode(400);
				boardResponseEntity.setDescription("Unable to Update EducationBoard");
				return new ResponseEntity(boardResponseEntity, HttpStatus.CONFLICT);
			}
		}else {
			EducationBoardResponse boardResponseEntity = new EducationBoardResponse();
			boardResponseEntity.setStatusCode(404);
			boardResponseEntity.setDescription("EducationBoard Not Found");
			return new ResponseEntity(boardResponseEntity, HttpStatus.CONFLICT);
	}
		}
	
	@GetMapping("/educationBoard/{educationBoardId}")
	private EducationBoardResponse getEducationBoardById(@PathVariable Integer educationBoardId) {
		EducationBoard educationBoardFromDb=educationBoardService.findByEducationBoardId(educationBoardId);
		EducationBoardResponse response =new EducationBoardResponse();
		if(educationBoardFromDb != null) {
			response.setEducationBoardId(educationBoardFromDb.getEducationBoardId());
			response.setEducationBoardName(educationBoardFromDb.getEducationBoardName());
		}else{
			response.setStatusCode(409);
			response.setDescription("No EducationBoard Found For the Id");
		}
	return response;
}
	
	@DeleteMapping("/educationBoard/{educationBoardId}")
	public EducationBoardResponse deleteEducationBoardById(@PathVariable Integer educationBoardId)
	{
		EducationBoardResponse response = new EducationBoardResponse();

		EducationBoard educationBoardFromDb=educationBoardService.findByEducationBoardId(educationBoardId);
		if(educationBoardFromDb != null)
		{
			educationBoardService.deleteMedium(educationBoardFromDb);
			response.setDescription("deleted Successfully");
			response.setStatusCode(200);
		}else {
			response.setStatusCode(409);
			response.setDescription("No Such Id Found");
		}
		return response;

	}

}
