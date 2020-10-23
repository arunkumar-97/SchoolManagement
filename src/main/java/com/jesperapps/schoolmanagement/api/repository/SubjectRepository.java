package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Class;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	Subject findBySubjectName(String subjectName);

	Subject findBySubjectId(Integer subjectId);
	
	Subject findBySubjectNameAndStatusNotAndClasses(String subjectName, String status,Class clas);

	List<Subject> findByStatusIsNot(String dELETED);

}
