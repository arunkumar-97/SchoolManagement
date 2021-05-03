package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassSubjectsRequest;
import com.jesperapps.schoolmanagement.api.message.ClassSubjectsResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;

public interface ClassSubjectsService {

	Response createSubjectsToClass(ClassSubjectsRequest classSubjectsRequest);

	ClassSubjects findClassSubjectsFromId(Integer classSubjectsId);

	Iterable<ClassSubjects> findBySchoolClasses(SchoolClasses schoolFromDb);

	ClassSubjects save(ClassSubjects users);

	ClassSubjectsResponse createMultipleSubjectsToClass(List<ClassSubjectsRequest> classSubjectsRequest);

//	ClassSubjects findByClassSubjectsId(Integer classSubjectsId);

}
