package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

public class ClassListResponse extends BaseResponse{
	
	public ClassListResponse(int statusCode,String description) {
		super();
		classes= new ArrayList<ClassResponse>();
	}
	
	private List<ClassResponse> classes;
	

	public List<ClassResponse> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassResponse> classes) {
		this.classes = classes;
	}

	public void addclss(ClassResponse classListResponse) {
		this.classes.add(classListResponse);
		
	}




}
