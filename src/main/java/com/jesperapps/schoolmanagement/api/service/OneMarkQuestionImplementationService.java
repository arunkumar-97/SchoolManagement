package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.OneMarkAnswers;
import com.jesperapps.schoolmanagement.api.model.OneMarkQuestion;

import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkAnswerJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.OneMarkQuestionJSON;
import com.jesperapps.schoolmanagement.api.repository.OneMarkQuestionRepository;

@Service
public class OneMarkQuestionImplementationService implements OneMarkQuestionService {
	
	
	
	@Autowired
	private OneMarkQuestionRepository oneMarkQuestionRepository;
	
	@Autowired
	private OneMarkAnswerService  OneMarkAnswerService;

	@Override
	public void saveAllOneMarkQuestions(List<OneMarkQuestionJSON> requestOneMarkQuestionsList) {
		
		for(OneMarkQuestionJSON requestQuestion:requestOneMarkQuestionsList) {
			this.saveQuestion(requestQuestion);
			
		}
		
	}

	public void saveQuestion(OneMarkQuestionJSON newQuestion) {
			
		OneMarkQuestion newQuestionSaveToDb=this.createQuestionFromRequest(newQuestion);
		this.saveQuestion(newQuestionSaveToDb);
		
	}

	@Override
	public void saveQuestion(OneMarkQuestion questionFromDB) {
		
		oneMarkQuestionRepository.save(questionFromDB);
	}

	@Override
	public OneMarkQuestion createQuestionFromRequest(OneMarkQuestionJSON newQuestion) {
		OneMarkQuestion newQuestionSaveToDB = new OneMarkQuestion(newQuestion);
		List<OneMarkAnswers> answersListSaveToDB = new ArrayList<>(); 
		for(OneMarkAnswerJSON eachRequestAnswer : newQuestion.getOptions()) {
			OneMarkAnswers newAnswerSaveToDB = OneMarkAnswerService.saveAnswer(eachRequestAnswer);
			if(newAnswerSaveToDB!=null) {
				newAnswerSaveToDB.setQuestion(newQuestionSaveToDB);
			
				answersListSaveToDB.add(newAnswerSaveToDB);
			}
			
		}
		newQuestionSaveToDB.setAnswers(answersListSaveToDB);
	
		return newQuestionSaveToDB;
	}
	

	@Override
	public void saveQuestionWithSubjectAndYear(OneMarkQuestion newQuestion, Subject subject, Year year, Class clas) {
		if(subject != null) {
			newQuestion.setSubjects(subject);
			subject.addQuestion(newQuestion);
			}
			if(year != null) {
			newQuestion.setYears(year);
			year.addQuestion(newQuestion);
			}
			if(clas !=null) {
				newQuestion.setClasss(clas);
				clas.addQuestion(newQuestion);
			}
			this.saveQuestion(newQuestion);
		
	}

	@Override
	public List<OneMarkQuestion> findBySubjectAndYearAndClass(Subject subjectFromDb, Class classFromDb, Year yearFromDb) {
		
		return this.oneMarkQuestionRepository.findBySubjectsAndYearsAndClasss(subjectFromDb,yearFromDb,classFromDb);
	}

}
