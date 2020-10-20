package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Answers;
import com.jesperapps.schoolmanagement.api.model.Question;
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

	@Override
	public void saveQuestion(QuestionJson newQuestion) {
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
		questionRepository.save(newQuestionSaveToDB);
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
	}

	@Override
	public Iterable<Question> findAll() {

		return questionRepository.findAll();
	}

	@Override
	public void deleteQuestion(Question questionFromId) {
		questionFromId.setStatus(StatusQuestion.DELETED);
		this.saveQuestion1(questionFromId);
		
	}

	public boolean saveQuestion1(Question question)
	{
		try{
		questionRepository.save(question);
			return true;
			}
		catch(Exception e) 
			{
			return false;
			}
	}
	
	


}
