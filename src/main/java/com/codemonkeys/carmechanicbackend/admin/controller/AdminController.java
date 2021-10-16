package com.codemonkeys.carmechanicbackend.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.admin.model.Admin;
import com.codemonkeys.carmechanicbackend.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping
	@ResponseBody
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
}
