package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.api.model.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Integer>{
	public UserType findByUserTypeId(Integer userTypeId);
	
	public UserType findByUserTypeRole(String userTypeRole);
	
	public List<UserType> findAll();
}
