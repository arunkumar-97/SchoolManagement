package com.jesperapps.schoolmanagement.api.utils;

public class StatusSubject {

	public static String ACTIVE="Active";
	public static String DELETED = "Deleted";
	public static String INACTIVE = "InActive";
	
	public static String getStatus(String status) {
		if(StatusClass.INACTIVE.toLowerCase().equalsIgnoreCase(status.toLowerCase())) {
			return StatusClass.INACTIVE;
		}else {
			return StatusClass.ACTIVE;
		}
	}
}
