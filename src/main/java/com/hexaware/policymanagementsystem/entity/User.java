package com.hexaware.policymanagementsystem.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	
	@Column(name = "pan")
	private String pan; 
	@Id
	@Column(name = "userid")
	private Long userId;
	
	@Column(name = "fName")
	private String fName ;
	
	@Column(name = "lname")
	private String lName ;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "email")
	private String email ;
	
	@Column(name = "dob")
	private LocalDate dob; 
	
	@Column(name = "pNumber")
	private int pNumber ;
	
	@Column(name = "salary")
	private int salary ;
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(Long userId, String pan, String fName, String lName, String userName, String email, LocalDate dob,
			int pNumber, int salary) {
		super();
		this.userId = userId;
		this.pan = pan;
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.email = email;
		this.dob = dob;
		this.pNumber = pNumber;
		this.salary = salary;
	}
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressid_fk")
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn (name = "userid_fk", referencedColumnName = "userid")
	
	private List<Policy > policyList = new ArrayList <>(); 

	public List<Policy> getPolicyList() {
		return policyList;
	}


	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}




	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getpNumber() {
		return pNumber;
	}
	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	
	}


