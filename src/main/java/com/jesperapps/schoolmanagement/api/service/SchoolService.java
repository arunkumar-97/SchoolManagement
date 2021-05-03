package com.jesperapps.schoolmanagement.api.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SchoolRequest;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;

public interface SchoolService {

	School createnewSchool(SchoolRequest schoolRequest);

	School checkSchool(String schoolShortName);

	School findBySchoolId(Integer integer);

	Iterable<School> findAll();

	ResponseEntity addSchool(SchoolRequest scRequest);

	void deleteSchool(School schoolFromDb);

//	Iterable<EducationBoard> findBySchool(SchoolEducationBoard schoolFromDb);

	



}
