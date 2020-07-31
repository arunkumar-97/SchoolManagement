package com.jesperapps.schoolmanagement.api.service;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.jesperapps.schoolmanagement.api.model.User;
import com.jesperapps.schoolmanagement.api.repository.AdminRepository;

@Service
public class AdminImplementationClass implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public void addadmin(List<User> admin){
		for( User eachadmin:admin) {
			eachadmin.setPassword(this.createsafepassword(eachadmin.getPassword()));
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
	public User findByeMail(String geteMail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getAdminByeMail(String geteMail) {
		
		return adminRepository.findByeMail(geteMail);
	}

	
	
	
	

}
