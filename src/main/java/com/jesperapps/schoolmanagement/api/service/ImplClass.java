package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import com.jesperapps.schoolmanagement.api.utils.ClassStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.repository.RepositoryClass;

@Service
public class ImplClass implements ServiceClass {
	
	@Autowired
	private RepositoryClass repositoryClass;
	
	
	public void addclass(List<Class> classes)
	{
	repositoryClass.saveAll(classes);
	}

	

	public Iterable<Class> findAll()
	{
		return  repositoryClass.findByClassStatusEquals(ClassStatus.NULL);
	}


	public Class checkclass(String className)
	{
		return this.getClassName(className);
	}
	
	
	public boolean saveClass(Class school)
	{
		try{
			repositoryClass.save(school);
			return true;
			}
		catch(Exception e) 
			{
			return false;
			}
	}
	
	public void deleteClass(Class school) 
	{
		school.setClassStatus(ClassStatus.DELETED);
		this.saveClass(school);
	}


	private Class getClassName(String className) 
	{
		
		return  repositoryClass.findByClassName(className);
	}


	public Class createnewclass(String name,Integer Id) 
	{

		Class newclass = new Class();
		newclass.setClassName(name);
		repositoryClass.save(newclass);
		return newclass;
	}

	public Class fromClassId(int id)
	{
		return repositoryClass.findByClassId(id);
	}



	public Class findById(int classId)
	 {
		return	repositoryClass.findByClassId(classId);
	 }

}