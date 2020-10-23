package com.jesperapps.schoolmanagement.api.model;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Year {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer yearId;
	@Column(unique = true)
	private Integer year;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="year")
	private List<Question> questionsList;
	
	public Year() {
		super();
	}
	
	
	
	
	public Year(Integer yearId, Integer year) {
		super();
		this.yearId = yearId;
		this.year = year;
	}

	



	public List<Question> getQuestionsList() {
		return questionsList;
	}




	public void setQuestionsList(List<Question> questionsList) {
		this.questionsList = questionsList;
	}




	public Integer getYearId() {
		return yearId;
	}
	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	

	
	public void addQuestion(Question question) {
		if(this.questionsList == null) {
			this.questionsList = new ArrayList<>();
		}
		if(question != null) {
			this.questionsList.add(question);	
		}
	}

}
