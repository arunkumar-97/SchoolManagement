package com.jesperapps.schoolmanagement.api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Class;

public interface RepositoryClass extends JpaRepository<Class, Integer> 
{

	void save(List<com.jesperapps.schoolmanagement.api.service.ServiceClass> classes);

	Class findByClassId(int classid);

	Class findByClassName(String className);

	Iterable<Class> findByClassStatusEquals(String status);

}


