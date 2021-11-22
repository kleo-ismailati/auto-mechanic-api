package com.codemonkeys.carmechanicbackend.admin.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.admin.model.Admin;

@Service
public class AdminMapper {

	public Admin toNewEntity(NewAdminDto newAdmin) {
		
		Admin adminEntity = new Admin();
		
		adminEntity.setUsername(newAdmin.getUsername());
		adminEntity.setEmail(newAdmin.getEmail());
		adminEntity.setPassword(newAdmin.getPassword());
		adminEntity.setRole("ADMIN");
		
		return adminEntity;
	}
	
	public Admin toEntity(String id, AdminDto adminDto) {
		
		Admin adminEntity = new Admin();
		
		adminEntity.setId(id);
		
		if(adminDto.getUsername() != null) {
			adminEntity.setUsername(adminDto.getUsername());
		}
		
		if(adminDto.getEmail() != null) {
			adminEntity.setEmail(adminDto.getEmail());
		}
		
		if(adminDto.getPassword() != null) {
			adminEntity.setPassword(adminDto.getPassword());
		}
		
		return adminEntity;
	}

	public AdminListDto toDto(Admin admin) {
		
		AdminListDto adminDto = new AdminListDto();
		
		adminDto.setUsername(admin.getUsername());
		adminDto.setEmail(admin.getEmail());
		
		return adminDto;
	}
	
	public List<AdminListDto> toDtoList(List<Admin> admins) {
		
		List<AdminListDto> adminDtoList = new ArrayList<AdminListDto> ();
		
		for(Admin admin : admins) {
			adminDtoList.add(toDto(admin));
		}
		
		return adminDtoList;
	}
	
	public Admin updateEntity(AdminDto adminDto, Admin adminEntity) {
		
		
		if(adminDto.getUsername() != null) {
			adminEntity.setUsername(adminDto.getUsername());
		}
		
		if(adminDto.getEmail() != null) {
			adminEntity.setEmail(adminDto.getEmail());
		}
		
		if(adminDto.getPassword() != null) {
			adminEntity.setPassword(adminDto.getPassword());
		}
		
		return adminEntity;
	}

}
