package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.message.UserListResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequest;
import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.User;

public interface UserService {

	List<User> addadmin(MultipartFile[] profilePictureList,List<UserRequest> admin);

	User findByEmail(String geteMail);

	boolean checkPasswordIsSame(String password, String password2);
	
	List<OtpResponse> validateOTP(List<OtpRequest> emailOtpRequest);

	User findById(int userId);
	
	List<User> findAll();

}
