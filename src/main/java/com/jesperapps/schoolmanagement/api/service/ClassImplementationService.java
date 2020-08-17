package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.repository.ClassRepository;

@Service
public class ClassImplementationService implements ClassService {
	
	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private MediumService mediumService;
	@Autowired
	private EducationBoardService educationBoardService;
	
	public void addclass(List<Class> classes)
	{
	classRepository.saveAll(classes);
	}

	

	public List<Class> findAll()
	{
		
		
	return classRepository.findByStatusIsNot(StatusClass.DELETED);
		
	}
		

	
	
	public boolean saveClass(Class school)
	{
		try{
		classRepository.save(school);
			return true;
			}
		catch(Exception e) 
			{
			return false;
			}
	}
	
	public void deleteClass(Class school) 
	{
		school.setStatus(StatusClass.DELETED);
		this.saveClass(school);
	}


	@SuppressWarnings("unused")
	private Class getClassName(String className) 
	{
		
		return  classRepository.findByClassName(className);
	}





	public Class findById(int classId)
	 {
		return	classRepository.findByClassId(classId);
	 }



	@Override
	public Class checkclass(String className) {
		return classRepository.findByClassName(className);
	}



	@Override
	public Class fromClassId(Integer classId) {
		
		return  classRepository.findByClassId(classId);
	}



	@Override
	public Class createnewclass(String className, Integer classId, String status,String medium,String educationBoard) {
		Class newclass = new Class();
		newclass.setClassName(className);
		newclass.setClassId(classId);
		newclass.setStatus(status);
		Medium requestMedium = mediumService.findMediumFromId(Integer.parseInt(medium));
		newclass.setMedium(requestMedium);
		EducationBoard requesteB=educationBoardService.findEducationBoardFromId(Integer.parseInt(educationBoard));
		newclass.setEducationBoard(requesteB);
		requestMedium.addClass(newclass);
		 classRepository.save(newclass);
		return(newclass);
	}



}