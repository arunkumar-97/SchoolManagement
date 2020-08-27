package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

public class UserListResponse {
	
	public UserListResponse() {
		super();
	}
	
	public UserListResponse(int statusCode,String description) {
		super();
	}
	private List<UserResponse> users;
	
	public List<UserResponse> getUsers() {
		return users;
	}

	public void setUsers(List<UserResponse> users) {
		this.users = users;
	}

	public void addusers(UserResponse userListResponse) {
		if(users == null) {
			users= new ArrayList<UserResponse>();
		}
		this.users.add(userListResponse);
		
	}

	

}
