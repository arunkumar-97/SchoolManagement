package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.Subject;

import com.jesperapps.schoolmanagement.api.model.Class;

import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;


public interface QuestionService {
	
public void saveQuestion(QuestionJson newQuestion);
	
	public void saveAllQuestions(List<QuestionJson> newQuestionsList);

	public Question getQuestionId(Integer questionId);

	public void saveQuestion(Question questionFromDB);

	public Iterable<Question> findAll();

	public void deleteQuestion(Question questionFromId);
	
	 Question createQuestionFromRequest(QuestionJson newQuestion);
	 
	 void saveQuestionWithSubjectAndYear(Question newQuestion, Subject subject, Year year,Class clas);

	 List<Question> findBySubjectAndYearAndClass(Subject subject,Class clas,Year year);

	public void saveQuestionWithSubject(Question newQuestionCreated, Subject subjectFromDb);

	public List<Question> findBySubject(Subject subjectFromDb);

	
}
