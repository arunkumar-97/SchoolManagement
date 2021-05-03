package com.jesperapps.schoolmanagement.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jesperapps.schoolmanagement.api.message.SchoolClassesRequest;

@Entity
public class SchoolClasses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer schoolClassesId;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="classId")
	private Class clas;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="schoolId")
	private School school;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="schoolEducationBoardId")
	private SchoolEducationBoard schoolEducationBoard;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="schoolMediumId")
	private SchoolMedium schoolMedium;

	

	


	
//	public SchoolClasses(SchoolClasses user) {
//		// TODO Auto-generated constructor stub
//		this.clas=user.getClas();
//		this.school=user.getSchool();
//	}


	public SchoolClasses() {
		// TODO Auto-generated constructor stub
	}

	

	public SchoolClasses(SchoolClassesRequest each) {
		// TODO Auto-generated constructor stub
		this.clas=each.getClas();
		this.school=each.getSchool();
		this.schoolEducationBoard=each.getSchoolEducationBoard();
		this.schoolMedium=each.getSchoolMedium();
		
	}


	public SchoolClasses(SchoolClasses subscriptionClass) {
		
		// TODO Auto-generated constructor stub
		this.schoolClassesId=subscriptionClass.getShoolClassesId();
		this.clas=subscriptionClass.getClas();
		this.school=subscriptionClass.getSchool();
		this.schoolEducationBoard=subscriptionClass.getSchoolEducationBoard();
		this.schoolMedium=subscriptionClass.getSchoolMedium();
	}




	public Integer getShoolClassesId() {
		return schoolClassesId;
	}


	public void setShoolClassesId(Integer shoolClassesId) {
		this.schoolClassesId = shoolClassesId;
	}


	public Class getClas() {
		return clas;
	}


	public void setClas(Class clas) {
		this.clas = clas;
	}


	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}


	public Integer getSchoolClassesId() {
		return schoolClassesId;
	}


	public void setSchoolClassesId(Integer schoolClassesId) {
		this.schoolClassesId = schoolClassesId;
	}
	
	
	


//	public List<OneMarkQuestion> getQuestions() {
//		return questions;
//	}
//
//
//	public void setQuestions(List<OneMarkQuestion> questions) {
//		this.questions = questions;
//	}

	
	


	public SchoolEducationBoard getSchoolEducationBoard() {
		return schoolEducationBoard;
	}


	public void setSchoolEducationBoard(SchoolEducationBoard schoolEducationBoard) {
		this.schoolEducationBoard = schoolEducationBoard;
	}


	public SchoolMedium getSchoolMedium() {
		return schoolMedium;
	}


	public void setSchoolMedium(SchoolMedium schoolMedium) {
		this.schoolMedium = schoolMedium;
	}


	@Override
	public String toString() {
		return "SchoolClasses [schoolClassesId=" + schoolClassesId + ", clas=" + clas + ", school=" + school + "]";
	}


//	public void addQuestion(OneMarkQuestion newQuestion) {
//		// TODO Auto-generated method stub
//		
//		if(this.questions==null) {
//			this.questions=new ArrayList<>();
//		}
//		if(newQuestion !=null ) {
//			this.questions.add(newQuestion);
//		}
//		
//	}





	
	
	
	

}
