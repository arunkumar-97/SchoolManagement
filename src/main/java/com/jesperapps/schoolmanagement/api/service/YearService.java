package com.jesperapps.schoolmanagement.api.service;


import java.util.List;


import com.jesperapps.schoolmanagement.api.model.Year;

public interface YearService {

	

	Year checkYear(Integer year);

	Year createnewYear(Integer year, Integer integer);

	List<Year> findAll();

	Year findById(Integer yearId);

	void deleteYear(Year yearFromDb);

	Year findByYearId(Integer yearId);

	

	

}
