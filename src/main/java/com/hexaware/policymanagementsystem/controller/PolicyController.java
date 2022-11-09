package com.hexaware.policymanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.policymanagementsystem.entity.Policy;
import com.hexaware.policymanagementsystem.service.PolicyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping("/pmspolicy")
public class PolicyController {
	@Autowired
	private PolicyService pServices;
	
	
	@GetMapping("/listpolicies")
	@ApiOperation(value = "to view all policies",response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Succesfully retrived all policies"),
			@ApiResponse(code = 401, message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	 List<Policy> findAllPolicy() {
		return pServices.findAllPolicy();
	}
	
	@GetMapping("/findbypolicyId/{policyId}")
	@ApiOperation(value = "Get a policy by id")
	 Optional<Policy> getPolicyById(
			 @ApiParam(value = "returns the policy with id",required = true)
			 @PathVariable("policyId")Long policyId
			){
       return pServices.findPolicyById(policyId);
	}
	
	@DeleteMapping("/deletepolicyId/{policy_id}")
	@ApiOperation(value = "deletes policy...")
	 void deletePolicyById(
			@PathVariable("policy_id") Long policyId) {
		pServices.deletePolicyById(policyId);

	}
	
	@PostMapping("/savepolicy")
	@ApiOperation(value ="add a policy")
	 Policy savePolicy(
			@ApiParam(value ="policy is stored in database",required = true)
			@RequestBody Policy policy) {
		return pServices.savePolicy(policy);
	}
	
	@PutMapping("/updatepolicy/{policy_id}")
	@ApiOperation(value="Policy to update..")
	 Policy updatePolicy(
			 @ApiParam(value = "Policy to update" , required = true)
			 @Valid@RequestBody Policy policy,
			 @PathVariable("policy_id") Long policyId) throws Exception {
		Policy existingPolicy = pServices.findPolicyById(policyId)
				.orElseThrow(()-> new Exception("policy not found with id" + policyId));
		existingPolicy.setPolicyName(policy.getPolicyName());
		existingPolicy.setPolicyType(policy.getPolicyType());
		existingPolicy.setTermAccount(policy.getTermAccount());
		existingPolicy.setStartDate(policy.getStartDate());
		existingPolicy.setCompanyName(policy.getCompanyName());
		existingPolicy.setDuration(policy.getDuration());
		existingPolicy.setIntialDeposit(policy.getIntialDeposit());
		existingPolicy.setUserType(policy.getUserType());
		
		return pServices.updatePolicyById(existingPolicy, policyId);
	};
	

}
