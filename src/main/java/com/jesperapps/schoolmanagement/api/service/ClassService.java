package com.jesperapps.schoolmanagement.api.service;


import com.jesperapps.schoolmanagement.api.model.Class;

//import com.jesperapps.schoolmanagement.api.model.SchoolManagement;

public interface ClassService {

	Class checkclass(String className);

	Class createnewclass(String className, Integer classId,String status);

	Class fromClassId(Integer classId);

	boolean saveClass(Class classFromDatabase);

	Iterable<Class> findAll();

	Class findById(int classId);

	void deleteClass(Class classFromId);

 
	
}
