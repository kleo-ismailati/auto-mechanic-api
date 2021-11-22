package com.codemonkeys.carmechanicbackend.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.admin.dto.AdminDto;
import com.codemonkeys.carmechanicbackend.admin.dto.AdminListDto;
import com.codemonkeys.carmechanicbackend.admin.dto.AdminMapper;
import com.codemonkeys.carmechanicbackend.admin.dto.NewAdminDto;
import com.codemonkeys.carmechanicbackend.admin.model.Admin;
import com.codemonkeys.carmechanicbackend.admin.repository.AdminRepository;
import com.codemonkeys.carmechanicbackend.security.service.PasswordService;

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

	public AdminListDto getAdmin(String id) {
		
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new AdminException(id));
		return adminMapper.toDto(admin);
	}

	public void addAdmin(NewAdminDto newAdmin) {
		
		Admin admin = adminMapper.toNewEntity(newAdmin);
		admin.setPassword(passEncrypter.encryptPassword(admin.getPassword()));
		adminRepository.save(admin);
	}

	public void deleteAdmin(String id) {
		
		adminRepository.deleteById(id);
	}

	public void editAdmin(String id, AdminDto adminDto) {
		
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new AdminException(id));
		
		adminMapper.updateEntity(adminDto, admin);
		adminRepository.save(admin);
	}
}
