package com.jesperapps.schoolmanagement.api.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jesperapps.schoolmanagement.api.message.SubjectRequest;
import com.jesperapps.schoolmanagement.api.utils.StatusSubject;


@Entity
public class Subject extends AbstractAuditingEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subjectId;
	private String subjectName;
	private String status= StatusSubject.INACTIVE;
	
	
	
	@ManyToOne
	@JoinTable(name="classSubject",joinColumns=@JoinColumn(name="subjectId", referencedColumnName="subjectId"), inverseJoinColumns=@JoinColumn(name="classId", referencedColumnName="classId"))
	private Class cls;
	
//	@ManyToOne
//	@JoinColumn(name="classId", referencedColumnName="classId")
//	private Class classes;
	
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="subject")
//	private List<Question> questionsList;
 	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="subjects")
//	private List<OneMarkQuestion> questions;
	
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
	
	public Subject() {
		
	}
	
	public Subject(SubjectRequest subjectRequest) {
		this.subjectId=subjectRequest.getSubjectId();
		this.subjectName=subjectRequest.getSubjectName();
		this.status = subjectRequest.getStatus() != null ? subjectRequest.getStatus() : this.status;
	}

//	public Class getClasses() {
//		return classes;
//	}
//
//	public void setClasses(Class classes) {
//		this.classes = classes;
//	}

//	public List<Question> getQuestionsList() {
//		return questionsList;
//	}
//
//	public void setQuestionsList(List<Question> questionsList) {
//		this.questionsList = questionsList;
//	}
	
//	public void addQuestion(Question question) {
//		if(this.questionsList == null) {
//			this.questionsList = new ArrayList<>();
//		}
//		if(question != null) {
//			this.questionsList.add(question);	
//		}
//	}

//	public void addQuestion(OneMarkQuestion newQuestion) {
//		if(this.questions==null) {
//			this.questions=new ArrayList<>();
//		}
//		if(newQuestion !=null) {
//			this.questions.add(newQuestion);
//		}
//		
//	}
//	

}
