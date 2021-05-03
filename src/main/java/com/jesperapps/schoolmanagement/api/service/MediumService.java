package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;

public interface MediumService {
	
	public Medium findMediumFromId(Integer mediumId);
	
	public void saveMedium(Medium medium);
	
	public List<ClassResponse> findMediumClasses(Integer mediumId);

	public List<Medium> findAll();

	public Medium findById(Integer mediumId);

	public List<Medium> findAllByMediumLanguage(String mediumLanguage);

	public Medium save(Medium mediums);

	public void deleteMedium(Medium mediumFromDb);

//	public Iterable<Medium> findBySchool(School schoolFromDb);



//	public MediumResponse listAll();

}
