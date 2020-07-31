package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.model.UserType;
import com.jesperapps.schoolmanagement.api.repository.AdminRepository;
import com.jesperapps.schoolmanagement.api.repository.UserTypeRepository;

@Service
public class AdminImplementationClass implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserTypeRepository userTypeRepository;

	@Override
	public void addadmin(List<User> admin){
		for( User eachadmin:admin) {
			eachadmin.setPassword(this.createsafepassword(eachadmin.getPassword()));
			if(eachadmin.getUserType() != null) {
				UserType requestUserType = eachadmin.getUserType();
				if(requestUserType.getUserTypeRole() != null) {
					eachadmin.setUserType(userTypeRepository.findByUserTypeId(requestUserType.getUserTypeId()));
				}else {
					eachadmin.setUserType(userTypeRepository.findByUserTypeRole(requestUserType.getUserTypeRole()));
				}
			}else {
				eachadmin.setUserType(userTypeRepository.findByUserTypeId(1));
			}
		}
		
		 adminRepository.saveAll(admin);

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
		return null;
	}


	
	
	
	

}
