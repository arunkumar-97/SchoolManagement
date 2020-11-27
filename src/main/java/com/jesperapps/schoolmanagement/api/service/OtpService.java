package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.model.OtpSms;

public interface OtpService {

	int generateOTP(Long phoneNumber);

	OtpSms clearOTP(Long phone);

	List<OtpSms> findAllByPhoneNumber(Long phone);

	List<OtpSms> findAll();

}
