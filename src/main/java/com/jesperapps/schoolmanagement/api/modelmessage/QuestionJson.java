package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.ArrayList;
import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;



public class QuestionJson {

	
	private Year year;
	private ClassSubjects classSubjects;
	private Integer questionId;
	private String question;
	private String status=StatusQuestion.INACTIVE;

	
	private AnswerJson answer;

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

//	public Answers getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(Answers answer) {
//		this.answer = answer;
//	}

	public String getStatus() {
		return status;
	}

	public AnswerJson getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerJson answer) {
		this.answer = answer;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public QuestionJson(Question question) {
		this.questionId=question.getQuestionId();
		this.question=question.getQuestion();
		if(question.getAnswers() != null)
		{
			this.answer=new AnswerJson(question.getAnswers());
		}else {
			this.answer=new AnswerJson();
		}
		
		this.classSubjects=question.getClassSubjects();
		this.year=question.getYear();
//		Answers answers=question.getAnswers();
//		if(this.answer==null) {
//			this.answer=new ArrayList<>();
//		}
//		if(answers != null) {
//			for(Answers eachAnswer:answers) {
//				this.answer.add(new AnswerJson(eachAnswer));
//			}
//		}
	}


	
	public QuestionJson(Integer questionId2, String question2,String status, AnswerJson answers) {
		// TODO Auto-generated constructor stub
		this.question=question2;
		this.status=status;
		this.questionId=questionId2;
		this.answer=answers;
//		if(this.answer==null) {
//			this.answer=new ArrayList<>();
//		}
//		if(answers != null) {
//			for(Answers eachAnswer:answers) {
//				this.answer.add(new AnswerJson(eachAnswer));
//			}
//		}
	}

	public QuestionJson() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QuestionJson [year=" + year + ", classSubjects=" + classSubjects + ", questionId=" + questionId
				+ ", question=" + question + ", status=" + status + ", answer=" + answer + "]";
	}
	
	
	

}
