package com.jesperapps.schoolmanagement.api.message;

public class YearBaseResponse extends BaseResponse{
	
	private YearResponse year;
	
	
	public YearBaseResponse(int statuscode,String description) {
	super(statuscode,description);
		
	}

	public YearResponse getYear() {
		return year;
	}

	public void setYear(YearResponse year) {
		this.year = year;
	}

	
	
	
	
}
