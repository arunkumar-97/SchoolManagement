package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolMediumRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolMediumResponse;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;

public interface SchoolMediumService {

	Response createSchoolMedium(SchoolMediumRequest schoolMediumRequest);

	void save(SchoolMedium sm);

	List<SchoolMedium> findBySchool(School schoolFromDb);

	SchoolMedium findBySchoolMediumId(Integer schoolMediumId);

//	List<SchoolMediumResponse> findBySchool(School schoolFromDb);

}
