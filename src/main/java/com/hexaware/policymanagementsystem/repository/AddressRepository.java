package com.hexaware.policymanagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.policymanagementsystem.entity.Address;



public interface AddressRepository extends JpaRepository<Address, Long>{
	

}
