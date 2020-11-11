package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.OneMarkQuestion;

import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkQuestionJSON;


public interface OneMarkQuestionService {

	void saveAllOneMarkQuestions(List<OneMarkQuestionJSON> requestOneMarkQuestionsList);

	public void saveQuestion(OneMarkQuestionJSON newQuestion);
	
	public void saveQuestion(OneMarkQuestion questionFromDB);
	
	OneMarkQuestion createQuestionFromRequest(OneMarkQuestionJSON newQuestion);
	
	void saveQuestionWithSubjectAndYear(OneMarkQuestion newQuestion, Subject subject, Year year,Class clas);

	List<OneMarkQuestion> findBySubjectAndYearAndClass(Subject subjectFromDb, Class classFromDb, Year yearFromDb);

}
