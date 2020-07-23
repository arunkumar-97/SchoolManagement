package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jesperapps.schoolmanagement.api.message.RequestClass;

@Entity
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;
	private String className;
	private String Status;
	
	public Class() {
		super();
	}
	
	
	public Class(RequestClass requestClass) {
		
		this.classId=requestClass.getClassId();
		this.className=requestClass.getClassName();
		
		
	}
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}


	



	

	

}
