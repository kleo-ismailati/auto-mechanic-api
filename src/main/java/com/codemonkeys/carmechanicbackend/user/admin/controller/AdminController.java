package com.codemonkeys.carmechanicbackend.user.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.user.admin.dto.AdminDto;
import com.codemonkeys.carmechanicbackend.user.admin.dto.AdminListDto;
import com.codemonkeys.carmechanicbackend.user.admin.dto.NewAdminDto;
import com.codemonkeys.carmechanicbackend.user.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@GetMapping
	public List<AdminListDto> getAllAdmins() {
		return adminService.getAllAdmins();
	}
	
	@GetMapping(value = "/{id}")
	public AdminListDto getAdmin(@PathVariable("id") Long id) {
		return adminService.getAdmin(id);
	}
	
	@PostMapping
	public void addAdmin(@RequestBody NewAdminDto newAdmin) {
		adminService.addAdmin(newAdmin);
	}
	
	@PutMapping(value = "/{id}")
	public void editAdmin(@PathVariable("id") Long id, @RequestBody AdminDto adminDto) {
		adminService.editAdmin(id, adminDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAdmin(@PathVariable("id") Long id) {
		adminService.deleteAdmin(id);
	}
}
