package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

public class ClassListResponse {
	
	public ClassListResponse() {
	}
	
	private List<ClassResponse> classes;
	

	public List<ClassResponse> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassResponse> classes) {
		this.classes = classes;
	}

	public void addclss(ClassResponse classListResponse) {
		if(this.classes == null) {
			this.classes = new ArrayList<>();
		}
		this.classes.add(classListResponse);
		
	}




}
