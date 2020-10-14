package com.jesperapps.schoolmanagement.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.api.model.SubscriptionStatus;

public interface SubscriptionStatusRepository extends CrudRepository<SubscriptionStatus, Integer>{
	public SubscriptionStatus findByStatus(String status);
	
	public SubscriptionStatus findBySubscriptionStatusId(Integer id);
	
	public List<SubscriptionStatus> findAll();
}
