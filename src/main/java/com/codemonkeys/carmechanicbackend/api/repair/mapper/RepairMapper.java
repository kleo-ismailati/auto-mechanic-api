package com.codemonkeys.carmechanicbackend.api.repair.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.repair.dto.NewRepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairEditDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairViewDto;
import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;

@Service
public class RepairMapper {

	public List<Repair> toNewEntityList(List<NewRepairDto> repairsDtoList, RepairBooking repairBooking) {
		
		List<Repair> repairEntityList = new ArrayList<Repair>();
		
		for(NewRepairDto newRepairDto : repairsDtoList) {
			
			repairEntityList.add(toNewEntity(newRepairDto, repairBooking));
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

	public List<Repair> toEntityList(RepairBooking repairBooking, List<RepairDto> repairDtoList) {

		List<Repair> repairList = new ArrayList<Repair>();
		
		for(RepairDto repairDto : repairDtoList) {
			
			repairList.add(toEntity(repairBooking, repairDto));
		}
		
		return repairList;
	}
	
	public List<Repair> updateEntityList(RepairBooking repairBooking, List<RepairDto> repairDtoList) {

		List<Repair> repairList = new ArrayList<Repair>();
		
		for(RepairDto repairDto : repairDtoList) {
			
			for (Repair repair : repairBooking.getRepairs()) {
				
				if(repairDto.getId().equals(repair.getId())) {
					
					repairList.add(toEntity(repairBooking, repairDto));
				}
			}
			
		}
		
		return repairList;
	}
	

	public Repair toNewEntity(NewRepairDto repairDto, RepairBooking repairBooking) {
		
		Repair repairEntity = new Repair();
		
		repairEntity.setRepairCost(repairDto.getRepairCost());
		repairEntity.setRepairDetails(repairDto.getRepairDetails());
		repairEntity.setRepairType(repairDto.getRepairType());
		repairEntity.setRepairStatus(RepairStatusEnum.TO_BE_DONE.toString());
		repairEntity.setRepairBooking(repairBooking);
		
		return repairEntity;
	}
	
	public Repair toEntity(RepairBooking repairBooking, RepairDto repairDto) {
		
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
		
		repairEntity.setRepairBooking(repairBooking);
		
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
		
		if(repair.getRepairBooking() != null) {
			repairDto.setRb_id(repair.getRepairBooking().getId());
		}
		
		return repairDto;
	}
	
	public Repair updateEntity(RepairEditDto repairDto, Repair repair) {
		
		if(repairDto.getRepairCost() != null) {
			repair.setRepairCost(repairDto.getRepairCost());
		}
		
		if(repairDto.getRepairDetails() != null) {
			repair.setRepairDetails(repairDto.getRepairDetails());
		}
		
		if(repairDto.getRepairType() != null) {
			repair.setRepairType(repairDto.getRepairType());
		}
		
		if(repairDto.getRepairStatus() != null) {
			repair.setRepairStatus(repairDto.getRepairStatus());
		}
		
		return repair;
	}
}
