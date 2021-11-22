package com.codemonkeys.carmechanicbackend.repair_booking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.NewRepairDto;
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

	public Repair toNewEntity(NewRepairDto repairDto) {
		
		Repair repairEntity = new Repair();
		
		repairEntity.setId(new ObjectId().toString());
		
		repairEntity.setRepairCost(repairDto.getRepairCost());
		repairEntity.setRepairDetails(repairDto.getRepairDetails());
		repairEntity.setRepairType(repairDto.getRepairType());
		repairEntity.setRepairStatus(RepairStatusEnum.TO_BE_DONE.toString());
		
		return repairEntity;
	}
}
