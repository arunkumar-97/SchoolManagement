package com.jesperapps.schoolmanagement.api.message;

import com.jesperapps.schoolmanagement.api.model.Class;

public class ClassJSON {
	
	
	
	private Integer classId;
	private String className;
	private String status;
	
	
	public ClassJSON() {
		
	}
	
	public ClassJSON(Class cls) {
		if(cls !=null) {
			
			this.classId=cls.getClassId();
			this.className=cls.getClassName();
			this.status=cls.getStatus();
			
		}
		
		
	}
	
	
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
