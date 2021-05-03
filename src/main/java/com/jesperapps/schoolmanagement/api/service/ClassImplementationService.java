package com.jesperapps.schoolmanagement.api.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.jesperapps.schoolmanagement.api.utils.StatusClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.EducationBoardJson;
import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.repository.ClassRepository;

@Service
public class ClassImplementationService implements ClassService {
	
	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private MediumService mediumService;
	@Autowired
	private EducationBoardService educationBoardService;
	
	
	@Autowired
	private SchoolService schoolService;
	
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
		
		return classRepository.findByClassNameAndStatusNot(className, StatusClass.DELETED);
	}



	@Override
	public Class fromClassId(Integer classId) {
		
		return  classRepository.findByClassId(classId);
	}



//	@Override
//	public Class createnewclass(String className, Integer classId, String status, i,String educationBoard) {
//		Class newclass = new Class();
//		newclass.setClassName(className);
//		newclass.setClassId(classId);
//		newclass.setStatus(status);
//		Medium requestMedium = mediumService.findMediumFromId(Integer.parseInt(medium));
//		newclass.setMedium(requestMedium);
//		EducationBoard requesteB=educationBoardService.findEducationBoardFromId(Integer.parseInt(educationBoard));
//		newclass.setEducationBoard(requesteB);
//		requestMedium.addClass(newclass);
////		List<Subject> classSubjects=newclass.getSubject();
////		if(classSubjects==null) {
////			classSubjects=new ArrayList<>();
////		}
////		
////		newclass.setSubject(classSubjects);
////		classSubjects.add(newSubject);
//		 classRepository.save(newclass);
//		return(newclass);
//	}



	@Override
	public Class checkclass(String className, EducationBoard educationBoard, Medium medium) {
		// TODO Auto-generated method stub
		return classRepository.findByClassNameAndEducationBoardAndMediumAndStatusNot(className, educationBoard,medium,StatusClass.DELETED);
	}



	@Override
	public Class createnewclass(String className, Integer classId, String status, int mediumId,
			Integer educationBoardId) {
		Class newclass=new Class();
		
		newclass.setClassName(className);
		newclass.setClassId(classId);
		newclass.setStatus(status);
		Medium requestMedium = mediumService.findMediumFromId(mediumId);
		newclass.setMedium(requestMedium);
		EducationBoard requesteB=educationBoardService.findEducationBoardFromId(educationBoardId);
		newclass.setEducationBoard(requesteB);
//		School requestSchool=schoolService.findBySchoolId(integer);
		requestMedium.addClass(newclass);
		 classRepository.save(newclass);
			return(newclass);
	}










}