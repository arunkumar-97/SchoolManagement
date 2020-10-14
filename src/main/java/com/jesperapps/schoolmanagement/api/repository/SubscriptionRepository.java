package com.jesperapps.schoolmanagement.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jesperapps.schoolmanagement.api.model.SubscriptionForm;

public interface SubscriptionRepository extends JpaRepository<SubscriptionForm, Integer>{

	SubscriptionForm findBySubscriptionId(int subscriptionId);

//	  save(SubscriptionForm responseForm);

}
