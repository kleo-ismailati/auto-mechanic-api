package com.codemonkeys.carmechanicbackend.admin.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.admin.model.Admin;

@Service
public class AdminMapper {

	public Admin toEntity(NewAdminDto newAdmin) {
		
		Admin adminEntity = new Admin();
		
		if(newAdmin.getUsername() != null) {
			adminEntity.setUsername(newAdmin.getUsername());
		}
		
		if(newAdmin.getEmail() != null) {
			adminEntity.setEmail(newAdmin.getEmail());
		}
		
		if(newAdmin.getPassword() != null) {
			adminEntity.setPassword(newAdmin.getPassword());
		}
		
		return adminEntity;
	}
	
	public Admin toEntity(String id, NewAdminDto newAdmin) {
		
		Admin adminEntity = new Admin();
		
		adminEntity.setId(id);
		
		if(newAdmin.getUsername() != null) {
			adminEntity.setUsername(newAdmin.getUsername());
		}
		
		if(newAdmin.getEmail() != null) {
			adminEntity.setEmail(newAdmin.getEmail());
		}
		
		if(newAdmin.getPassword() != null) {
			adminEntity.setPassword(newAdmin.getPassword());
		}
		
		return adminEntity;
	}

	public AdminDto toDto(Admin admin) {
		
		AdminDto adminDto = new AdminDto();
		
		adminDto.setUsername(admin.getUsername());
		adminDto.setEmail(admin.getEmail());
		
		return adminDto;
	}
	
	public List<AdminDto> toDtoList(List<Admin> admins) {
		
		List<AdminDto> adminDtoList = new ArrayList<AdminDto> ();
		
		for(Admin admin : admins) {
			adminDtoList.add(toDto(admin));
		}
		
		return adminDtoList;
	}
	
	public Admin updateEntity(NewAdminDto newAdmin, Admin adminEntity) {
		
		
		if(newAdmin.getUsername() != null) {
			adminEntity.setUsername(newAdmin.getUsername());
		}
		
		if(newAdmin.getEmail() != null) {
			adminEntity.setEmail(newAdmin.getEmail());
		}
		
		if(newAdmin.getPassword() != null) {
			adminEntity.setPassword(newAdmin.getPassword());
		}
		
		return adminEntity;
	}

}
