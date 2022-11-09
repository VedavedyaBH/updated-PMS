package com.hexaware.policymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.policymanagementsystem.entity.User;
import com.hexaware.policymanagementsystem.exception.ResourceNotFoundException;



public interface UserService {
	public List<User> findAllUsers();
	public Optional<User> findUserById(Long userId);
	public void deleteUserById(Long userId);
	public User saveUser(User user);
	public User updateUserById(User existingUser , Long userId) throws ResourceNotFoundException;
	
	List<User> getuserByuserName(String userName);
	
	
}
