package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;


public interface QuestionService {
	
public void saveQuestion(QuestionJson newQuestion);
	
	public void saveAllQuestions(List<QuestionJson> newQuestionsList);

	public Question getQuestionId(Integer questionId);

	public void saveQuestion(Question questionFromDB);

	public Iterable<Question> findAll();

	public void deleteQuestion(Question questionFromId);

}
