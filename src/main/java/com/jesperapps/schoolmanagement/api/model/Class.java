package com.jesperapps.schoolmanagement.api.model;

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

import com.jesperapps.schoolmanagement.api.message.ClassRequest;

@Entity
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classId;
	private String className;
	private String status;
	
	
	@OneToMany(mappedBy = "classes")
	private List<Subject> subjects;
	
	@OneToMany(mappedBy = "cls")
	private List<Subject> subject;
	
	@ManyToOne
	@JoinColumn(name="mediumId", referencedColumnName="mediumId")
	private Medium medium;

	@ManyToOne
	@JoinColumn(name="educationBoardId", referencedColumnName="educationBoardId")
	private EducationBoard educationBoard;

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="clas")
	private List<Question> questionsList;
	
	public List<Subject> getSubject() {
		return subject;
	}


	public void setSubject(List<Subject> subject) {
		this.subject = subject;
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


	public EducationBoard getEducationBoard() {
		return educationBoard;
	}


	public void setEducationBoard(EducationBoard educationBoard) {
		this.educationBoard = educationBoard;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public Medium getMedium() {
		return medium;
	}


	public void setMedium(Medium medium2) {
		this.medium = medium2;
	}


	public void setMedium(String medium2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public List<Question> getQuestionsList() {
		return questionsList;
	}


	public void setQuestionsList(List<Question> questionsList) {
		this.questionsList = questionsList;
	}


	public void addSubject(Subject newSubject) {
		if(this.subject != null) {
			this.subject = new ArrayList<>();
		}
		if(this.subjects != null) {
			this.subjects = new ArrayList<>();
		}
		if(newSubject != null) {
			this.subject.add(newSubject);
			this.subjects.add(newSubject);
		}
	}
	
	public void addQuestion(Question question) {
		if(this.questionsList == null) {
			this.questionsList = new ArrayList<>();
		}
		if(question != null) {
			this.questionsList.add(question);	
		}
	}

	public Class() {
		
	}
	


	public Class(ClassRequest requestClass) {
		
		this.classId=requestClass.getClassId();
		this.className=requestClass.getClassName();
		this.status = requestClass.getStatus() != null ? requestClass.getStatus() : this.status;
		
		
	}
	



	

	

}
