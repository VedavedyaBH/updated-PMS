package com.hexaware.policymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.policymanagementsystem.entity.Policy;
import com.hexaware.policymanagementsystem.exception.ResourceNotFoundException;

public interface PolicyService {
	
	public List<Policy> findAllPolicy() ;
	public Optional<Policy> findPolicyById(Long policyId);
	public void deletePolicyById(Long policyId) ;
	public Policy savePolicy(Policy policy);
	public Policy updatePolicyById(Policy existingPolicy,Long policyId) throws ResourceNotFoundException;
}
