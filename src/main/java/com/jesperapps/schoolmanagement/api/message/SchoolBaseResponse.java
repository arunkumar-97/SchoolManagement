package com.jesperapps.schoolmanagement.api.message;

public class SchoolBaseResponse extends BaseResponse {
	
	private SchoolResponse schools;
	
	
	public SchoolBaseResponse(int statuscode,String description) {
		super(statuscode,description);
		
	}


	public SchoolResponse getSchools() {
		return schools;
	}


	public void setSchools(SchoolResponse schools) {
		this.schools = schools;
	}
	
	

}
