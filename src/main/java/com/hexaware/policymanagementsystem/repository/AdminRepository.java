package com.hexaware.policymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.policymanagementsystem.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
