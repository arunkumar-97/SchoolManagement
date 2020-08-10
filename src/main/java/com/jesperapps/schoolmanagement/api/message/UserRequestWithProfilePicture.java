package com.jesperapps.schoolmanagement.api.message;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserRequestWithProfilePicture {
	private MultipartFile[] profilePicture;
	private String users;

	
	public MultipartFile[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(MultipartFile[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public void setUsers(String users) {
		this.users = users;
	}

	public List<UserRequest> getUsers() {
		try {
			ObjectMapper jsonConverter = new ObjectMapper();
			JsonNode jsonData =  jsonConverter.readTree(this.users);
			UserRequest[] arrayOfUserRequest = jsonConverter.convertValue(jsonData, UserRequest[].class);
			return Arrays.asList(arrayOfUserRequest);
		}catch(Exception e) {
			return null;
		}
	}
	
}
