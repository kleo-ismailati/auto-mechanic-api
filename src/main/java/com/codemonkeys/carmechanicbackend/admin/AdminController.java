package com.codemonkeys.carmechanicbackend.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
}
