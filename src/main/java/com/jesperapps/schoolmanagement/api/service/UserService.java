package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.model.User;

public interface UserService {

	void addadmin(MultipartFile[] profilePictureList,List<User> admin);

	User findByEmail(String geteMail);

	boolean checkPasswordIsSame(String password, String password2);
	
	List<OtpResponse> validateOTP(List<OtpRequest> emailOtpRequest);

}
