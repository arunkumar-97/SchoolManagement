package com.jesperapps.schoolmanagement.api.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Year {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer yearId;
	@Column(unique = true)
	private Integer year;
	
	
	public Year() {
		
	}
	
	
	
	
	public Year(Integer yearId, Integer year) {
		super();
		this.yearId = yearId;
		this.year = year;
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
	
	

}
