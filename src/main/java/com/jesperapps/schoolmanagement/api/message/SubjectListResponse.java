package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

public class SubjectListResponse  {
	
	private List<SubjectResponse> subjects;
	
	public SubjectListResponse() {
		super();
		subjects = new ArrayList<SubjectResponse>();
	}

	public List<SubjectResponse> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectResponse> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(SubjectResponse newSubject) {
		this.subjects.add(newSubject);
	}
}
