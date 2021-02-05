package com.jesperapps.schoolmanagement.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jesperapps.schoolmanagement.api.message.OtpRequest;
import com.jesperapps.schoolmanagement.api.message.OtpResponse;
import com.jesperapps.schoolmanagement.api.message.UserRequestWithProfilePicture;
import com.jesperapps.schoolmanagement.api.message.UserResponse;
import com.jesperapps.schoolmanagement.api.message.UserTypeRequest;
import com.jesperapps.schoolmanagement.api.model.Attachment;
import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserProfilePicture;
import com.jesperapps.schoolmanagement.api.repository.UserRepository;
import com.jesperapps.schoolmanagement.api.repository.UserTypeRepository;

@Service
public class UserImplementationService implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Autowired
	private OtpService otpService;

	@Autowired
	private EmailSenderService emailService;
	
	@Autowired
	private UserProfilePictureService userProfilePictureService;

	public UserResponse addadmin( UserRequestWithProfilePicture user){
		User userWithSameEmailId = userRepository.findByEmail(user.getEmail());
		
		if(userWithSameEmailId == null) {
		Optional<User>	userWithPhNum=userRepository.findByPhoneNumber(user.getPhoneNumber());
			if(!userWithPhNum.isPresent()) {
				User newUsersList = new User();

			newUsersList.setUserName(user.getUserName());
			newUsersList.setEmail(user.getEmail());
			newUsersList.setPhoneNumber(user.getPhoneNumber());
			newUsersList.setAuthentication(user.getAuthenticationType());

				newUsersList.setPassword(this.createsafepassword(user.getPassword()));
				if(user.getUserType() != null) {
					UserTypeRequest requestUserType = user.getUserType();
					if(requestUserType.getUserTypeId() != null) {
						newUsersList.setUserType(userTypeRepository.findByUserTypeId(requestUserType.getUserTypeId()));
					}else if(requestUserType.getUserTypeRole() != null) {
						newUsersList.setUserType(userTypeRepository.findByUserTypeRole(requestUserType.getUserTypeRole()));
					}else {
						newUsersList.setUserType(userTypeRepository.findByUserTypeId(1));
					}
				}
				//save profilePIcutre
				try {
					
					int otp = otpService.generateOTP(user.getPhoneNumber());
					if(otp == 0) {
					}else {
						if(user.getAuthenticationType().equalsIgnoreCase("sms")) {
							sendSms("Your One Time Password(OTP) is " + otp , user.getPhoneNumber());

						}else if(user.getAuthenticationType().equalsIgnoreCase("Email")){
							emailService.sendOTPMail(newUsersList);

						}
					}
					Attachment profileAttachment = user.getAttachment();
					if(profileAttachment != null) {
					UserProfilePicture profilePicture = userProfilePictureService.saveFile(profileAttachment);
					profilePicture.setUser(newUsersList);
					newUsersList.setUserProfile(profilePicture);
					
					userRepository.save(newUsersList);
					
					}else {
						userRepository.save(newUsersList);
					}
				}
				catch(Exception e) {
						System.out.println(e);
				return new UserResponse();
				}
//				newUsersList.add();

			UserResponse res=new UserResponse(newUsersList);	
			res.setStatusCode(200);
			res.setDescription("Registered Successfully");
			return res;
			}else {
			UserResponse response=new UserResponse(409,"Phone Number Already Exists");
					
			return response;
		}
		}
		UserResponse response=new UserResponse(409,"Email Already Exists");
		return response;
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
					User user=this.findByEmail(requestUser.getEmail());
					user.setVerificationStatus(1);
					userRepository.save(user);
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


	
	public static void sendSms(String message, Long long1) {

		try {

			String apiKey = "elNIWdPL4TVuhKAGt7BnjMoEw9ZFyYU6cXx5kg2J8zHaiOs01Dn50wUgxpFkDubhRT9Ba87Ny6vlMtWr";
			String sendId = "FSTSMS";
			// important step...
			message = URLEncoder.encode(message, "UTF-8");
			String language = "english";

			String route = "t";

			String myUrl = "https://www.fast2sms.com/dev/bulk?authorization=" + apiKey + "&sender_id=" + sendId
					+ "&message=" + message + "&language=" + language + "&route=" + route + "&numbers=" + long1;

			// sending get request using java..

			URL url = new URL(myUrl);

			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			con.setRequestMethod("GET");

			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			System.out.println("Wait..............");

			int code = con.getResponseCode();

			System.out.println("Response code : " + code);

			StringBuffer response = new StringBuffer();

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				response.append(line);
			}

			System.out.println(response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}






	@Override
	public Optional<User> findByPhoneNumber(Long phone) {
		// TODO Auto-generated method stub
		return userRepository.findByPhoneNumber(phone);
	}






	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}






	@Override
	public User findByEmailAndPassword(String email, String password) {
		
		return userRepository.findByEmailAndPassword(email,password);
	}
	
	


}
