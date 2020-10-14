package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;

public interface EducationBoardService {
	
	public EducationBoard findEducationBoardFromId(Integer educationBoardId);
	
	public void saveEducationBoard(EducationBoard educationBoard);

	List<MediumResponse> findeducationBoardMediums(Integer educationBoardId);

	List<EducationBoard> findAll();
}
