package com.jesperapps.schoolmanagement.api.message;

public class UserBaseResponse extends BaseResponse {
	
	private UserResponse users;
	
	
	public UserBaseResponse(int statuscode,String description) {
		this.statuscode=statuscode;
		this.description=description;
		
	}

	public UserBaseResponse() {
		
	}

	public UserResponse getUsers() {
		return users;
	}

	public void setUsers(UserResponse users) {
		this.users = users;
	}
	
	
	

}
