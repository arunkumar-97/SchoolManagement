package com.jesperapps.schoolmanagement.api.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jesperapps.schoolmanagement.api.message.ClassRequest;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.service.ClassService;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;


@RestController
public class ClassController {
	
	
	@Autowired
	private ClassService classService; 
	
	
	
	@PostMapping("/class")
	public ClassResponse checkclass(@RequestBody ClassRequest classRequest ) 
	{
		ClassResponse response1= new ClassResponse(200,"ClassIsCreated");		
//		for(ClassRequest eachclass:classRequest) 
//		{
		Class classOfName=classService.checkclass( classRequest.getClassName());
		ClassResponse response= new ClassResponse(409,"classexists");
		
				if(classOfName != null) 
					{
						return response;
					}
				else
					{
						@SuppressWarnings("unused")
						Class newClass =classService.createnewclass(classRequest.getClassName(),classRequest.getClassId(),StatusClass.getStatus(classRequest.getStatus()));
					}
		
		
		return response1;
	}
	
	
	
	@PutMapping("/class")
	public ClassResponse updateClassName(@RequestBody ClassRequest classRequest)
	{
		ClassResponse response = new ClassResponse(409,"No such Id found");
		if(classRequest.getClassId() != null) 
			{
				Class classFromDatabase = classService.fromClassId(classRequest.getClassId());
				if(classFromDatabase != null) 
					{
					
					classFromDatabase.setClassName(classRequest.getClassName());
			
					classService.saveClass(classFromDatabase) ;
					response.setDescription("Successfully updated");
					response.setStatuscode(200);
				
					}
			}
		
		return response;
	}
	
	
	
	
	@GetMapping("/class")
	public Iterable<Class>  listAllclasses()
	{
		
		return classService.findAll();
	}
	
//	@GetMapping("/classs1")
//	public Iterable<class> 

	@GetMapping("/class/{classId}")
	public Class viewClass(@PathVariable int classId)
	{
		Class cls = classService.findById(classId);
		
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
	public ClassResponse deleteClassById(@PathVariable int classId)
	{
		ClassResponse response = new ClassResponse(409, "No such Id found");
		
		Class classFromId = classService.fromClassId(classId);
			if(classFromId != null)
				{
					classService.deleteClass(classFromId);
					response.setDescription("deleted Successfully");
					response.setStatuscode(200);
				}
		return response;
		
	}
	
	
	

}
	
	


