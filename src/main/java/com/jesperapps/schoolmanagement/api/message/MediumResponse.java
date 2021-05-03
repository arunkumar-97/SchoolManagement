package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Medium;

public class MediumResponse extends BaseResponse{
	
	private Integer mediumId;
	private String mediumLanguage;
	
	public MediumResponse() {
		super();
	}
	
	public MediumResponse(Medium medium) {
		this.mediumId=medium.getMediumId();
		this.mediumLanguage=medium.getMediumLanguage();
	}
	
	public MediumResponse(int mediumId, String mediumLanguage) {
	
		this.mediumId = mediumId;
		this.mediumLanguage = mediumLanguage;
	}
	
	public MediumResponse(MediumRequest mediumReqEntity) {
		// TODO Auto-generated constructor stub
		this.mediumId=mediumReqEntity.getMediumId();
		this.mediumLanguage=mediumReqEntity.getMediumLanguage();
	}

	public Integer getMediumId() {
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
	
	
	

}
