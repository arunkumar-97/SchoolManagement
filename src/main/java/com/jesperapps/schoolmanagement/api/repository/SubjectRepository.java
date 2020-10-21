package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	Subject findBySubjectName(String subjectName);

	Subject findBySubjectId(Integer subjectId);
	
	Subject findBySubjectNameAndStatusNot(String subjectName, String status);

	List<Subject> findByStatusIsNot(String dELETED);

}
