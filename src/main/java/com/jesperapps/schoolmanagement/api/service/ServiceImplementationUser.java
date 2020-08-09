package com.jesperapps.schoolmanagement.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserType;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;
import com.jesperapps.schoolmanagement.api.repository.UserTypeRepository;

@Service
public class ServiceImplementationUser implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;

	@Autowired
	private EmailSenderService emailService;
	
	@Autowired
	private UserProfilePictureService userProfilePictureService;

	@Override
	public void addadmin(MultipartFile[] profilePictureList,List<User> admin){
		int index=0;
		for( User eachadmin:admin) {
			eachadmin.setPassword(this.createsafepassword(eachadmin.getPassword()));
			if(eachadmin.getUserType() != null) {
				UserType requestUserType = eachadmin.getUserType();
				if(requestUserType.getUserTypeId() != null) {
					eachadmin.setUserType(userTypeRepository.findByUserTypeId(requestUserType.getUserTypeId()));
				}else if(requestUserType.getUserTypeRole() != null) {
					eachadmin.setUserType(userTypeRepository.findByUserTypeRole(requestUserType.getUserTypeRole()));
				}else {
					eachadmin.setUserType(userTypeRepository.findByUserTypeId(1));
				}
			}
			emailService.sendOTPMail(eachadmin);
			//save profilePIcuter
			if(index < profilePictureList.length){
				UserProfilePicture profilePicture = userProfilePictureService.saveFile(profilePictureList.[index]);
				profilePicture.setUser(eachadmin);
				eachadmin.setUserProfile(profilePicture);
			}
			index++;
		}
		
		 userRepository.saveAll(admin);

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


	
	
	
	

}
