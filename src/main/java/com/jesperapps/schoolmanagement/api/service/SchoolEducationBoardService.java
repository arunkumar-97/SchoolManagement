package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.Response;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardRequest;
import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardResponse;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;

public interface SchoolEducationBoardService {

	Response createSchoolEducationBoard(SchoolEducationBoardRequest schoolEducationBoardRequest);

	void save(SchoolEducationBoard se);

//	SchoolEducationBoard findBySchoolId(Integer schoolId);

	List<SchoolEducationBoard> findBySchool(School schoolFromDb);

	SchoolEducationBoard findBySchoolEducationBoardId(Integer schoolEducationBoardId);

}
