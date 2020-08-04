package com.jesperapps.schoolmanagement.api.service;

import com.jesperapps.schoolmanagement.api.model.ConfirmationToken;
import com.jesperapps.schoolmanagement.api.model.User;

public interface EmailSenderService {
	
	public ConfirmationToken getConfirmationTokenForUser(User user);
	
	public boolean sendOTPMail(User otpUsers);
	
	public boolean checkOTP(User user, String requestOTP);
}
