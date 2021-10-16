package com.codemonkeys.carmechanicbackend.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codemonkeys.carmechanicbackend.admin.model.Admin;
import com.codemonkeys.carmechanicbackend.admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
}
