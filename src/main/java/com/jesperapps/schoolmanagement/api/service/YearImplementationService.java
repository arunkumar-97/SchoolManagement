package com.jesperapps.schoolmanagement.api.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.Year;
import com.jesperapps.schoolmanagement.api.repository.YearRepository;

@Service
public class YearImplementationService implements YearService {
	
	
	@Autowired
	private YearRepository yearRepository;


	@Override
	public Year checkYear(Integer year) {
		
		return yearRepository.findByYear(year);
	}


	

	@Override
	public Year createnewYear(Integer year, Integer integer) {
	Year newYear=new Year();
	newYear.setYear(year);
	newYear.setYearId(integer);
	yearRepository.save(newYear);
	
		return newYear;
	}




	@Override
	public List<Year> findAll() {
		
		return yearRepository.findAll();
	}




	@Override
	public Year findById(Integer yearId) {
	
		return yearRepository.findByYearId(yearId);
	}




	@Override
	public void deleteYear(Year yearFromDb) {
		// TODO Auto-generated method stub
		yearRepository.delete(yearFromDb);
	}

	
	
	

}
