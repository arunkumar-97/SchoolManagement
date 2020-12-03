package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import java.util.Optional;

import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
//import com.jesperapps.schoolmanagement.api.message.UserListResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
//import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.User;

public interface UserService {

	UserResponse addadmin(UserRequestWithProfilePicture user);

	User findByEmail(String geteMail);

	boolean checkPasswordIsSame(String password, String password2);
	
	List<OtpResponse> validateOTP(List<OtpRequest> emailOtpRequest);

	User findById(int userId);
	
	List<User> findAll();

	Optional<User> findByPhoneNumber(Long phone);

	User save(User user);

	User findByEmailAndPassword(String email, String password);

}
