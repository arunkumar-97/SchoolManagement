package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.utils.StatusSubject;


@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subjectId;
	private String subjectName;
	private String status= StatusSubject.INACTIVE;
	
	
	public Subject() {
		
	}
	
	public Subject(SubjectRequest subjectRequest) {
		this.subjectId=subjectRequest.getSubjectId();
		this.subjectName=subjectRequest.getSubjectName();
		this.status = subjectRequest.getStatus() != null ? subjectRequest.getStatus() : this.status;
	}
	

	@ManyToOne
	@JoinTable(name="classSubject",joinColumns=@JoinColumn(name="subjectId", referencedColumnName="subjectId"), inverseJoinColumns=@JoinColumn(name="classId", referencedColumnName="classId"))
	private Class cls;
	
	
	public Class getCls() {
		return cls;
	}

	public void setCls(Class cls) {
		this.cls = cls;
	}

	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
