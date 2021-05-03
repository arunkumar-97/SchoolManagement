package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import java.util.Optional;

import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.School;

public interface EducationBoardService {
	
	public EducationBoard findEducationBoardFromId(Integer educationBoardId);
	
	public void saveEducationBoard(EducationBoard educationBoard);

	List<MediumResponse> findeducationBoardMediums(Integer educationBoardId);

	List<EducationBoard> findAll();

	public Optional<EducationBoard> findById(int educationBoardId);

	public EducationBoard checkEducationBoardName(String educationBoardName);

	public EducationBoard createnewEducationBoard(Integer educationBoardId, String educationBoardName);

	public EducationBoard save(EducationBoard boards);

	public List<EducationBoard> findAllByEducationBoardName(String educationBoardName);

	
	void deleteMedium(EducationBoard educationBoardFromDb);

//	public void deleteMedium(Optional<EducationBoard> educationBoardFromDb);

	public EducationBoard findByEducationBoardId(Integer educationBoardId);

//	public Iterable<EducationBoard> findBySchool(School schoolFromDb);
}
