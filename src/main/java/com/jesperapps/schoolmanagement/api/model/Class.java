package com.jesperapps.schoolmanagement.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jesperapps.schoolmanagement.api.message.ClassRequest;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;

@Entity
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classId;
	private String className;
	private String status=StatusClass.INACTIVE;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cls")
	private List<Subject> subject;
	
	

	public List<Subject> getSubject() {
		return subject;
	}


	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}


	public Class() {
		super();
	}
	
	
	public Class(ClassRequest requestClass) {
		
		this.classId=requestClass.getClassId();
		this.className=requestClass.getClassName();
		this.status = requestClass.getStatus() != null ? requestClass.getStatus() : this.status;
		
		
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
