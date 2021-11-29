package com.codemonkeys.carmechanicbackend.user.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.exception.ResourceNotFoundException;
import com.codemonkeys.carmechanicbackend.security.service.PasswordService;
import com.codemonkeys.carmechanicbackend.user.admin.dto.AdminDto;
import com.codemonkeys.carmechanicbackend.user.admin.dto.AdminListDto;
import com.codemonkeys.carmechanicbackend.user.admin.dto.AdminMapper;
import com.codemonkeys.carmechanicbackend.user.admin.dto.NewAdminDto;
import com.codemonkeys.carmechanicbackend.user.admin.model.Admin;
import com.codemonkeys.carmechanicbackend.user.admin.repository.AdminRepository;

@Service
public class AdminService {
	

	private AdminRepository adminRepository;
	
	private AdminMapper adminMapper;
	
	private PasswordService passEncrypter;
	
	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper, PasswordService passEncrypter) {
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
		this.passEncrypter = passEncrypter;
	}

	public List<AdminListDto> getAllAdmins() {
		
		List<Admin> admins = adminRepository.findAll();
		return adminMapper.toDtoList(admins);
	}

	public AdminListDto getAdmin(Long id) {
		
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin with id: " + id + " not found!"));
		return adminMapper.toDto(admin);
	}

	public void addAdmin(NewAdminDto newAdmin) {
		
		Admin admin = adminMapper.toNewEntity(newAdmin);
		admin.setPassword(passEncrypter.encryptPassword(admin.getPassword()));
		adminRepository.save(admin);
	}

	public void deleteAdmin(Long id) {
		
		adminRepository.deleteById(id);
	}

	public void editAdmin(Long id, AdminDto adminDto) {
		
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin with id: " + id + " not found!"));
		
		adminMapper.updateEntity(adminDto, admin);
		adminRepository.save(admin);
	}
}
