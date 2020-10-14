package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.message.MediumResponse;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.repository.EducationBoardRepository;

@Service
public class EducationBoardImplementationService implements EducationBoardService{
	
	@Autowired
	private EducationBoardRepository educationBoardRepository;

	@Override
	public EducationBoard findEducationBoardFromId(Integer educationBoardId) {
		return educationBoardRepository.findEducationBoardByeducationBoardId(educationBoardId);
	}

	@Override
	public void saveEducationBoard(EducationBoard educationBoard) {
		educationBoardRepository.save(educationBoard);
		
	}
	
	@Override
	public List<MediumResponse> findeducationBoardMediums(Integer educationBoardId) {
		// TODO Auto-generated method stub
		List<MediumResponse> response = new ArrayList<>();
		EducationBoard educationBoard = this.findEducationBoardFromId(educationBoardId);
		if(educationBoard != null) {
			for(Medium medium:educationBoard.getMedium()) {
				response.add(new MediumResponse(medium));
			}
		}
		return response;
	}

	@Override
	public List<EducationBoard> findAll() {
		// TODO Auto-generated method stub
		return educationBoardRepository.findAll();
	}

}
