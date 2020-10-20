package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.api.model.Answers;

public interface AnswerRepository extends CrudRepository<Answers, Integer>{
	
	Answers findByAnswerId(Integer answerId);

}
