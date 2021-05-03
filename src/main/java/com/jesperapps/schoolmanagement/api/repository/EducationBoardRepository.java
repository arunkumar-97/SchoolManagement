package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.School;

public interface EducationBoardRepository extends JpaRepository<EducationBoard, Integer>{
	
	
	public EducationBoard findEducationBoardByeducationBoardId(Integer educationBoardId);

	public EducationBoard findByEducationBoardName(String educationBoardName);

	public List<EducationBoard> findAllByEducationBoardName(String educationBoardName);

	public EducationBoard findByEducationBoardId(Integer educationBoardId);

//	public Iterable<EducationBoard> findBySchool(School schoolFromDb);

}
