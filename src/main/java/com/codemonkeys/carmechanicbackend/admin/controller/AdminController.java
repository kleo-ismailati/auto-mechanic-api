package com.codemonkeys.carmechanicbackend.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.admin.dto.AdminDto;
import com.codemonkeys.carmechanicbackend.admin.dto.NewAdminDto;
import com.codemonkeys.carmechanicbackend.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public List<AdminDto> getAllAdmins() {
		return adminService.getAllAdmins();
	}
	
	@GetMapping(value = "/{id}")
	public AdminDto getAdmin(@PathVariable("id") String id) {
		return adminService.getAdmin(id);
	}
	
	@PostMapping
	public void addAdmin(@RequestBody NewAdminDto newAdmin) {
		adminService.addAdmin(newAdmin);
	}
	
	@PutMapping(value = "/{id}")
	public void editAdmin(@PathVariable("id") String id, @RequestBody NewAdminDto adminDto) {
		adminService.editAdmin(id, adminDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAdmin(@PathVariable("id") String id) {
		adminService.deleteAdmin(id);
	}
}
