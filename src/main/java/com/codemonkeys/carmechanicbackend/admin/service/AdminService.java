package com.codemonkeys.carmechanicbackend.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.admin.model.Admin;
import com.codemonkeys.carmechanicbackend.admin.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAllAdmins() {
		
		return adminRepository.findAll();
	}

	
}
