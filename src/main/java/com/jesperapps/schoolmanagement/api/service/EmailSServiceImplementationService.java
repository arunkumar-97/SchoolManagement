package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.ConfirmationToken;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.repository.ConfirmationTokenRepository;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;

@Service
public class EmailSServiceImplementationService implements EmailSenderService {
	
	
	@SuppressWarnings("unused")
	private JavaMailSender javaMailSender;
	private final Integer OTP_LENGTH = 6;
//	private final String FROM_ADDRESS = "arun.thril@gmail.com";
	private final String FROM_ADDRESS = "rose.pauline@jespersoft.com";
	
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("unused")
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
//			SimpleMailMessage otpMail = new SimpleMailMessage();
//			otpMail.setTo(otpUser.getEmail());
//			ConfirmationToken oneTimePassword = this.getConfirmationTokenForUser(otpUser);
//			otpMail.setFrom(FROM_ADDRESS);
//			otpMail.setText("Hi "+otpUser.getUserName()+", The One Time Password for your login request is "+oneTimePassword.getConfirmationToken());
//			this.javaMailSender.send(otpMail);
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "mail.jespersoft.com");
			props.put("mail.smtp.port", "25");

			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(FROM_ADDRESS, "Jesper$2020");
				}
			};
			Session session = Session.getInstance(props, auth);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM_ADDRESS, false));
			List<InternetAddress> list = new ArrayList<InternetAddress>();
			
				InternetAddress to1 = new InternetAddress(otpUser.getEmail());
				msg.setRecipient(Message.RecipientType.TO, to1);
				list.add(to1);
			
			Address[] addressTo = list.toArray(new Address[] {});
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			ConfirmationToken oneTimePassword = this.getConfirmationTokenForUser(otpUser);

			msg.setSubject("OTP FOR LOGIN");
			msg.setText("Hi "+otpUser.getUserName()+","
					
					+ " Use OTP "+oneTimePassword.getConfirmationToken() + " to login to your Educatizzy Account.Educatizzy doesn't ask for OTP or Contact number to be shared with anyone including Educatizzy Personnel");
			
			
			msg.setSentDate(new Date());
//			List<InternetAddress> listOfToAddress = new ArrayList<InternetAddress>();
//			for (String cc : emailReqEntity2.getCc()) {
//				InternetAddress cc1 = new InternetAddress(cc);
//				msg.setRecipient(Message.RecipientType.CC, cc1);
//				listOfToAddress.add(cc1);
//			}
//			Address[] address = listOfToAddress.toArray(new Address[] {});
//
//			msg.setRecipients(Message.RecipientType.CC, address);		
			msg.saveChanges();
			Transport.send(msg);
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
