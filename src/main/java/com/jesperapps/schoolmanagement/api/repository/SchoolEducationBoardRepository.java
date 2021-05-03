package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.message.SchoolEducationBoardResponse;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolEducationBoard;

public interface SchoolEducationBoardRepository extends JpaRepository<SchoolEducationBoard, Integer> {

	List<SchoolEducationBoard> findAllByEducationBoards_educationBoardIdAndSchool_schoolId(Integer educationBoardId,
			Integer schoolId);

//	SchoolEducationBoard findBySchoolId(Integer schoolId);

	List<SchoolEducationBoard> findBySchool(School schoolFromDb);

	SchoolEducationBoard findBySchoolEducationBoardId(Integer schoolEducationBoardId);

}
