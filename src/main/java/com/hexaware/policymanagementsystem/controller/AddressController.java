package com.hexaware.policymanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.policymanagementsystem.entity.Address;
import com.hexaware.policymanagementsystem.service.AddressService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pms")
@CrossOrigin("*")
public class AddressController {
	@Autowired
	private AddressService aServices;
	
	
	@GetMapping("/findalladdress")
	@ApiOperation(value = "To view all users", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrived address"),
			@ApiResponse(code = 401, message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	 List<Address> findAllAddress() {
		return aServices.findAllAddress();
	}
	
	@PostMapping("/saveaddress")
	@ApiOperation(value = "Add address")
	 Address saveAddress(
		@ApiParam(value ="Address is stored in database",required = true)
		@RequestBody Address address){
		return aServices.saveAddress(address);
	}
	
	@PutMapping("/updateaddress/{addressId}")
	@ApiOperation(value = "update address..")
	 Address updateAddress(
			 @ApiParam(value="Address to update",required = true)
			 @Valid @RequestBody Address address,
			 @PathVariable("addressId")Long addressId )throws Exception {
		Address exsistingAddress = aServices.findAddressById(addressId)
				.orElseThrow(()-> new Exception("address not found with id" + addressId));
		exsistingAddress.setCity(address.getCity());
		return aServices.updateAddressById(exsistingAddress,addressId);
	}
	
	@GetMapping("/findaddressbyid/{addressId}")
	@ApiOperation(value = "Get address by id")
	Optional<Address> getAddressById(
			@ApiParam(value ="returns the address with id", required = true)
			@PathVariable("addressId") Long addressId){
		return aServices.findAddressById(addressId);
	}
			
			
	

}
