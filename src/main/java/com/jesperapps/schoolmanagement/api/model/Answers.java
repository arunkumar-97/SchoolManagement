package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;


@Entity
@Table(name="Answers")
public class Answers {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer answerId;
	private String label;
	@Column(length = 5000)
	private String answer;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GifImg")
	private AnswerAttachment imageAttachment;
	
	@ManyToOne
	@JoinColumn(name="question_Id",referencedColumnName = "questionId")
	private Question question;
	
	//Constructor
	public Answers() {
		super();
	}
	
	public Answers(AnswerJson answer) {
		
		this.answer = answer.getAnswer();
		this.label =answer.getLabel();
		}
		
	


	public Integer getAnswerId() {
		return answerId;
	}


	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}

	public AnswerAttachment getImageAttachment() {
		return imageAttachment;
	}

	public void setImageAttachment(AnswerAttachment imageAttachment) {
		this.imageAttachment = imageAttachment;
	}



}
