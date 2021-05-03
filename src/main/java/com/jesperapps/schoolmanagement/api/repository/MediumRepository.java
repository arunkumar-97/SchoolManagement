package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;

public interface MediumRepository extends JpaRepository<Medium, Integer>{

	public Medium findMediumByMediumId(Integer mediumId);

	public List<Medium> findAllByMediumLanguage(String mediumLanguage);

//	public Iterable<Medium> findBySchool(School schoolFromDb);

	
}
