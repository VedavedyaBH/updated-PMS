package com.hexaware.policymanagementsystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "policy")

public class Policy {
	
		
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "policy_id")
		private Long  policyId;
		@Column(name = "policy_name")

		private String policyName ;
		@Column(name = "policy_type")

		private String policyType ;
		@Column(name = "term_account")

		private String termAccount ;
		@Column(name = "start_date")

		private LocalDate startDate ;
		@Column(name = "company_name")

		private String companyName; 
		@Column(name = "duration")

		private int duration ;
		@Column(name = "intial_deposit")
	
		private int intialDeposit; 
		@Column(name = "user_type")
		private char userType;
		
		
		
		
		public Long getPolicyId() {
			return policyId;
		}
		public void setPolicyId(Long policyId) {
			this.policyId = policyId;
		}
		public String getPolicyName() {
			return policyName;
		}
		public void setPolicyName(String policyName) {
			this.policyName = policyName;
		}
		public String getPolicyType() {
			return policyType;
		}
		public void setPolicyType(String policyType) {
			this.policyType = policyType;
		}
		public String getTermAccount() {
			return termAccount;
		}
		public void setTermAccount(String termAccount) {
			this.termAccount = termAccount;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public int getIntialDeposit() {
			return intialDeposit;
		}
		public void setIntialDeposit(int intialDeposit) {
			this.intialDeposit = intialDeposit;
		}
		public char getUserType() {
			return userType;
		}
		public void setUserType(char userType) {
			this.userType = userType;
		}
		public Policy() {
		}
		public Policy(Long policyId, String policyName, String policyType, String termAccount, LocalDate startDate,
				String companyName, int duration, int intialDeposit, char userType, Admin admin) {
			super();
			this.policyId = policyId;
			this.policyName = policyName;
			this.policyType = policyType;
			this.termAccount = termAccount;
			this.startDate = startDate;
			this.companyName = companyName;
			this.duration = duration;
			this.intialDeposit = intialDeposit;
			this.userType = userType;
			
		}
			
	

}
