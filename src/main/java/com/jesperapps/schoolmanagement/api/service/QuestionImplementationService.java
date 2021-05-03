package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.AnswerContent;
import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.ClassSubjects;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerAttachmentJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerContentJSON;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;
import com.jesperapps.schoolmanagement.api.repository.AnswerContentRepository;
import com.jesperapps.schoolmanagement.api.repository.QuestionRepository;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;



@Service
public class QuestionImplementationService implements QuestionService{
	@Autowired
	private QuestionRepository questionRepository;
	

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private AnswerContentService answerContentService;
	
	@Autowired
	private AnswerAttachmentService answerAttachmentService;
	
//	@Autowired
//	private AnswerContentRepository answerContentRepository;
	
	public Question createQuestionFromRequest(QuestionJson newQuestion) {
		System.out.println("newQuestion"+newQuestion.getQuestionId());
		System.out.println("answer"+newQuestion.getAnswer());
		Question newQuestionSaveToDB = new Question(newQuestion);
		Answers answersListSaveToDB = new Answers(); 
		AnswerJson eachRequestAnswer= newQuestion.getAnswer();
	eachRequestAnswer.setQuestion(newQuestionSaveToDB);
	System.out.println("function call");
	   
			Answers newAnswerSaveToDB = answerService.saveAnswer(eachRequestAnswer);
			if(newAnswerSaveToDB!=null) {
				newAnswerSaveToDB.setQuestion(newQuestionSaveToDB);
         		answerService.saveAnswer(newAnswerSaveToDB);
			//answersListSaveToDB.add(newAnswerSaveToDB);
				
			}
			
		
		//newQuestionSaveToDB.setAnswers(answersListSaveToDB);
		return newQuestionSaveToDB;
	}

	@Override
	public void saveQuestion(QuestionJson newQuestion) {
//		Question newQuestionSaveToDB = this.createQuestionFromRequest(newQuestion);
//		this.saveQuestion(newQuestionSaveToDB);
		Question newQuestionSave = new Question(newQuestion);
		Question questionsaved = this.saveQuestion(newQuestionSave);
		 newQuestion.setQuestionId(questionsaved.getQuestionId());
		 this.createQuestionFromRequest(newQuestion);
	}
	
	private Question updateAnswerAttachmentURL(Question newQuestionSaveToDB) {
//		newQuestionSaveToDB.getAnswers().forEach(answer ->{
//			AnswerAttachment attachment = answer.getImageAttachment();
//			if(attachment != null) {
//				attachment.setPictureLocation(AnswerService.BASE_URL +"/"+attachment.getPictureId());
//			}
//		});
		return newQuestionSaveToDB;
}

	@Override
	public void saveAllQuestions(List<QuestionJson> newQuestionsList) {
		// TODO Auto-generated method stub
		for(QuestionJson requestQuestion: newQuestionsList) {
			this.saveQuestion(requestQuestion);
		}
		
	}

	@Override
	public Optional<Question> getQuestionId(Integer questionId) {
		
		return questionRepository.findById(questionId);
	}

	@Override
	public Question saveQuestion(Question questionFromDB) {
		
		return questionRepository.save(questionFromDB);
		//questionFromDB = this.updateAnswerAttachmentURL(questionFromDB);
		//this.questionRepository.save(questionFromDB);
	}

	@Override
	public Iterable<Question> findAll() {

		return questionRepository.findAll();
	}

	@Override
	public void deleteQuestion(Question questionFromId) {
		questionFromId.setStatus(StatusQuestion.DELETED);
		this.saveQuestion(questionFromId);
		
	}

	@Override
	public void saveQuestionWithSubjectAndYear(Question newQuestion,Year year,ClassSubjects schoolClassesFromDb) {
		if(schoolClassesFromDb != null) {
		newQuestion.setClassSubjects(schoolClassesFromDb);
		schoolClassesFromDb.addQuestion(newQuestion);
		}
		if(year != null) {
		newQuestion.setYear(year);
		year.addQuestion(newQuestion);
		}
		
		this.saveQuestion(newQuestion);
	}

	@Override
	public List<Question> findByYearAndClassSubjects(Year year,ClassSubjects classSubjects) {
		return this.questionRepository.findByYearAndClassSubjects( year,classSubjects);
	}

	@Override
	public Question findByQuestionId(Integer questionId) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuestionId(questionId);
	}

//	@Override
//	public void saveQuestionWithSubject(Question newQuestionCreated, Subject subjectFromDb) {
//		if(subjectFromDb !=null) {
//			newQuestionCreated.setSubject(subjectFromDb);
//			subjectFromDb.addQuestion(newQuestionCreated);
//		}
//		this.saveQuestion(newQuestionCreated);
//	}

//	@Override
//	public List<Question> findBySubject(Subject subjectFromDb) {
//	
//		return this.questionRepository.findBySubject(subjectFromDb);
//	}
	
	


}
