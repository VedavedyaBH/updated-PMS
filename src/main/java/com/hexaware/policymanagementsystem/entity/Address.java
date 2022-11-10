package com.hexaware.policymanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
		public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



		public Address(Long addressId, String state, String city) {
		super();
		this.addressId = addressId;
		this.state = state;
		this.city = city;
	}



		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="address_Id")
		private Long  addressId ;
		
		
		
		
		
		public Long getAddressId() {
			return addressId;
		}



		public void setAddressId(Long addressId) {
			this.addressId = addressId;
		}



		public String getState() {
			return state;
		}



		public void setState(String state) {
			this.state = state;
		}



		public String getCity() {
			return city;
		}



		public void setCity(String city) {
			this.city = city;
		}



		@Column(name="state")
		private String state;
		
		@Column(name="city")
		private String city;
		
		
	
	
		
		
		
}
