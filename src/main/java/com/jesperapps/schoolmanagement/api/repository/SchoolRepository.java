package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;

public interface SchoolRepository extends JpaRepository<School, Integer> {

	

//	School findBySchoolShortName(String schoolShortName, String dELETED);

	School findBySchoolShortNameAndStatusNot(String schoolShortName, String dELETED);

	School findBySchoolId(Integer integer);

//	Iterable<EducationBoard> findBySchool(SchoolEducationBoard schoolFromDb);

	

	

}
