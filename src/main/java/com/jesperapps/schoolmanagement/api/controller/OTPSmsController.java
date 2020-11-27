package com.jesperapps.schoolmanagement.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.api.model.OtpSms;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.service.OtpService;
import com.jesperapps.schoolmanagement.api.service.UserImplementationService;
import com.jesperapps.schoolmanagement.api.service.UserService;

@RestController
public class OTPSmsController {
	
	@Autowired
	private UserService userRegistrationService;
	
	@Autowired
	private OtpService otpSmsService;

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@GetMapping("/generate_otp/{phone}")
	public ResponseEntity sendSMS(@PathVariable("phone") Long phone) {
		System.out.println("phoneNumber" + phone);
		// for(String phone : otpSmsRequestEntity.getPhoneNumber()) {
		// System.out.println("phones"+phone);
		Optional<User> phoneNumber = userRegistrationService.findByPhoneNumber(phone);
		System.out.println("phoneNumbers" + phoneNumber);
		if (phoneNumber.isPresent()) {
			System.out.println("phone present");
				List<OtpSms> otpSms = otpSmsService.findAll();
				if (otpSms.isEmpty()) {
					System.out.println("otp empty");
					int otp = otpSmsService.generateOTP(phoneNumber.get().getPhoneNumber());
					if (otp == 0) {
//						ObjectNode jsonObject = objectMapper.createObjectNode();
//						jsonObject.put("statusCode", res.FAILURE);
//						jsonObject.put("message", res.setDescription("unable to generate otp"));
//						return new ResponseEntity(jsonObject, HttpStatus.BAD_REQUEST);
					} else {

						try {
//							System.out.println("try");
//							Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//							Message message = Message.creator(new com.twilio.type.PhoneNumber(phone),
//									new com.twilio.type.PhoneNumber(TWILIO_NUMBER), "Your One Time Password(OTP) is " + otp)
//									.create();
							UserImplementationService.sendSms("Your One Time Password(OTP) is " + otp , phone);
//							UserResponseEntity userResponseEntity = new UserResponseEntity(phoneNumber.get().getCity(), phoneNumber.get());
//							userResponseEntity.setStatusCode(res.SUCCESS);
//							userResponseEntity.setDescription("Otp sent successfully ");
//							return new ResponseEntity(userResponseEntity, HttpStatus.OK);

						} catch (Exception e) {
//							System.out.println("e" + e);
//							ObjectNode jsonObject = objectMapper.createObjectNode();
//							jsonObject.put("statusCode", res.FAILURE);
//							jsonObject.put("message", res.setDescription("unable to send otp"));
//							return new ResponseEntity(jsonObject, HttpStatus.BAD_REQUEST);
						}

					}
				} else {
					System.out.println("else otp empty");
					otpSmsService.clearOTP(phone);
					int otp = otpSmsService.generateOTP(phoneNumber.get().getPhoneNumber());
					if (otp == 0) {
//						ObjectNode jsonObject = objectMapper.createObjectNode();
//						jsonObject.put("statusCode", res.FAILURE);
//						jsonObject.put("message", res.setDescription("unable to generate otp"));
//						return new ResponseEntity(jsonObject, HttpStatus.BAD_REQUEST);
					} else {
						System.out.println("eellssee");

						try {
//							System.out.println("try");
//							Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//							Message message = Message.creator(new com.twilio.type.PhoneNumber(phone),
//									new com.twilio.type.PhoneNumber(TWILIO_NUMBER), "Your One Time Password(OTP) is " + otp)
//									.create();
							UserImplementationService.sendSms("Your One Time Password(OTP) is " + otp , phone);
//							UserResponseEntity userResponseEntity = new UserResponseEntity(phoneNumber.get().getCity(), phoneNumber.get());
//							userResponseEntity.setStatusCode(res.SUCCESS);
//							userResponseEntity.setDescription("Otp sent successfully ");
//							return new ResponseEntity(userResponseEntity, HttpStatus.OK);

						} catch (Exception e) {
//							System.out.println("ex" + e);
//							ObjectNode jsonObject = objectMapper.createObjectNode();
//							jsonObject.put("statusCode", res.FAILURE);
//							jsonObject.put("message", res.setDescription("unable to send otp"));
//							return new ResponseEntity(jsonObject, HttpStatus.BAD_REQUEST);
						}

					}
				}
			

		} else {
//			ObjectNode jsonObject = objectMapper.createObjectNode();
//			jsonObject.put("statusCode", res.FAILURE);
//			jsonObject.put("message", res.setDescription(phone + " not registered"));
//			return new ResponseEntity(jsonObject, HttpStatus.BAD_REQUEST);
		}
		// }
		return null;

		/*
		 * For call Call call = Call.creator( new
		 * com.twilio.type.PhoneNumber("+917598193103"), new
		 * com.twilio.type.PhoneNumber("+15176804129"),
		 * URI.create("http://demo.twilio.com/docs/voice.xml")) .create();
		 */
	}

}
