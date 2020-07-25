package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.model.Subject;

public interface SubjectService {

	Subject checksubject(String subjectName);

	Subject createnewSubject(String subjectName, Integer subjectId, String status);

	Subject fromSubjectId(Integer subjectId);

	boolean savesubject(Subject subjectFromDatabase);

}
