package com.jesperapps.schoolmanagement.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medium {
	
	@Id
	private int mediumId;
	private String mediumLanguage;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="medium")
	private List<Class> clas;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="EducationBoardId",referencedColumnName = "educationBoardId")
//	private EducationBoard educationBoard;
	
	
	public int getMediumId() {
		return mediumId;
	}

	public void setMediumId(int mediumId) {
		this.mediumId = mediumId;
	}

	public String getMediumLanguage() {
		return mediumLanguage;
	}

	public void setMediumLanguage(String mediumLanguage) {
		this.mediumLanguage = mediumLanguage;
	}

	public List<Class> getClas() {
		return clas;
	}

	public void setClas(List<Class> clas) {
		this.clas = clas;
	}
	
	public void addClass(Class clas) {
		if(clas != null) {
			this.clas.add(clas);	
		}
	}


	public Medium() {
		
	}

	public Medium(int id, String medium) {
		this.mediumId=id;
		this.mediumLanguage=medium;
	}

}
