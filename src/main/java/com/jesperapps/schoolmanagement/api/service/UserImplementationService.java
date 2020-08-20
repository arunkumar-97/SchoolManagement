package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jesperapps.schoolmanagement.api.message.Attachment;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
import com.jesperapps.schoolmanagement.api.message.UserTypeRequest;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
//import com.jesperapps.schoolmanagement.api.model.UserType;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;
import com.jesperapps.schoolmanagement.api.repository.UserTypeRepository;

@Service
public class UserImplementationService implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;

	@Autowired
	private EmailSenderService emailService;
	
	@Autowired
	private UserProfilePictureService userProfilePictureService;

	@Override
	public List<User> addadmin(List<UserRequestWithProfilePicture> user){
		List<User> newUsersList = new ArrayList<>();
		for( UserRequestWithProfilePicture eachuser:user) {
			User newUser = new User(eachuser);
			newUser.setPassword(this.createsafepassword(eachuser.getPassword()));
			if(eachuser.getUserType() != null) {
				UserTypeRequest requestUserType = eachuser.getUserType();
				if(requestUserType.getUserTypeId() != null) {
					newUser.setUserType(userTypeRepository.findByUserTypeId(requestUserType.getUserTypeId()));
				}else if(requestUserType.getUserTypeRole() != null) {
					newUser.setUserType(userTypeRepository.findByUserTypeRole(requestUserType.getUserTypeRole()));
				}else {
					newUser.setUserType(userTypeRepository.findByUserTypeId(1));
				}
			}
			emailService.sendOTPMail(newUser);
			//save profilePIcuter
			try {
				Attachment profileAttachment = eachuser.getAttachment();
				UserProfilePicture profilePicture = userProfilePictureService.saveFile(profileAttachment);
				profilePicture.setUser(newUser);
				newUser.setUserProfile(profilePicture);
			}
			catch(Exception e) {
		System.out.println(e);
			}
			newUsersList.add(newUser);
			userRepository.save(newUser);
		}
		
		return newUsersList;
	}

	private String createsafepassword(String unsafepassword) {
		
		return BCrypt.hashpw(unsafepassword, BCrypt.gensalt()) ;
	}

	public boolean checkPasswordIsSame(String unsafepassword,String hashpassword) {
		return BCrypt.checkpw(unsafepassword, hashpassword);
		
	}

	@Override
	public User findByEmail(String geteMail) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(geteMail);
	}

	
	@Override
	public List<OtpResponse> validateOTP(List<OtpRequest> emailOtpRequest) {
		List<OtpResponse> responseList = new ArrayList<>();
		
		for(OtpRequest request : emailOtpRequest) {
			OtpResponse response = new OtpResponse(400, "Bad request");
			User requestUser = this.findByEmail(request.getEmail());
			if(requestUser != null) {
				if(emailService.checkOTP(requestUser, request.getOtp())) {
					response.setStatuscode(200);
					response.setDescription("Otp Matched");
				}else {
					response.setStatuscode(400);
					response.setDescription("Otp Mismatch");
				} 
			}else {
				response.setStatuscode(409);
				response.setDescription("No user found");
			}
			responseList.add(response);
		}
		
		return responseList;
	}

	@Override
	public User findById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(userId);
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
 	}


	
	
	
	

}
