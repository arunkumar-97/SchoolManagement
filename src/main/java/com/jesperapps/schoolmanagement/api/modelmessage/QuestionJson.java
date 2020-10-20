package com.jesperapps.schoolmanagement.api.modelmessage;

import java.util.ArrayList;
import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;



public class QuestionJson {

	
	private Integer questionId;
	private String question;
	private String status=StatusQuestion.INACTIVE;

	
	private List<AnswerJson> answer;

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

	public List<AnswerJson> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerJson> answer) {
		this.answer = answer;
	}
	
	
	
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public QuestionJson() {
		
	}
	
	public QuestionJson(Question question) {
		this.questionId=question.getQuestionId();
		this.question=question.getQuestion();
	}


	
	public QuestionJson(Integer questionId2, String question2,String status, List<Answers> answers) {
		// TODO Auto-generated constructor stub
		this.question=question2;
		this.status=status;
		this.questionId=questionId2;
		if(this.answer==null) {
			this.answer=new ArrayList<>();
		}
		if(answers != null) {
			for(Answers eachAnswer:answers) {
				this.answer.add(new AnswerJson(eachAnswer));
			}
		}
	}

}
