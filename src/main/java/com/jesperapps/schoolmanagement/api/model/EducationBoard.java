package com.jesperapps.schoolmanagement.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jesperapps.schoolmanagement.api.model.Medium;

@Entity
public class EducationBoard {
	
	@Id
	private Integer educationBoardId;
	private String educationBoardName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Medium> medium;
	
	public List<Medium> getMedium() {
		return medium;
	}

	public void setMedium(List<Medium> medium) {
		this.medium = medium;
	}

	
	public Integer getEducationBoardId() {
		return educationBoardId;
	}
	public void setEducationBoardId(Integer educationBoardId) {
		this.educationBoardId = educationBoardId;
	}
	public String getEducationBoardName() {
		return educationBoardName;
	}
	public void setEducationBoardName(String educationBoardName) {
		this.educationBoardName = educationBoardName;
	}
	public EducationBoard() {
		
	}
	
	
	public EducationBoard(int id, String stateboard) {
		this.educationBoardId=id;
		this.educationBoardName=stateboard;
	}

}
