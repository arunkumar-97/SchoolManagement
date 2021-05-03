package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jesperapps.schoolmanagement.api.message.EducationBoardJson;

@Entity
public class EducationBoard extends AbstractAuditingEntity implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer educationBoardId;
		private String educationBoardName;
		
//		@ManyToMany(fetch = FetchType.LAZY, cascade = {  CascadeType.MERGE }, mappedBy = "educationBoard")
//		private Set<School> school;
		
		
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy="educationBoards")
		private Set<SchoolEducationBoard> schoolEducationBoard;
		
		
		@JsonIgnore
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
	
	
	
	
	
//	public Set<School> getSchool() {
//		return school;
//	}
//
//	public void setSchool(Set<School> school) {
//		this.school = school;
//	}

	public Set<SchoolEducationBoard> getSchoolEducationBoard() {
		return schoolEducationBoard;
	}

	public void setSchoolEducationBoard(Set<SchoolEducationBoard> schoolEducationBoard) {
		this.schoolEducationBoard = schoolEducationBoard;
	}

	public EducationBoard() {
		
	}
	
	
	public EducationBoard(int id, String stateboard) {
		this.educationBoardId=id;
		this.educationBoardName=stateboard;
	}

	public EducationBoard(EducationBoard board) {
		// TODO Auto-generated constructor stub
		this.educationBoardId=board.getEducationBoardId();
		this.educationBoardName=board.getEducationBoardName();
	}

	public EducationBoard(EducationBoardJson each) {
		// TODO Auto-generated constructor stub
		this.educationBoardId=each.getEducationBoardId();
		this.educationBoardName=each.getEducationBoardName();
	}

	public EducationBoard(Integer educationBoardId2, String educationBoardName2, EducationBoardJson userRequestEntity) {
		// TODO Auto-generated constructor stub
		this.educationBoardId=educationBoardId2;
		this.educationBoardName=educationBoardName2;
	}

}
