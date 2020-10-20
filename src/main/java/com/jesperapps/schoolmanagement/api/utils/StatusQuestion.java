package com.jesperapps.schoolmanagement.api.utils;



public class StatusQuestion {

	
	public static String ACTIVE="Active";
	public static String DELETED = "Deleted";
	public static String INACTIVE = "InActive";
	
	public static String getStatus(String status) {
		if(StatusQuestion.INACTIVE.toLowerCase().equalsIgnoreCase(status.toLowerCase())) {
			return StatusQuestion.INACTIVE;
		}else {
			return StatusQuestion.ACTIVE;
		}
	}
}
