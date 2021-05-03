package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolMedium;

public class SchoolMediumResponse extends BaseResponse{
	
	private Integer schoolMediumId;
	private School school;
	private Medium medium;
	
	
	public SchoolMediumResponse(SchoolMedium schoolmedium) {
		// TODO Auto-generated constructor stub
		this.schoolMediumId=schoolmedium.getSchoolMediumId();
		this.medium=schoolmedium.getMedium();
	}
	public SchoolMediumResponse() {
		
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	public Integer getSchoolMediumId() {
		return schoolMediumId;
	}
	public void setSchoolMediumId(Integer schoolMediumId) {
		this.schoolMediumId = schoolMediumId;
	}
	
	
	

}
