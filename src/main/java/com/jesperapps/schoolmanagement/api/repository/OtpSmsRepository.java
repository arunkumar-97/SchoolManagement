package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.OtpSms;

public interface OtpSmsRepository extends JpaRepository<OtpSms, Long> {

	OtpSms deleteByPhoneNumber(Long phone);

	List<OtpSms> findAllByPhoneNumber(Long phone);

	Optional<OtpSms> findByPhoneNumber(Long phoneNumber);

}
