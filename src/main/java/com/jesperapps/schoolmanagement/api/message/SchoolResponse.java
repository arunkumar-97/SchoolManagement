package com.jesperapps.schoolmanagement.api.message;

import java.util.List;
import java.util.Set;

import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.SchoolClasses;

public class SchoolResponse extends BaseResponse {
	
	
	private Integer schoolId;
	private String schoolName;
	private String schoolShortName;
	private String address;
	private String email;
	private Long mobileNumber;
	private String status;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private Set<EducationBoard> educationBoard;
	private Set<Medium> medium;
	private Set<SchoolClasses> classes;
	
	public SchoolResponse() {
		
	}
	
//	public SchoolResponse(int i, String string) {
//		this.statuscode=i;
//		this.description=string;
//		}
//	
	
	public SchoolResponse(School year) {
		// TODO Auto-generated constructor stub
		this.schoolId=year.getSchoolId();
		this.schoolName=year.getSchoolName();
		this.schoolShortName=year.getSchoolShortName();
		this.address=year.getAddress();
		this.email=year.getEmail();
		this.mobileNumber=year.getMobileNumber();
		this.status=year.getStatus();
		this.city=year.getCity();
		this.state=year.getState();
		this.country=year.getCountry();
		this.pincode=year.getPincode();
//		this.educationBoard=year.getEducationBoard();
//		this.medium=year.getMedium();
		this.classes=year.getSchoolClasses();
	}

//	public List<EducationBoard> getEducationBoard() {
//		return educationBoard;
//	}
//
//	public void setEducationBoard(List<EducationBoard> educationBoard) {
//		this.educationBoard = educationBoard;
//	}
//
//	public List<Medium> getMedium() {
//		return medium;
//	}
//
//	public void setMedium(List<Medium> medium) {
//		this.medium = medium;
//	}

	
	
	
	public String getEmail() {
		return email;
	}

	public Set<EducationBoard> getEducationBoard() {
		return educationBoard;
	}

	public void setEducationBoard(Set<EducationBoard> educationBoard) {
		this.educationBoard = educationBoard;
	}

	public Set<Medium> getMedium() {
		return medium;
	}

	public void setMedium(Set<Medium> medium) {
		this.medium = medium;
	}

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

	public Set<SchoolClasses> getClasses() {
		return classes;
	}

	public void setClasses(Set<SchoolClasses> classes) {
		this.classes = classes;
	}

	
	
	
	

}
