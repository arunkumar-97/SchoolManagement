package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.message.RequestClass;
import com.jesperapps.schoolmanagement.api.message.ResponseClass;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.service.ImplClass;

@RestController
public class ControllerClass {
	
	
	@Autowired
	private ImplClass schoolmanagementservice; 
	
	
	
	
	
	@PostMapping("/addclass")
	public List<Class> addclass(@RequestBody List<Class> classes){
		schoolmanagementservice.addclass(classes);
		return classes;
	}
	
	
	
	
	@GetMapping("/showAll")
	public Iterable<Class> listAllclasses(){
		return schoolmanagementservice.findAll();
	}
	
	@PostMapping("/class")
	public ResponseClass checkclass(@RequestBody RequestClass schoolManagementRequest ) {
		Class classOfName=schoolmanagementservice.checkclass( schoolManagementRequest.getClassName());
//		System.out.println("ClassOfName:"+ classOfName);
		ResponseClass response= new ResponseClass(409,"classexists");
		if(classOfName != null) {
			return response;
		}else{
			Class newClass =schoolmanagementservice.createnewclass(schoolManagementRequest.getClassName(), schoolManagementRequest.getClassId());
			response.setStatuscode(200);
			response.setDescription("new class created");
			return response;
		}
	}
	
	@PutMapping("/update-class")
	public ResponseClass updateClassName(@RequestBody RequestClass schoolManagementRequest) {
		ResponseClass response = new ResponseClass(400,"Bad request");
		if(schoolManagementRequest.getClassId() != null) {
			Class classFromDatabase = schoolmanagementservice.fromClassId(schoolManagementRequest.getClassId());
			if(classFromDatabase != null) {
				classFromDatabase.setClassName(schoolManagementRequest.getClassName());
				schoolmanagementservice.saveClass(classFromDatabase) ;
					response.setDescription("Success");
					response.setStatuscode(200);
				
			}
		}
		return response;
	}
	
	@DeleteMapping("/deleteClass/{classId}")
	public ResponseClass deleteClassById(@PathVariable int classId) {
		ResponseClass response = new ResponseClass(400, "bad request");
		Class classFromId = schoolmanagementservice.fromClassId(classId);
		if(classFromId != null) {
			schoolmanagementservice.deleteClass(classFromId);
			response.setDescription("");
			response.setStatuscode(200);
		}
		return response;
		
	}
	
	
	

}
	
	


