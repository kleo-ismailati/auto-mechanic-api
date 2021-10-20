package com.codemonkeys.carmechanicbackend.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.admin.dto.AdminDto;
import com.codemonkeys.carmechanicbackend.admin.dto.AdminMapper;
import com.codemonkeys.carmechanicbackend.admin.dto.NewAdminDto;
import com.codemonkeys.carmechanicbackend.admin.model.Admin;
import com.codemonkeys.carmechanicbackend.admin.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminMapper adminMapper;

	public List<AdminDto> getAllAdmins() {
		
		List<Admin> admins = adminRepository.findAll();
		return adminMapper.toDtoList(admins);
	}

	public AdminDto getAdmin(String id) {
		
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new AdminException(id));
		return adminMapper.toDto(admin);
	}

	public void addAdmin(NewAdminDto newAdmin) {
		
		adminRepository.save(adminMapper.toEntity(newAdmin));
	}

	public void deleteAdmin(String id) {
		
		adminRepository.deleteById(id);
	}

	public void editAdmin(String id, NewAdminDto adminDto) {
		
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new AdminException(id));
		adminMapper.updateEntity(adminDto, admin);
		adminRepository.save(admin);
	}
}
