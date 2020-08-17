package com.jesperapps.schoolmanagement.api.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.ConfirmationToken;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.repository.ConfirmationTokenRepository;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;

@Service
public class EmailSServiceImplementationService implements EmailSenderService {
	
	
	private JavaMailSender javaMailSender;
	private final Integer OTP_LENGTH = 6;
	private final String FROM_ADDRESS = "arun.thril@gmail.com";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	

	

	public EmailSServiceImplementationService() {
		
	}

	@Autowired
	public EmailSServiceImplementationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	private String generateRandomOTP() {
		String oneTimePassword = "";
		Random randomGenerator = new Random();
		for(int i=0;i<OTP_LENGTH;i++) {
			oneTimePassword += randomGenerator.nextInt(10);
		}
		return oneTimePassword;
	}

	@Override
	public ConfirmationToken getConfirmationTokenForUser(User user) {
		// TODO Auto-generated method stub
		String newOtp = this.generateRandomOTP();
		ConfirmationToken newToken = user.getOtpToken() != null ? user.getOtpToken() : new ConfirmationToken(newOtp, user);
		newToken.setConfirmationToken(newOtp);
		user.setOtpToken(newToken);
		userRepository.save(user);
		return newToken;
	}
	
	@Override
	public boolean checkOTP(User user, String requestOTP) {
		if(user.getOtpToken() != null) {
			if(user.getOtpToken().getConfirmationToken().equals(requestOTP)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean sendOTPMail(User otpUser) {
		// 		TODO Auto-generated method stub
		try {
			SimpleMailMessage otpMail = new SimpleMailMessage();
			otpMail.setTo(otpUser.getEmail());
			ConfirmationToken oneTimePassword = this.getConfirmationTokenForUser(otpUser);
			otpMail.setFrom(FROM_ADDRESS);
			otpMail.setText("Hi "+otpUser.getUserName()+", The One Time Password for your login request is "+oneTimePassword.getConfirmationToken());
			this.javaMailSender.send(otpMail);
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
