package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.model.Medium;

public interface MediumService {
	
	public Medium findMediumFromId(Integer mediumId);
	
	public void saveMedium(Medium medium);
	
	public List<ClassResponse> findMediumClasses(Integer mediumId);

}
