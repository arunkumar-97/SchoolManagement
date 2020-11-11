package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.OneMarkAnswers;

public interface OneMarkAnswersRepository extends JpaRepository<OneMarkAnswers, Integer> {

	OneMarkAnswers findByOptionId(Integer optionId);

	

}
