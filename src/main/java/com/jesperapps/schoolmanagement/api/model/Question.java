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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;

@Entity
public class Question extends AbstractAuditingEntity implements Serializable{
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer questionId;
		private String question;
		private String status=StatusQuestion.ACTIVE;

		
		@OneToOne(cascade = CascadeType.ALL,mappedBy = "question")
		private Answers answers;
		
//		
//		@ManyToOne
//		@JoinColumn(name="subjectId")
//		private Subject subject;
//	
//		@ManyToOne
//		@JoinColumn(name="classId")
//		private Class clas;
		
		
		@ManyToOne
		@JoinColumn(name = "classSubjectsId")
		private ClassSubjects classSubjects;
		
		
		@ManyToOne
		@JoinColumn(name="yearId")
		private Year year;
	
		public Question() {
			super();
		}
		
		public Question(QuestionJson question) {
			this.questionId=question.getQuestionId();
			this.year=question.getYear();
			this.classSubjects=question.getClassSubjects();
			this.question = question.getQuestion();
		
		}

		public Question(Question question2) {
			this.questionId=question2.getQuestionId();
			this.year=question2.getYear();
			this.classSubjects=question2.getClassSubjects();
			this.question = question2.getQuestion();
		}

		public Question(QuestionJson newQuestion, QuestionJson newQuestion2) {
			// TODO Auto-generated constructor stub
			this.questionId=newQuestion.getQuestionId();
		}

		public Integer getQuestionId() {
			return questionId;
		}

		public void setQuestionId(Integer questionId) {
			this.questionId = questionId;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		

		public Answers getAnswers() {
			return answers;
		}

		public void setAnswers(Answers answers) {
			this.answers = answers;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

//		public Subject getSubject() {
//			return subject;
//		}
//
//		public void setSubject(Subject subject) {
//			this.subject = subject;
//		}

		public Year getYear() {
			return year;
		}

		public void setYear(Year year) {
			this.year = year;
		}

		public ClassSubjects getClassSubjects() {
			return classSubjects;
		}

		public void setClassSubjects(ClassSubjects classSubjects) {
			this.classSubjects = classSubjects;
		}

		@Override
		public String toString() {
			return "Question [questionId=" + questionId + ", question=" + question + ", status=" + status + ", answers="
					+ answers + ", classSubjects=" + classSubjects + ", year=" + year + "]";
		}

	

//		public Class getClas() {
//			return clas;
//		}
//
//		public void setClas(Class clas) {
//			this.clas = clas;
//		}
//		
		

		

}
