package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Subject;

public interface SubjectService {

	Subject checksubject(String subjectName);

	Subject createnewSubject(String subjectName, Integer subjectId, String status,Integer classId);

	Subject fromSubjectId(Integer subjectId);

	boolean savesubject(Subject subjectFromDatabase);

	Subject findById(int subjectId);

	void deleteSubject(Subject subjectFromId);

	List<Subject> findAll();


}
