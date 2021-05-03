package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SchoolEducationBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer schoolEducationBoardId;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="schoolId")
	private School school;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="educationBoardId")
	private EducationBoard educationBoards;
	
	
	

	public SchoolEducationBoard(EducationBoard educationBoard) {
		// TODO Auto-generated constructor stub
		this.educationBoards=educationBoard;
	}

	public SchoolEducationBoard() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSchoolEducationBoardId() {
		return schoolEducationBoardId;
	}

	public void setSchoolEducationBoardId(Integer schoolEducationBoardId) {
		this.schoolEducationBoardId = schoolEducationBoardId;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public EducationBoard getEducationBoards() {
		return educationBoards;
	}

	public void setEducationBoards(EducationBoard educationBoards) {
		this.educationBoards = educationBoards;
	}

	
	
	

}
