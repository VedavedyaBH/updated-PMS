package com.hexaware.policymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.policymanagementsystem.entity.Address;
import com.hexaware.policymanagementsystem.exception.ResourceNotFoundException;
import com.hexaware.policymanagementsystem.repository.AddressRepository;
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressrepo;

	@Override
	public List<Address> findAllAddress() {
		return addressrepo.findAll();
	}

	@Override
	public Address saveAddress(Address address) {
		return addressrepo.save(address);
	}

	

	@Override
	public Address updateAddressById(Address address, Long addressId) throws ResourceNotFoundException {
		Address oldaddressdetails = findAddressById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address"));
		return addressrepo.save(oldaddressdetails);
	}

	@Override
	public Optional<Address> findAddressById(Long AddressId) {
		// TODO Auto-generated method stub
		return addressrepo.findById(AddressId);
	}

	

	
	
	
	

	
}