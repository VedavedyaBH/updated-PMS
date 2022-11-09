package com.hexaware.policymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.policymanagementsystem.entity.Policy;
import com.hexaware.policymanagementsystem.exception.ResourceNotFoundException;
import com.hexaware.policymanagementsystem.repository.PolicyRepository;
@Service
public class PolicyServiceImpl implements PolicyService{
	@Autowired
	
	private PolicyRepository policyRepo;

	@Override
	public List<Policy> findAllPolicy() {
		return policyRepo.findAll();
	}

	

	@Override
	public void deletePolicyById(Long policyId) {
		policyRepo.deleteById(policyId);		
		
	}

	@Override
	public Policy savePolicy(Policy policy) {
		return policyRepo.save(policy);
	}

	@Override
	public Policy updatePolicyById(Policy policy, Long policyId)throws ResourceNotFoundException {
		Policy olddetails = findPolicyById(policyId).orElseThrow(()-> new ResourceNotFoundException("Policy"));
		olddetails.setPolicyName(policy.getPolicyName());
		return policyRepo.save(olddetails);
	}

	@Override
	public Optional<Policy> findPolicyById(Long policyId) {
		// TODO Auto-generated method stub
		return policyRepo.findById(policyId);
	}

	
	

}
