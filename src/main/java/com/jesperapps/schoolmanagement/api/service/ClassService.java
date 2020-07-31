package com.jesperapps.schoolmanagement.api.service;


import java.util.List;
import com.jesperapps.schoolmanagement.api.message.ClassListResponse;
import com.jesperapps.schoolmanagement.api.model.Class;



public interface ClassService {

	Class checkclass(String className);

	Class createnewclass(String className, Integer classId,String status);

	Class fromClassId(Integer classId);

	boolean saveClass(Class classFromDatabase);

	List<Class> findAll();

	Class findById(int classId);

	void deleteClass(Class classFromId);

 
	
}
