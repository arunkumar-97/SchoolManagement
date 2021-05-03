  package com.jesperapps.schoolmanagement.api.repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.message.EducationBoardJson;
import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;

public interface ClassRepository extends JpaRepository<Class, Integer> 
{

	void save(List<com.jesperapps.schoolmanagement.api.service.ClassService> classes);

	Class findByClassId(int classid);

	Class findByClassName(String className);
	
	Class findByClassNameAndStatusNot(String className, String status);
	
	List<Class> findByStatusIsNot(String status);

	Class findByClassNameAndEducationBoardAndMediumAndStatusNot(String className, EducationBoard educationBoard,
			Medium medium, String dELETED);

	

}


