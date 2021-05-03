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
public class SchoolMedium  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer schoolMediumId;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="schoolId")
	private School schoolMedium;
	
	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="mediumId")
	private Medium medium;


	public Integer getSchoolMediumId() {
		return schoolMediumId;
	}


	public void setSchoolMediumId(Integer schoolMediumId) {
		this.schoolMediumId = schoolMediumId;
	}



	public School getSchoolMedium() {
		return schoolMedium;
	}


	public void setSchoolMedium(School schoolMedium) {
		this.schoolMedium = schoolMedium;
	}


	public Medium getMedium() {
		return medium;
	}


	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	
	
	
	

}
