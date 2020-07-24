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
	private ImplClass implClassservice; 
	
	
	
	@PostMapping("/class")
	public ResponseClass checkclass(@RequestBody List<RequestClass> requestClass ) 
	{
		ResponseClass response1= new ResponseClass(200,"ClassIsCreated");
		
		for(RequestClass eachclass:requestClass) 
		{
		Class classOfName=implClassservice.checkclass( eachclass.getClassName());
		ResponseClass response= new ResponseClass(409,"classexists");
		
				if(classOfName != null) 
					{
						return response;
					}
				else
					{
						@SuppressWarnings("unused")
						Class newClass =implClassservice.createnewclass(eachclass.getClassName(),eachclass.getClassId());
					}
		}
		
		return response1;
	}
	
	
	
	@PutMapping("/class")
	public ResponseClass updateClassName(@RequestBody RequestClass requestClass)
	{
		ResponseClass response = new ResponseClass(409,"No such Id found");
		if(requestClass.getClassId() != null) 
			{
				Class classFromDatabase = implClassservice.fromClassId(requestClass.getClassId());
				if(classFromDatabase != null) 
					{
					
					classFromDatabase.setClassName(requestClass.getClassName());
					implClassservice.saveClass(classFromDatabase) ;
					response.setDescription("Successfully updated");
					response.setStatuscode(200);
				
					}
			}
		
		return response;
	}
	
	
	
	
	@GetMapping("/class")
	public Iterable<Class> listAllclasses()
	{
		return implClassservice.findAll();
	}
	
	

	@GetMapping("/class/{classId}")
	public Class viewClass(@PathVariable int classId)
	{
		Class cls = implClassservice.findById(classId);

		if(cls != null)
		{
			return(cls) ;
		}else
		{
			cls = new Class();
			
		}
		return cls;
		
	}
	
	
	@DeleteMapping("/Class/{classId}")
	public ResponseClass deleteClassById(@PathVariable int classId)
	{
		ResponseClass response = new ResponseClass(409, "No such Id found");
		
		Class classFromId = implClassservice.fromClassId(classId);
			if(classFromId != null)
				{
					implClassservice.deleteClass(classFromId);
					response.setDescription("deleted Successfully");
					response.setStatuscode(200);
				}
		return response;
		
	}
	
	
	

}
	
	


