package com.hexaware.policymanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.policymanagementsystem.entity.Admin;
import com.hexaware.policymanagementsystem.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin("*")
@RestController
@RequestMapping("/pmsadmin")
public class AdminController {
	@Autowired
	private AdminService aServices;
	
	@GetMapping("/listadmins")
	@ApiOperation(value = "To view all users", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrived admin"),
			@ApiResponse(code = 401, message = "You are not authorized to view this resource"),
			@ApiResponse(code = 403,message = "Accessing of this resource forbidden"),
			@ApiResponse(code = 404,message = "Resource not found"),
	})
	 List<Admin> findAllAdmin() {
		return aServices.findAllAdmin();
	}
	
	@GetMapping("/findadminbyid/{adminId}")
	@ApiOperation(value = "Get admin by id")
	 Optional<Admin> getAdminById(
			 @ApiParam(value="returns the admin with id",required = true)
			 @PathVariable("adminId") Long adminId) {
		
		return aServices.findAdminById(adminId);
	};
	

}
