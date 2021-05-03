package com.jesperapps.schoolmanagement.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jesperapps.schoolmanagement.api.message.BaseResponse;

import javax.persistence.JoinColumn;

@Entity
public class School extends AbstractAuditingEntity implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer schoolId;
	private String schoolName;
	private String schoolShortName;
	private String address;
	private String email;
	private Long mobileNumber;
	private String status;
	private String city;
	
	
	
	public School(Integer schoolId2) {
		
	this.schoolId=schoolId2;
	}
	
	
	
	
	public School() {
		// TODO Auto-generated constructor stub
	}



//
//	public School(School school) {
//		// TODO Auto-generated constructor stub
//		this.schoolId=school.getSchoolId();
//	}




	public Set<SchoolClasses> getSchoolClasses() {
		return schoolClasses;
	}
	public void setSchoolClasses(Set<SchoolClasses> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}
	private String state;
	private String country;
	private int pincode;
	
//	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@JoinTable(name = "school_educationBoard", joinColumns = @JoinColumn(name = "school_id" , referencedColumnName = "schoolId"), inverseJoinColumns = @JoinColumn(name = "education_board_id" , referencedColumnName = "educationBoardId	"))
//	private List<EducationBoard> educationBoard;
//	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="school")
	private Set<SchoolClasses> schoolClasses;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "school")
	private List<User> user;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="school")
	private Set<SchoolEducationBoard> schoolEducationBoard;

	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="schoolMedium")
	private Set<SchoolMedium> schoolMedium;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "school")
	private List<Topic> topic;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable( joinColumns = {  @JoinColumn(name = "schoolclass_id" , updatable = false) ,@JoinColumn(name = "school_id", updatable = false) }, inverseJoinColumns = {
//	@JoinColumn(name = "class_id", updatable = false) } )
//	private List<Class> clas;
	
	
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "school_educationBoard", joinColumns = { @JoinColumn(name = "school_id", updatable = false) }, inverseJoinColumns = {
//	@JoinColumn(name = "education_board_id", updatable = false) } )
//	private Set<EducationBoard> educationBoard;
	
	
//	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "school_medium", joinColumns = { @JoinColumn(name = "school_id", updatable = false) }, inverseJoinColumns = {
//	@JoinColumn(name = "medium_id", updatable = false) } )
//	private Set<Medium> medium;
	
	
	
	
	
	
	
	public List<User> getUser() {
		return user;
	}
	public Set<SchoolMedium> getSchoolMedium() {
		return schoolMedium;
	}




	public void setSchoolMedium(Set<SchoolMedium> schoolMedium) {
		this.schoolMedium = schoolMedium;
	}




	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	

//public Set<EducationBoard> getEducationBoard() {
//		return educationBoard;
//	}
//
//
//
//
//	public void setEducationBoard(Set<EducationBoard> educationBoard) {
//		this.educationBoard = educationBoard;
//	}
//
//
//
//
//	public Set<Medium> getMedium() {
//		return medium;
//	}
//
//
//
//
//	public void setMedium(Set<Medium> medium) {
//		this.medium = medium;
//	}




	public Set<SchoolEducationBoard> getSchoolEducationBoard() {
		return schoolEducationBoard;
	}




	public void setSchoolEducationBoard(Set<SchoolEducationBoard> schoolEducationBoard) {
		this.schoolEducationBoard = schoolEducationBoard;
	}




	//	public List<Medium> getMedium() {
//		return medium;
//	}
//	public void setMedium(List<Medium> medium) {
//		this.medium = medium;
//	}
	public String getEmail() {
		return email;
	}
//	public List<EducationBoard> getEducationBoard() {
//		return educationBoard;
//	}
//	public void setEducationBoard(List<EducationBoard> educationBoard) {
//		this.educationBoard = educationBoard;
//	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolShortName() {
		return schoolShortName;
	}
	public void setSchoolShortName(String schoolShortName) {
		this.schoolShortName = schoolShortName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	
	
}
