package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	List<Admin> save(List<Admin> admin);

	Admin findByeMail(String geteMail);

}
