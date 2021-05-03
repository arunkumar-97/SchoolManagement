package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesResponse;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;

public interface SchoolClassesService {

//	Response createSchoolClass(List<SchoolClassesRequest> schoolClassesRequest);

	List<SchoolClasses> findBySchool(School schoolFromDb);

	Response createSchoolClass(SchoolClassesRequest schoolClassesRequest);

	SchoolClassesResponse createSchoolClasses(List<SchoolClassesRequest> schoolClassesRequest);

	SchoolClasses findSchoolClassesFromId(Integer schoolClassesId);

	SchoolClasses findByShoolClassesId(Integer schoolClassesId);

	Iterable<SchoolClasses> findBySchoolAndSchoolEducationBoardAndSchoolMedium(School schoolFromDb,
			SchoolEducationBoard scheduFromDb, SchoolMedium schmedFromDb2);

//	SchoolClasses findByClassSubjectsId(Integer classSubjectsId);

//	SchoolClasses findBySubscriptionClassId(Integer shoolClassesId);

//	SchoolClasses findSchoolClassesFromId(Integer schoolClassesId);

	

}
