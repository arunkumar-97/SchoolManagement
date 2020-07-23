package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.repository.RepositoryClass;

@Service
public class ImplClass implements ServiceClass {
	
	@Autowired
	private RepositoryClass schoolmanagementrepository;
	
	
	public void addclass(List<Class> classes) {
		schoolmanagementrepository.saveAll(classes);
	}

	

	public Iterable<Class> findAll() {
		
		return  schoolmanagementrepository.findAll();
	}


	public Class checkclass(String className) {
		return this.getClassName(className);
	}
	
	
	public boolean saveClass(Class school) {
		try{
			schoolmanagementrepository.save(school);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void deleteClass(Class school) {
		schoolmanagementrepository.delete(school);
	}


	private Class getClassName(String className) {
		
		return  schoolmanagementrepository.findByClassName(className);
	}


	public Class createnewclass(String name,Integer Id) {
		System.out.println(name+","+Id);
		Class newclass = new Class();
		newclass.setClassName(name);
//		newclass.setClassId(Id);
		schoolmanagementrepository.save(newclass);
		return newclass;
	}

	public Class fromClassId(int id) {
		return schoolmanagementrepository.findByClassId(id);
	}



	public void findById(int classId) {
		schoolmanagementrepository.findByClassId(classId);
		
	}

	

	
	
}