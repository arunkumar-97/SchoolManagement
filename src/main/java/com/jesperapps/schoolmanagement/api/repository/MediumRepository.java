package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.model.Medium;

public interface MediumRepository extends JpaRepository<Medium, Integer>{

	public Medium findMediumByMediumId(Integer mediumId);

	
}
