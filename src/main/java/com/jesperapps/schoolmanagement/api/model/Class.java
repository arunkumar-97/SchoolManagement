package com.jesperapps.schoolmanagement.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jesperapps.schoolmanagement.api.message.ClassRequest;

@Entity
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classId;
	private String className;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cls ")
	List<Subject> subject;
	
	

	public Class() {
		super();
	}
	
	
	public Class(ClassRequest requestClass) {
		
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	



	



	

	

}
