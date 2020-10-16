package com.jesperapps.schoolmanagement.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jesperapps.schoolmanagement.api.model.Subject;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.repository.SubjectRepository;
import com.jesperapps.schoolmanagement.api.utils.StatusClass;
import com.jesperapps.schoolmanagement.api.utils.StatusSubject;

@Service
public class SubjectImplementationService implements SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ClassService classService;
	
	
	public void addSubject (List<Subject> subjects) {
		 subjectRepository.saveAll(subjects);
	}


	@Override
	public Subject checksubject(String subjectName) {
		
		return subjectRepository.findBySubjectName(subjectName);
	}


	@Override
	public Subject createnewSubject(String subjectName, Integer subjectId, String status,Integer classId) {
		Subject newsubject=new Subject();
		newsubject.setSubjectName(subjectName);
		newsubject.setSubjectId(subjectId);
		newsubject.setStatus(status);
		Class requestedClass = classService.findById(classId);
		newsubject.setClasses(requestedClass);
		newsubject.setCls(requestedClass);
		requestedClass.addSubject(newsubject);
		subjectRepository.save(newsubject);
		return (newsubject);
	}


	@Override
	public Subject fromSubjectId(Integer subjectId) {
	return	subjectRepository.findBySubjectId(subjectId);
	 
		
	}


	@Override
	public boolean savesubject(Subject subjectFromDatabase) {
		try {
			subjectRepository.save(subjectFromDatabase);
			return true;
		}catch(Exception e) {
		return false;
	}
		
	
	}


	@Override
	public Subject findById(int subjectId) {
		
		return subjectRepository.findBySubjectId(subjectId);
	}


	@Override
	public void deleteSubject(Subject subjectFromId) {
		subjectFromId.setStatus(StatusClass.DELETED);
		this.savesubject(subjectFromId);
		
	}


	@Override
	public List<Subject> findAll() {
		return subjectRepository.findByStatusIsNot(StatusSubject.DELETED);
	
	
	}



	

}
