package com.codemonkeys.car_mechanic.api.mapper;

import java.util.ArrayList;
import java.util.List;

import com.codemonkeys.car_mechanic.api.dto.repair_booking.new_repair_booking.NewRepairDto;
import com.codemonkeys.car_mechanic.api.dto.repair.RepairDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_guest.RepairGuestViewDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_list.RepairRBListItemDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.RepairRBDto;
import com.codemonkeys.car_mechanic.api.dto.repair.repair_edit.RepairEditDto;
import org.springframework.stereotype.Service;

import com.codemonkeys.car_mechanic.api.model.Repair;
import com.codemonkeys.car_mechanic.api.model.RepairBooking;
import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;

@Service
public class RepairMapper {

	public List<Repair> toNewEntityList(List<NewRepairDto> repairsDtoList, RepairBooking repairBooking) {
		
		List<Repair> repairEntityList = new ArrayList<>();
		
		for(NewRepairDto newRepairDto : repairsDtoList) {
			
			repairEntityList.add(toNewEntity(newRepairDto, repairBooking));
		}
		
		return repairEntityList;
	}

	public List<RepairRBDto> toViewDtoList(List<Repair> repairs) {
		
		List<RepairRBDto> repairRBDtoList = new ArrayList<>();
		
		for(Repair repair : repairs) {
			
			repairRBDtoList.add(toViewDto(repair));
		}
		
		return repairRBDtoList;
	}

	public List<RepairRBListItemDto> toRBListItemDtoList(List<Repair> repairs) {
		
		List<RepairRBListItemDto> repairRBListItemDtoList = new ArrayList<>();
		
		for(Repair repair : repairs) {
			
			repairRBListItemDtoList.add(toRBListItemDto(repair));
		}
		
		return repairRBListItemDtoList;
	}
	

	public Repair toNewEntity(NewRepairDto repairDto, RepairBooking repairBooking) {
		
		Repair repairEntity = new Repair();
		
		repairEntity.setRepairCost(repairDto.getRepairCost());
		repairEntity.setRepairDetails(repairDto.getRepairDetails());
		repairEntity.setRepairType(repairDto.getRepairType());
		repairEntity.setRepairStatus(RepairStatusEnum.toBeDone);
		repairEntity.setRepairBooking(repairBooking);
		
		return repairEntity;
	}
	
	public RepairRBListItemDto toRBListItemDto(Repair repair) {
		
		RepairRBListItemDto repairRBListItemDto = new RepairRBListItemDto();

		repairRBListItemDto.setRepairCost(repair.getRepairCost());
		
		return repairRBListItemDto;
	}
	
	public RepairRBDto toViewDto(Repair repair) {

		RepairRBDto repairRBDto = new RepairRBDto();

		repairRBDto.setId(repair.getId());
		repairRBDto.setRepairCost(repair.getRepairCost());
		repairRBDto.setRepairDetails(repair.getRepairDetails());
		repairRBDto.setRepairType(repair.getRepairType());
		repairRBDto.setRepairStatus(repair.getRepairStatus());
		
		return repairRBDto;
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

    public List<RepairGuestViewDto> toGuestViewDtoList(List<Repair> repairs) {

		List<RepairGuestViewDto> repairGuestViewDtoList = new ArrayList<>();

		for(Repair repair : repairs) {
			repairGuestViewDtoList.add(toGuestViewDto(repair));
		}

		return repairGuestViewDtoList;

    }

	public RepairGuestViewDto toGuestViewDto(Repair repair){

		RepairGuestViewDto repairGuestViewDto = new RepairGuestViewDto();

		repairGuestViewDto.setRepairCost(repair.getRepairCost());
		repairGuestViewDto.setRepairDetails(repair.getRepairDetails());
		repairGuestViewDto.setRepairType(repair.getRepairType());
		repairGuestViewDto.setRepairStatus(repair.getRepairStatus());

		return repairGuestViewDto;
	}

    public RepairDto toDto(Repair repair) {
		RepairDto repairDto = new RepairDto();

		repairDto.setId(repair.getId());
		repairDto.setRepairCost(repair.getRepairCost());
		repairDto.setRepairDetails(repair.getRepairDetails());
		repairDto.setRepairType(repair.getRepairType());
		repairDto.setRepairStatus(repair.getRepairStatus());

		return repairDto;
    }
}
