package com.jesperapps.schoolmanagement.api.message;

public class YearResponse {
	
	private Integer yearId;
	private Integer year;
	
	
	public YearResponse() {
		
	}
	
	
	public YearResponse(YearRequest yearRequest) {
		this.yearId=yearRequest.getYearId();
		this.year=yearRequest.getYearId();
	}
	public YearResponse(Integer yearId2, Integer year2) {
		this.yearId=yearId2;
		this.year=year2;
	}


	public Integer getYearId() {
		return yearId;
	}
	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	

}
