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
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="address_Id")
		private Long  addressId ;
		
		@Column(name="door_num")
		private String doorNum;
		
		@Column(name="street_name")
		private String streetName;
		
		@Column(name="state")
		private String state;
		
		@Column(name="city")
		private String city;
		
		@Column(name="pincode")
		private Long pincode;
		
		@Column(name="user_id")
		private Long userId;
		public Address() {
			// TODO Auto-generated constructor stub
		}
		public Address(Long addressId, String doorNum, String streetName, String state, String city, Long pincode,
				Long userId) {
			super();
			this.addressId = addressId;
			this.doorNum = doorNum;
			this.streetName = streetName;
			this.state = state;
			this.city = city;
			this.pincode = pincode;
			this.userId = userId;
		}
		public Long getAddressId() {
			return addressId;
		}
		public void setAddressId(Long addressId) {
			this.addressId = addressId;
		}
		public String getDoorNum() {
			return doorNum;
		}
		public void setDoorNum(String doorNum) {
			this.doorNum = doorNum;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
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
		public Long getPincode() {
			return pincode;
		}
		public void setPincode(Long pincode) {
			this.pincode = pincode;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		
		
		
}
