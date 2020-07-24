package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jesperapps.schoolmanagement.api.message.RequestClass;
import com.jesperapps.schoolmanagement.api.utils.ClassStatus;

@Entity
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classId;
	private String className;
	private String classStatus=ClassStatus.NULL;
	
	public Class() {
		super();
	}
	
	
	public Class(RequestClass requestClass) {
		
		this.classId=requestClass.getClassId();
		this.className=requestClass.getClassName();
		
		
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


	public String getClassStatus() {
		return classStatus;
	}


	public void setClassStatus(String clsStatus) {
		this.classStatus = clsStatus;
	}




	



	

	

}
