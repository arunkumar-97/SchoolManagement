package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer>{

	public ConfirmationToken findByConfirmationToken(String confirmationToken);
	
}
