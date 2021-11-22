package com.codemonkeys.carmechanicbackend.repair_booking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair.NewRepairDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair.RepairDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair.RepairViewDto;
import com.codemonkeys.carmechanicbackend.repair_booking.model.Repair;
import com.codemonkeys.carmechanicbackend.repair_booking.model.RepairStatusEnum;

@Service
public class RepairMapper {

	public List<Repair> toNewEntityList(List<NewRepairDto> repairsDtoList) {
		
		List<Repair> repairEntityList = new ArrayList<Repair>();
		
		for(NewRepairDto newRepairDto : repairsDtoList) {
			
			repairEntityList.add(toNewEntity(newRepairDto));
		}
		
		return repairEntityList;
	}

	public List<RepairDto> toDtoList(List<Repair> repairs) {
		
		List<RepairDto> repairDtoList = new ArrayList<RepairDto>();
		
		for(Repair repair : repairs) {
			
			repairDtoList.add(toDto(repair));
		}
		
		return repairDtoList;
	}

	public List<RepairViewDto> toViewDtoList(List<Repair> repairs) {
		
		List<RepairViewDto> repairViewDtoList = new ArrayList<RepairViewDto>();
		
		for(Repair repair : repairs) {
			
			repairViewDtoList.add(toViewDto(repair));
		}
		
		return repairViewDtoList;
	}

	public List<Repair> toEntityList(List<RepairDto> repairDtoList) {

		List<Repair> repairList = new ArrayList<Repair>();
		
		for(RepairDto repairDto : repairDtoList) {
			
			repairList.add(toEntity(repairDto));
		}
		
		return repairList;
	}
	

	public Repair toNewEntity(NewRepairDto repairDto) {
		
		Repair repairEntity = new Repair();
		
		repairEntity.setId(new ObjectId().toString());
		
		repairEntity.setRepairCost(repairDto.getRepairCost());
		repairEntity.setRepairDetails(repairDto.getRepairDetails());
		repairEntity.setRepairType(repairDto.getRepairType());
		repairEntity.setRepairStatus(RepairStatusEnum.TO_BE_DONE.toString());
		
		return repairEntity;
	}
	
	public Repair toEntity(RepairDto repairDto) {
		
		Repair repairEntity = new Repair();
		
		if(repairDto.getId() != null) {
			repairEntity.setId(repairDto.getId());
		}
		
		if(repairDto.getRepairCost() != null) {
			repairEntity.setRepairCost(repairDto.getRepairCost());
		}
		
		if(repairDto.getRepairDetails() != null) {
			repairEntity.setRepairDetails(repairDto.getRepairDetails());
		}
		
		if(repairDto.getRepairType() != null) {
			repairEntity.setRepairType(repairDto.getRepairType());
		}
		
		if(repairDto.getRepairStatus() != null) {
			repairEntity.setRepairStatus(repairDto.getRepairStatus());
		}
		
		return repairEntity;
	}
	
	public RepairViewDto toViewDto(Repair repair) {
		
		RepairViewDto repairViewDto = new RepairViewDto();
		
		if(repair.getRepairCost() != null) {
			repairViewDto.setRepairCost(repair.getRepairCost());
		}
		
		if(repair.getRepairDetails() != null) {
			repairViewDto.setRepairDetails(repair.getRepairDetails());
		}
		
		if(repair.getRepairType() != null) {
			repairViewDto.setRepairType(repair.getRepairType());
		}
		
		return repairViewDto;
	}
	
	public RepairDto toDto(Repair repair) {
		

		RepairDto repairDto = new RepairDto();
		
		if(repair.getId() != null) {
			repairDto.setId(repair.getId());
		}
		
		if(repair.getRepairCost() != null) {
			repairDto.setRepairCost(repair.getRepairCost());
		}
		
		if(repair.getRepairDetails() != null) {
			repairDto.setRepairDetails(repair.getRepairDetails());
		}
		
		if(repair.getRepairType() != null) {
			repairDto.setRepairType(repair.getRepairType());
		}
		
		if(repair.getRepairStatus() != null) {
			repairDto.setRepairStatus(repair.getRepairStatus());
		}
		
		return repairDto;
	}
}
