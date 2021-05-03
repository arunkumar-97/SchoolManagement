package com.jesperapps.schoolmanagement.api.service;


import java.util.List;

import com.jesperapps.schoolmanagement.api.message.EducationBoardJson;
import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;



public interface ClassService {

	Class checkclass(String className);


	Class fromClassId(Integer classId);

	boolean saveClass(Class classFromDatabase);

	List<Class> findAll();

	Class findById(int classId);

	void deleteClass(Class classFromId);


//	Class createnewclass(String className, Integer classId, String status, int i,String educationBoard);


//	Class checkclass(String className, EducationBoardJson educationBoard, MediumResponse medium);


	Class checkclass(String className, EducationBoard educationBoard, Medium medium);


//	Class createnewclass(String className, Integer classId, String status, int mediumId, Integer educationBoardId, Integer integer);


	


//	Class createnewclass(String className, Integer classId, String status, int mediumId, Integer educationBoardId,
//			List<School> integer);

//
//	Class createnewclass(String className, Integer classId, String status, int mediumId, Integer educationBoardId,
//			School integer);


	Class createnewclass(String className, Integer classId, String status, int mediumId, Integer educationBoardId);


//	Class fromClassId(Integer classId);

 
	
}
