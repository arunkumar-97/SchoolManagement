package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.AnswerAttachment;
import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.model.Question;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.modelmessage.AnswerJson;
import com.jesperapps.schoolmanagement.api.modelmessage.QuestionJson;
import com.jesperapps.schoolmanagement.api.repository.QuestionRepository;
import com.jesperapps.schoolmanagement.api.utils.StatusQuestion;



@Service
public class QuestionImplementationService implements QuestionService{
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Autowired
	private AnswerService answerService;
	
	public Question createQuestionFromRequest(QuestionJson newQuestion) {
		Question newQuestionSaveToDB = new Question(newQuestion);
		List<Answers> answersListSaveToDB = new ArrayList<>(); 
		for(AnswerJson eachRequestAnswer : newQuestion.getAnswer()) {
			Answers newAnswerSaveToDB = answerService.saveAnswer(eachRequestAnswer);
			if(newAnswerSaveToDB!=null) {
				newAnswerSaveToDB.setQuestion(newQuestionSaveToDB);
				answersListSaveToDB.add(newAnswerSaveToDB);
			}
			
		}
		newQuestionSaveToDB.setAnswers(answersListSaveToDB);
		return newQuestionSaveToDB;
	}

	@Override
	public void saveQuestion(QuestionJson newQuestion) {
		Question newQuestionSaveToDB = this.createQuestionFromRequest(newQuestion);
		this.saveQuestion(newQuestionSaveToDB);
	}
	
	private Question updateAnswerAttachmentURL(Question newQuestionSaveToDB) {
		newQuestionSaveToDB.getAnswers().forEach(answer ->{
			AnswerAttachment attachment = answer.getImageAttachment();
			if(attachment != null) {
				attachment.setPictureLocation(AnswerService.BASE_URL +"/"+attachment.getPictureId());
			}
		});
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
	public Question getQuestionId(Integer questionId) {
		
		return questionRepository.findByQuestionId(questionId);
	}

	@Override
	public void saveQuestion(Question questionFromDB) {
		
		questionRepository.save(questionFromDB);
		questionFromDB = this.updateAnswerAttachmentURL(questionFromDB);
		this.questionRepository.save(questionFromDB);
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
	public void saveQuestionWithSubjectAndYear(Question newQuestion, Subject subject, Year year,Class clas) {
		if(subject != null) {
		newQuestion.setSubject(subject);
		subject.addQuestion(newQuestion);
		}
		if(year != null) {
		newQuestion.setYear(year);
		year.addQuestion(newQuestion);
		}
		if(clas !=null) {
			newQuestion.setClas(clas);
			clas.addQuestion(newQuestion);
		}
		this.saveQuestion(newQuestion);
	}

	@Override
	public List<Question> findBySubjectAndYearAndClass(Subject subject,Class clas, Year year) {
		return this.questionRepository.findBySubjectAndYearAndClas(subject, year,clas);
	}

	@Override
	public void saveQuestionWithSubject(Question newQuestionCreated, Subject subjectFromDb) {
		if(subjectFromDb !=null) {
			newQuestionCreated.setSubject(subjectFromDb);
			subjectFromDb.addQuestion(newQuestionCreated);
		}
		this.saveQuestion(newQuestionCreated);
	}

	@Override
	public List<Question> findBySubject(Subject subjectFromDb) {
	
		return this.questionRepository.findBySubject(subjectFromDb);
	}
	
	


}
