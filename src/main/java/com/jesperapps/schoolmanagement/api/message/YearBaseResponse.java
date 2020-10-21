package com.jesperapps.schoolmanagement.api.message;

public class YearBaseResponse extends BaseResponse{
	
	private YearResponse year;
	
	
	public YearBaseResponse(int statuscode,String description) {
		this.statuscode=statuscode;
		this.description=description;
		
	}

	public YearResponse getYear() {
		return year;
	}

	public void setYear(YearResponse year) {
		this.year = year;
	}

	
	
	
	
}
