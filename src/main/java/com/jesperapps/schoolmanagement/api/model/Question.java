package com.jesperapps.schoolmanagement.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;

@Entity
public class Question {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer questionId;
		private String question;
		private String status=StatusQuestion.ACTIVE;

		
		@OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
		private List<Answers> answers;
		
		
		@ManyToOne
		@JoinColumn(name="subjectId")
		private Subject subject;
	
		@ManyToOne
		@JoinColumn(name="classId")
		private Class clas;
		
		@ManyToOne
		@JoinColumn(name="yearId")
		private Year year;
	
		public Question() {
			super();
		}
		
		public Question(QuestionJson question) {
			
			this.question = question.getQuestion();
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

		public List<Answers> getAnswers() {
			return answers;
		}

		public void setAnswers(List<Answers> answers) {
			this.answers = answers;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Subject getSubject() {
			return subject;
		}

		public void setSubject(Subject subject) {
			this.subject = subject;
		}

		public Year getYear() {
			return year;
		}

		public void setYear(Year year) {
			this.year = year;
		}

		public Class getClas() {
			return clas;
		}

		public void setClas(Class clas) {
			this.clas = clas;
		}
		
		

		

}
