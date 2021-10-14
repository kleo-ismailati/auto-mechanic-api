package com.codemonkeys.carmechanicbackend.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAllAdmins() {
		
		return adminRepository.findAll();
	}

	
}
