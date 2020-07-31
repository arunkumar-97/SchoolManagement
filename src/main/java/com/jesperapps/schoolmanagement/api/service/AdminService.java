package com.jesperapps.schoolmanagement.api.service;

import java.util.List;


import com.jesperapps.schoolmanagement.api.model.User;

public interface AdminService {

	void addadmin(List<User> admin);

	User findByeMail(String geteMail);

	User getAdminByeMail(String geteMail);

	boolean checkPasswordIsSame(String password, String password2);

}
