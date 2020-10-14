package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;

public interface EducationBoardRepository extends JpaRepository<EducationBoard, Integer>{
	public EducationBoard findEducationBoardByeducationBoardId(Integer educationBoardId);

}
