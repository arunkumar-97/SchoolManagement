package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.message.ClassResponse;
import com.jesperapps.schoolmanagement.api.model.Medium;
import com.jesperapps.schoolmanagement.api.repository.MediumRepository;

@Service
public class MediumImplementationService implements MediumService{

	@Autowired
	private MediumRepository mediumRepository;
	
	@Override
	public Medium findMediumFromId(Integer mediumId) {
		// TODO Auto-generated method stub
		return mediumRepository.findMediumByMediumId(mediumId);
	}

	@Override
	public void saveMedium(Medium medium) {
		// TODO Auto-generated method stub
		mediumRepository.save(medium);
	}

	@Override
	public List<ClassResponse> findMediumClasses(Integer mediumId) {
		// TODO Auto-generated method stub
		List<ClassResponse> response = new ArrayList<>();
		Medium medium = this.findMediumFromId(mediumId);
		if(medium != null) {
			for(Class cls: medium.getClas()) {
				response.add(new ClassResponse(cls));
			}
		}
		return response;
	}

}
