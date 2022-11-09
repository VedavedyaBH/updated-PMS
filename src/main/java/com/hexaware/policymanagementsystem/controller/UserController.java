package com.hexaware.policymanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.policymanagementsystem.entity.User;
import com.hexaware.policymanagementsystem.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/pmsuser")
public class UserController {
	@Autowired
	private UserService uServices; 
	
	@GetMapping("/listusers")
	@ApiOperation(value = "To view all users", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrived all users"),
			@ApiResponse(code = 401, message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	 List<User> findAllUsers(){
		return uServices.findAllUsers();
	}
	
	@PostMapping("/saveuser")
	@ApiOperation(value ="add a user")
	 User saveUser(
			@ApiParam(value = "User is stored in database",required = true)
	        @RequestBody User user) {
		
		return uServices.saveUser(user);
	}
	
	@PutMapping("/updateuser/{uid}")
	@ApiOperation(value = "update user...")
	 User updateUser(
			 @ApiParam(value = "User to update",required = true)
			 @Valid @RequestBody User user,
			 @PathVariable("uid") Long userId) throws Exception {
		User existingUser = uServices.findUserById(userId)
				.orElseThrow(()-> new Exception("user not found with id" + userId ));
		
		existingUser.setUserName(user.getUserName());
		existingUser.setPan(user.getPan());
		existingUser.setfName(user.getfName());
		existingUser.setlName(user.getlName());
		existingUser.setDob(user.getDob());
		existingUser.setEmail(user.getEmail());
		existingUser.setpNumber(user.getpNumber());
		existingUser.setSalary(user.getSalary());
		
				return uServices.updateUserById(existingUser, userId);
		
	}
	
	@GetMapping("/findbyuserid/{uid}")
	@ApiOperation(value = "Get a user by id")
	 Optional<User> getUserById(
			@ApiParam(value="returns the user with id",required = true)
			@PathVariable("uid")Long userId){
		return uServices.findUserById(userId);
	}
	
	
	@DeleteMapping("/deleteuserid/{uid}")
	@ApiOperation(value = "deletes a user")
	 void deleteUserById(@PathVariable("uid") Long userId){
		uServices.deleteUserById(userId);
	}
	
	
	@GetMapping("/UserByuserName/{userName}")
	@ApiOperation(value = "Get an User by user name") 
	List<User> getuserByuserName(@ApiParam (value="returns the user with username", required = true) @PathVariable("userName") String userName){
	return uServices.getuserByuserName(userName);
	};

	
}
