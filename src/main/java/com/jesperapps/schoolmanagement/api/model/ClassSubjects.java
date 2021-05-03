package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jesperapps.schoolmanagement.api.message.ClassSubjectsRequest;

@Entity
public class ClassSubjects {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classSubjectsId;
	
	
	private String status;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="schoolClassesId")
	private SchoolClasses schoolClasses;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="subjectId")
	private Subject subject;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="classSubjects")
	private List<Question> questionsList;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="classSubjects")
	private List<OneMarkQuestion> questions;

	public ClassSubjects(ClassSubjects user) {
		// TODO Auto-generated constructor stub
		this.classSubjectsId=user.getClassSubjectsId();
		this.subject=user.getSubject();
	}


	public ClassSubjects() {
		// TODO Auto-generated constructor stub
	}


	


	


	public ClassSubjects(Integer classSubjectsId2, SchoolClasses schoolClasses2, Subject subject2, String status2,
			ClassSubjectsRequest classSubjectsRequest) {
		// TODO Auto-generated constructor stub
		
		this.classSubjectsId=classSubjectsRequest.getClassSubjectsId();
		this.schoolClasses=schoolClasses2;
		this.subject=subject2;
		this.status=classSubjectsRequest.getStatus();
	}


	public ClassSubjects(ClassSubjectsRequest each) {
		// TODO Auto-generated constructor stub
		this.classSubjectsId=each.getClassSubjectsId();
		this.status=each.getStatus();
		this.schoolClasses=each.getSchoolClasses();
		this.subject=each.getSubject();
	}


	public Integer getClassSubjectsId() {
		return classSubjectsId;
	}


	public void setClassSubjectsId(Integer classSubjectsId) {
		this.classSubjectsId = classSubjectsId;
	}








	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public SchoolClasses getSchoolClasses() {
		return schoolClasses;
	}


	public void setSchoolClasses(SchoolClasses schoolClasses) {
		this.schoolClasses = schoolClasses;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public void addQuestion(Question newQuestion) {
		if(this.questionsList==null) {
		this.questionsList=new ArrayList<>();
	}
	if(newQuestion !=null) {
		this.questionsList.add(newQuestion);
	}
		
	}


	public void addQuestion(OneMarkQuestion newQuestion) {
		// TODO Auto-generated method stub
		
	}
	
	
}
