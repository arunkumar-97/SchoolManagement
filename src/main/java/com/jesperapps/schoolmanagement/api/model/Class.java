package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jesperapps.schoolmanagement.api.message.ClassRequest;

@Entity
public class Class extends AbstractAuditingEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classId;
	private String className;
	private String status;
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "classes")
//	private List<Subject> subjects;
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "cls")
//	private List<Subject> subject;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clas")
	private Set<SchoolClasses> schoolClasses;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="mediumId", referencedColumnName="mediumId")
	private Medium medium;

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="educationBoardId", referencedColumnName="educationBoardId")
	private EducationBoard educationBoard;

//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy ="clas")
//	private List<Question> questionsList;
	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy ="classs")
//	private List<OneMarkQuestion> questions;
	
//	public List<Subject> getSubject() {
//		return subject;
//	}
//
//
//	public void setSubject(List<Subject> subject) {
//		this.subject = subject;
//	}



//	public List<OneMarkQuestion> getQuestions() {
//		return questions;
//	}
//
//
//	public void setQuestions(List<OneMarkQuestion> questions) {
//		this.questions = questions;
//	}


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
	
	
//	
//	public List<Subject> getSubjects() {
//		return subjects;
//	}
//
//
//	public void setSubjects(List<Subject> subjects) {
//		this.subjects = subjects;
//	}


//	public List<Question> getQuestionsList() {
//		return questionsList;
//	}
//
//
//	public void setQuestionsList(List<Question> questionsList) {
//		this.questionsList = questionsList;
//	}

//
//	public void addSubject(Subject newSubject) {
//		if(this.subject != null) {
//			this.subject = new ArrayList<>();
//		}
//		if(this.subjects != null) {
//			this.subjects = new ArrayList<>();
//		}
//		if(newSubject != null) {
//			this.subject.add(newSubject);
//			this.subjects.add(newSubject);
//		}
//	}
	
//	public void addQuestion(Question question) {
//		if(this.questionsList == null) {
//			this.questionsList = new ArrayList<>();
//		}
//		if(question != null) {
//			this.questionsList.add(question);	
//		}
//	}

	public Class() {
		
	}
	


	public Class(ClassRequest requestClass) {
		
		this.classId=requestClass.getClassId();
		this.className=requestClass.getClassName();
		this.status = requestClass.getStatus() != null ? requestClass.getStatus() : this.status;
		
		
	}

//
//	public void addQuestion(OneMarkQuestion newQuestion) {
//		if(this.questions==null) {
//			this.questions=new ArrayList<>();
//		}
//		if(newQuestion !=null ) {
//			this.questions.add(newQuestion);
//		}
//		
//	}
	



	

	

}
