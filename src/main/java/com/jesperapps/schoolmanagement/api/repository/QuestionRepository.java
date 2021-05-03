package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Year;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	Question findByQuestionId(Integer questionId);

	

//	List<Question> findBySubjectAndYearAndClas(Subject subject, Year year, Class clas);



//	List<Question> findBySubject(Subject subjectFromDb);



//	List<Question> findBySchoolClassesAndClas(Year year, SchoolClasses schoolClasses);



//	List<Question> findByYearAndSchoolClasses(Year year, SchoolClasses schoolClasses);



	List<Question> findByYearAndClassSubjects(Year year, ClassSubjects classSubjects);



	
}
