package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesResponse;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;

public interface SchoolClassesRepository extends JpaRepository<SchoolClasses, Integer>{

	List<SchoolClasses> findBySchool(School schoolFromDb);

//	List<SchoolClasses> findAllByClas_classIdAndSchool_schoolId(Integer classId, Integer schoolId);

//	SchoolClasses findBySchoolClassesId(Integer shoolClassesId);

//	SchoolClasses findSubscriptionClassBySchoolClassesId(Integer schoolClassesId);

	
	SchoolClasses findBySchoolClassesId(Integer schoolClassesId);

	List<SchoolClasses> findAllByClas_classIdAndSchool_schoolIdAndSchoolEducationBoard_schoolEducationBoardIdAndSchoolMedium_schoolMediumId(
			Integer classId, Integer schoolId, Integer schoolEducationBoardId, Integer schoolMediumId);

//	Iterable<SchoolClasses> findBySchoolAndSchoolEducationBoardAndSchoolMedium(SchoolMedium schmedFromDb,
//			SchoolEducationBoard scheduFromDb, SchoolMedium schmedFromDb2);

	Iterable<SchoolClasses> findBySchoolAndSchoolEducationBoardAndSchoolMedium(School schoolFromDb,
			SchoolEducationBoard scheduFromDb, SchoolMedium schmedFromDb2);

//	List<SchoolClasses> findAllByClas_classIdAndSchool_schoolId(Integer classId, Integer schoolId);

//	SchoolClasses findByShoolClassesId(Integer shoolClassesId);

	

}
