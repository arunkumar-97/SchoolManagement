package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.List;
import java.util.stream.Collectors;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.AnswerContent;
import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.model.Question;

public class AnswerJson {
	
	private Integer answerId;
	private List<AnswerContentJSON> answerContent;
//	private AnswerAttachment answerAttachment;
	
	private Question  question;
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
//	public String getLabel() {
//		return label;
//	}
//	public void setLabel(String label) {
//		this.label = label;
//	}
//	public String getAnswer() {
//		return answer;
//	}
//	public void setAnswer(String answer) {
//		this.answer = answer;
//	}
	
	

	public AnswerJson() {
		
	}
public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
public AnswerJson(Answers answers) {
		// TODO Auto-generated constructor stub
	
	this.answerId=answers.getAnswerId();
	this.answerContent=answers.getAnswerContent().stream().map(content ->{
		
		return new AnswerContentJSON(content);
		
	}).collect(Collectors.toList());
	}
//		public AnswerJson(Answers answers) {
//		this.answerId=answers.getAnswerId();
//		this.label=answers.getLabel();
//		this.answer=answers.getAnswer();
//		if(answers.getImageAttachment()!=null) {
//		this.answerAttachment= new AnswerAttachmentJSON(answers.getImageAttachment());
//		}
//		}
//	    public AnswerContent getAnswerContent() {
//		return answerContent;
//   	}
//	    public void setAnswerContent(AnswerContent answerContent) {
//		this.answerContent = answerContent;
//	}
	public List<AnswerContentJSON> getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(List<AnswerContentJSON> answerContent) {
		this.answerContent = answerContent;
	}
//	@Override
//	public String toString() {
//		return "AnswerJson [answerId=" + answerId + ", answerContent=" + answerContent + "]";
//	}
	
	

}
