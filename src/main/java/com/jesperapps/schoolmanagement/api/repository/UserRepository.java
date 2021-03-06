package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.School;
import com.jesperapps.schoolmanagement.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> save(List<User> admin);

	User findByEmail(String geteMail);
	
	User findByUserId(Integer userId);

	Optional<User> findByPhoneNumber(Long phone);

	User findByEmailAndPassword(String email, String password);

	Iterable<User> findBySchool(School schoolFromDb);

	

}
