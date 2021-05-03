package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;

public interface SchoolMediumRepository extends JpaRepository<SchoolMedium, Integer>{

	List<SchoolMedium> findAllByMedium_mediumIdAndSchoolMedium_schoolId(int mediumId, Integer schoolId);

	List<SchoolMedium> findBySchoolMedium(School schoolFromDb);

	SchoolMedium findBySchoolMediumId(Integer schoolMediumId);

}
