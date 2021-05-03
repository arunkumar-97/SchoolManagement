package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import java.util.Optional;

import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.Subject;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;


public interface QuestionService {
	
public void saveQuestion(QuestionJson newQuestion);
	
	public void saveAllQuestions(List<QuestionJson> newQuestionsList);

	public Optional<Question> getQuestionId(Integer questionId);

	public Question saveQuestion(Question questionFromDB);

	public Iterable<Question> findAll();

	public void deleteQuestion(Question questionFromId);
	
	 Question createQuestionFromRequest(QuestionJson newQuestion);
	 
//	 void saveQuestionWithSubjectAndYear(Question newQuestion, Subject subject, Year year,Class clas);

//	 List<Question> findBySubjectAndYearAndClass(Subject subject,Class clas,Year year);

//	public void saveQuestionWithSubject(Question newQuestionCreated, Subject subjectFromDb);

//	public List<Question> findBySubject(Subject subjectFromDb);

//	void saveQuestionWithSubjectAndYear(Question newQuestion, SchoolClasses schoolClasses, Year year);

//	void saveQuestionWithSubjectAndYear(Question newQuestion, Year year, SchoolClasses schoolClassesFromDb);

	List<Question> findByYearAndClassSubjects(Year year, ClassSubjects classSubjects);

	void saveQuestionWithSubjectAndYear(Question newQuestion, Year year, ClassSubjects schoolClassesFromDb);

	public Question findByQuestionId(Integer questionId);

	



	
}
