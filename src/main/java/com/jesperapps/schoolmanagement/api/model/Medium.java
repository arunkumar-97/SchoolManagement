package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jesperapps.schoolmanagement.api.message.BaseResponse;
import com.jesperapps.schoolmanagement.api.message.MediumRequest;

@Entity

public class Medium extends AbstractAuditingEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mediumId;
	private String mediumLanguage;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="medium")
	private List<Class> clas;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = {  CascadeType.MERGE }, mappedBy = "mediums")
//	private Set<School> school;
	
	
//	@ManyToOne(cascade = CascaZdeType.ALL)
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

	public Medium(Medium board) {
		// TODO Auto-generated constructor stub
		this.mediumId=board.getMediumId();
		this.mediumLanguage=board.getMediumLanguage();
	}

	public Medium(MediumRequest each) {
		// TODO Auto-generated constructor stub
		
		this.mediumLanguage=each.getMediumLanguage();
	}

	public Medium(Integer mediumId2, String mediumLanguage2, MediumRequest mediumRequestList) {
		// TODO Auto-generated constructor stub
		this.mediumId=mediumId2;
		this.mediumLanguage=mediumLanguage2;
	}

}
