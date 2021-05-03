package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<EducationBoard> findById(int educationBoardId) {
		// TODO Auto-generated method stub
		return educationBoardRepository.findById(educationBoardId);
	}

	@Override
	public EducationBoard checkEducationBoardName(String educationBoardName) {
		// TODO Auto-generated method stub
		return educationBoardRepository.findByEducationBoardName(educationBoardName);
	}

	@Override
	public EducationBoard createnewEducationBoard(Integer educationBoardId, String educationBoardName) {
		// TODO Auto-generated method stub
		EducationBoard board=new EducationBoard();
		board.setEducationBoardId(educationBoardId);
		board.setEducationBoardName(educationBoardName);
		educationBoardRepository.save(board);
		return board;
	}

	@Override
	public EducationBoard save(EducationBoard boards) {
		return educationBoardRepository.save(boards);
	}

	@Override
	public List<EducationBoard> findAllByEducationBoardName(String educationBoardName) {
		// TODO Auto-generated method stub
		return educationBoardRepository.findAllByEducationBoardName(educationBoardName);
	}

	@Override
	public void deleteMedium(EducationBoard educationBoardFromDb) {
		// TODO Auto-generated method stub
		educationBoardRepository.delete(educationBoardFromDb);
	}

	

	@Override
	public EducationBoard findByEducationBoardId(Integer educationBoardId) {
		// TODO Auto-generated method stub
		return educationBoardRepository.findByEducationBoardId(educationBoardId);
	}

//	@Override
//	public Iterable<EducationBoard> findBySchool(School schoolFromDb) {
//		// TODO Auto-generated method stub
//		return this.educationBoardRepository.findBySchool(schoolFromDb);
//	}

}
