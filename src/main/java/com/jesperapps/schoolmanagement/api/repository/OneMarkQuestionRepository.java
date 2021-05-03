package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.OneMarkQuestion;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Year;

public interface OneMarkQuestionRepository extends JpaRepository<OneMarkQuestion, Integer>{

//	List<OneMarkQuestion> findBySubjectsAndYearsAndClasss(Subject subjectFromDb, Year yearFromDb, Class classFromDb);

	

//	List<OneMarkQuestion> findBySchoolClassesAndYears(SchoolClasses schoolClasses, Year yearFromDb);

	List<OneMarkQuestion> findByClassSubjectsAndYears(ClassSubjects classFromDb, Year yearFromDb);

}
