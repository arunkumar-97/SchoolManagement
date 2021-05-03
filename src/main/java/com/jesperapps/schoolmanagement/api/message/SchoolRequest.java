package com.jesperapps.schoolmanagement.api.message;

import java.util.Set;
import com.jesperapps.schoolmanagement.api.model.EducationBoard;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.model.School;

public class SchoolRequest {
	
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
	private UserRequestWithProfilePicture user;
	
	
	
	public SchoolRequest() {
		
	}
	
	
	public SchoolRequest(School createdSchool) {
		// TODO Auto-generated constructor stub
	this.schoolId=createdSchool.getSchoolId();
	this.schoolName=createdSchool.getSchoolName();
	this.schoolShortName=createdSchool.getSchoolShortName();
	if(createdSchool.getUser() !=null) {
		
	}
	
	}
	
	public Set<Medium> getMedium() {
		return medium;
	}
	public void setMedium(Set<Medium> medium) {
		this.medium = medium;
	}
	public String getEmail() {
		return email;
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
	public Set<EducationBoard> getEducationBoard() {
		return educationBoard;
	}
	public void setEducationBoard(Set<EducationBoard> educationBoard) {
		this.educationBoard = educationBoard;
	}
	public UserRequestWithProfilePicture getUser() {
		return user;
	}
	public void setUser(UserRequestWithProfilePicture user) {
		this.user = user;
	}
	
	
	
	

}
