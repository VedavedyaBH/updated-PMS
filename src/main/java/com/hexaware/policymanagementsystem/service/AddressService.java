package com.hexaware.policymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.policymanagementsystem.entity.Address;
import com.hexaware.policymanagementsystem.exception.ResourceNotFoundException;


public interface AddressService {
	public List<Address> findAllAddress();
	public Address saveAddress(Address address);
	public Optional<Address> findAddressById(Long AddressId);
	public Address updateAddressById(Address existingAddress, Long addressId) throws ResourceNotFoundException;
	
}
