package com.jesperapps.schoolmanagement.api.controller;

import java.util.ArrayList;
import java.util.List;


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
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.MediumRequest;
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

	@PostMapping("/mediums")
	private MediumResponse createMediums(@RequestBody List<MediumRequest> mediumRequestList) {
		MediumResponse response= new MediumResponse();
		List<MediumResponse> clas=new ArrayList<>();
		for(MediumRequest each:mediumRequestList) {
			Medium mediums=new Medium(each);
			List <Medium>  mediumsList = mediumService.findAllByMediumLanguage(mediums.getMediumLanguage());
		
			if(mediumsList.isEmpty() == false)
			{
				MediumResponse res=new MediumResponse(mediumsList.get(0));	
//				System.out.println("RESPONSE" +res.getSchoolEducationBoard());
				   clas.add(res);
			}else {
				mediumService.save(mediums);
			}
			
		
		}
		if(clas.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("Successfully Created");
			return response;
		}else {
			String descrption = null;
			 for(MediumResponse cl :  clas)
			 {     
				 if(descrption != null) 
				 {
					 descrption = descrption +","+ cl.getMediumLanguage();
				 }else {
					 descrption =  cl.getMediumLanguage();
				 }
				 
			 }
			response.setStatusCode(409);
			response.setDescription(descrption +" " +"Mediums Already exists");
			return response;
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/medium/{mediumId}")
	public ResponseEntity updateEducationBoard(@RequestBody MediumRequest mediumRequestList) {
		if (mediumRequestList.getMediumId() == null) {
			MediumResponse mediumResponseEntity = new MediumResponse();
			mediumResponseEntity.setStatusCode(404);
			mediumResponseEntity.setDescription("UserId Not Found");
			return new ResponseEntity(mediumRequestList, HttpStatus.CONFLICT);
		}
		Medium mediumDatas = mediumService.findById(mediumRequestList.getMediumId());
		if (mediumDatas != null) {
			Medium medium = new Medium(mediumRequestList.getMediumId(),mediumRequestList.getMediumLanguage(),mediumRequestList);
			Medium mediumData = mediumService.save(medium);
			if (mediumData != null) {
				MediumRequest mediumReqEntity = new MediumRequest(mediumData);
				MediumResponse mediumResponseEntity = new MediumResponse(mediumReqEntity);

				mediumResponseEntity.setStatusCode(200);
				mediumResponseEntity.setDescription("Medium Updated Successfully");
				return new ResponseEntity(mediumResponseEntity, HttpStatus.OK);
			}else {
				MediumResponse mediumResponseEntity = new MediumResponse();
				mediumResponseEntity.setStatusCode(400);
				mediumResponseEntity.setDescription("Unable to Update Medium");
				return new ResponseEntity(mediumResponseEntity, HttpStatus.CONFLICT);
			}
		}else {
			MediumResponse mediumResponseEntity = new MediumResponse();
			mediumResponseEntity.setStatusCode(404);
			mediumResponseEntity.setDescription("Medium Not Found");
			return new ResponseEntity(mediumResponseEntity, HttpStatus.CONFLICT);
	}
		}
	
	

	@GetMapping("/medium/{mediumId}")
		private MediumResponse getMediumById(@PathVariable Integer mediumId) {
			Medium mediumFromDb=mediumService.findById(mediumId);
			MediumResponse response =new MediumResponse();
			if(mediumFromDb != null) {
				response.setMediumId(mediumFromDb.getMediumId());
				response.setMediumLanguage(mediumFromDb.getMediumLanguage());

			}else{
				response.setStatusCode(409);
				response.setDescription("No Medium Found For the Id");
			}
		return response;
	}
	
	@DeleteMapping("/medium/{mediumId}")
	public MediumResponse deleteMediumById(@PathVariable Integer mediumId)
	{
		MediumResponse response = new MediumResponse();

		Medium mediumFromDb=mediumService.findById(mediumId);
		if(mediumFromDb != null)
		{
			mediumService.deleteMedium(mediumFromDb);
			response.setDescription("deleted Successfully");
			response.setStatusCode(200);
		}else {
			response.setStatusCode(409);
			response.setDescription("No Such Id Found");
		}
		return response;

	}

}
