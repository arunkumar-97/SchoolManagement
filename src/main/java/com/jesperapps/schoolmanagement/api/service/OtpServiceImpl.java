package com.jesperapps.schoolmanagement.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.api.model.OtpSms;
import com.jesperapps.schoolmanagement.api.repository.OtpSmsRepository;

@Service
public class OtpServiceImpl implements OtpService {
	
	@Autowired
	private OtpSmsRepository otpSmsRepository;
	
	private static final Integer EXPIRE_MINS = 3;

	@Override
	public int generateOTP(Long phoneNumber) {
		try {
			Random random = new Random();
			int otp = 100000 + random.nextInt(900000);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String otpGenerationTime = dtf.format(now);
			OtpSms otpSms = new OtpSms(phoneNumber, otp, EXPIRE_MINS, otpGenerationTime);
			OtpSms otpSmsSaved = otpSmsRepository.save(otpSms);
			return otp;
		} catch (Exception e) {
			return 0;
		}

	}

}
