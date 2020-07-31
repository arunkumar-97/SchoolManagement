  package com.jesperapps.schoolmanagement.api.repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jesperapps.schoolmanagement.api.message.ClassListResponse;
import com.jesperapps.schoolmanagement.api.model.Class;

public interface ClassRepository extends JpaRepository<Class, Integer> 
{

	void save(List<com.jesperapps.schoolmanagement.api.service.ClassService> classes);

	Class findByClassId(int classid);

	Class findByClassName(String className);
	
	List<Class> findByStatusIsNot(String status);

}


