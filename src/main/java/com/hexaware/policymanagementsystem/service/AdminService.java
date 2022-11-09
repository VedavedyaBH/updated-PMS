package com.hexaware.policymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.policymanagementsystem.entity.Admin;



public interface AdminService {
	public List<Admin> findAllAdmin() ;
	public Optional<Admin> findAdminById(Long adminId);
	
}
