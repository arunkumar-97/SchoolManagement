package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;
import com.jesperapps.schoolmanagement.api.model.User;

public interface SubscriptionFormRepository extends JpaRepository<SubscriptionForm, Integer>{

	SubscriptionForm findBySubscriptionId(int subscriptionId);
						
	List<SubscriptionForm> findAll();

	List<SubscriptionForm> findBySubscriptionClass(Class cls);

	List<SubscriptionForm> findByUser(User userFromDb);
	
	

	

}
