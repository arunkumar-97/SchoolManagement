package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.api.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	Question findByQuestionId(Integer questionId);

}
