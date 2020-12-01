package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import java.util.Optional;

import com.jesperapps.schoolmanagement.api.model.OtpSms;

public interface OtpService {

	int generateOTP(Long phoneNumber);

	OtpSms clearOTP(Long phone);

	List<OtpSms> findAllByPhoneNumber(Long phone);

	List<OtpSms> findAll();

	Optional<OtpSms> getOtp(Long phoneNumber);

	Optional<OtpSms> findByPhoneNumber(Long phoneNumber);

	

}
