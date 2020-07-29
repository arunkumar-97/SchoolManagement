package com.jesperapps.schoolmanagement.api.service;

import java.util.List;

import com.jesperapps.schoolmanagement.api.message.AdminResponse;
import com.jesperapps.schoolmanagement.api.model.Admin;

public interface AdminService {

	void addadmin(List<Admin> admin);

	Admin findByeMail(String geteMail);

	Admin getAdminByeMail(String geteMail);

	boolean checkPasswordIsSame(String password, String password2);

}
