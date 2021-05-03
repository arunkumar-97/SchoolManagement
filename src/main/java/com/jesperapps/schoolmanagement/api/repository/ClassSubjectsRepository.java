package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;

public interface ClassSubjectsRepository extends JpaRepository<ClassSubjects, Integer> {

	List<ClassSubjects> findAllBySchoolClasses_schoolClassesIdAndSubject_subjectId(Integer schoolClassesId,
			Integer subjectId);

	ClassSubjects findByClassSubjectsId(Integer classSubjectsId);

	Iterable<ClassSubjects> findBySchoolClasses(SchoolClasses schoolFromDb);

	

}
