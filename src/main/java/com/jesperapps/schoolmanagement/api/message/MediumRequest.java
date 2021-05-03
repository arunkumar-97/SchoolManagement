package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Medium;

public class MediumRequest {
	
	private Integer mediumId;
	private String mediumLanguage;
	
	public MediumRequest() {
		
	}
	
	public MediumRequest(Medium mediumData) {
		// TODO Auto-generated constructor stub
		
		this.mediumId=mediumData.getMediumId();
		this.mediumLanguage=mediumData.getMediumLanguage();
	}
	public Integer getMediumId() {
		return mediumId;
	}
	public void setMediumId(Integer mediumId) {
		this.mediumId = mediumId;
	}
	public String getMediumLanguage() {
		return mediumLanguage;
	}
	public void setMediumLanguage(String mediumLanguage) {
		this.mediumLanguage = mediumLanguage;
	}
	
	
	
	
	

}
