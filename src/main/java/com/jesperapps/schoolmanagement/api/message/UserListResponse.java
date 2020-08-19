package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

public class UserListResponse extends BaseResponse {
	
	public UserListResponse() {
		super();
	}
	
	public UserListResponse(int statusCode,String description) {
		super();
		users= new ArrayList<UserResponse>();
	}
	private List<UserResponse> users;
	
	public List<UserResponse> getUsers() {
		return users;
	}

	public void setUsers(List<UserResponse> users) {
		this.users = users;
	}

	public void addusers(UserResponse userListResponse) {
		this.users.add(userListResponse);
		
	}

	

}
