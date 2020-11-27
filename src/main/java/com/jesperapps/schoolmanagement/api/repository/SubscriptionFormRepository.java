package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jesperapps.schoolmanagement.api.model.Class;
import com.jesperapps.schoolmanagement.api.model.ClassSubscription;
import com.jesperapps.schoolmanagement.api.model.User;

public interface SubscriptionFormRepository extends JpaRepository<ClassSubscription, Integer>{

	ClassSubscription findBySubscriptionId(int subscriptionId);
						
	List<ClassSubscription> findAll();

	List<ClassSubscription> findBySubscriptionClass(Class cls);

	List<ClassSubscription> findByUser(User userFromDb);

	List<ClassSubscription> findAllBySubscriptionClass_classIdAndUser_userId(int ClassID , int UserID);
	
	

	

}
