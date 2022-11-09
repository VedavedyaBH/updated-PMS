package com.hexaware.policymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.policymanagementsystem.entity.User;






public interface UserRepository extends JpaRepository<User, Long> {
	
	
	public List<User> findUserByuserName(String userName);
	
}
