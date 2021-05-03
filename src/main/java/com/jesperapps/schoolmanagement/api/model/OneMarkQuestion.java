package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkQuestionJSON;

@Entity
public class OneMarkQuestion extends AbstractAuditingEntity implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer oneMarkQuestionId;
	private String question;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
	List<OneMarkAnswers> answers;
	
//	@ManyToOne
//	@JoinColumn(name="subjectId")
//	private Subject subjects;
//
//	@ManyToOne
//	@JoinColumn(name="classId")
//	private Class classs;
	
	
	@ManyToOne
	@JoinColumn(name = "classSubjectsId")
	private ClassSubjects classSubjects;
	
	
	@ManyToOne
	@JoinColumn(name="yearId")
	private Year years;

	
	public OneMarkQuestion() {
		
	}
	
	
	public OneMarkQuestion(OneMarkQuestionJSON newQuestion) {
		this.question=newQuestion.getQuestion();
		this.description=newQuestion.getDescription();
	}
	
	
	


	public ClassSubjects getClassSubjects() {
		return classSubjects;
	}


	public void setClassSubjects(ClassSubjects classSubjects) {
		this.classSubjects = classSubjects;
	}


	public Integer getOneMarkQuestionId() {
		return oneMarkQuestionId;
	}
	public void setOneMarkQuestionId(Integer oneMarkQuestionId) {
		this.oneMarkQuestionId = oneMarkQuestionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<OneMarkAnswers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<OneMarkAnswers> answers) {
		this.answers = answers;
	}
//	public Subject getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(Subject subjects) {
//		this.subjects = subjects;
//	}
//	public Class getClasss() {
//		return classs;
//	}
//	public void setClasss(Class classs) {
//		this.classs = classs;
//	}
	public Year getYears() {
		return years;
	}
	public void setYears(Year years) {
		this.years = years;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	
	
	
	
	
	
}
