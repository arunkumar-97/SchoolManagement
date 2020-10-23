package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Year;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	Question findByQuestionId(Integer questionId);

	

	List<Question> findBySubjectAndYearAndClas(Subject subject, Year year, Class clas);



	List<Question> findBySubject(Subject subjectFromDb);
}
