package com.codemonkeys.carmechanicbackend.repair_booking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.RepairBookingDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.RepairBookingListDto;
import com.codemonkeys.carmechanicbackend.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.repair_booking.model.RepairStatusEnum;

@Service
public class RepairBookingMapper {
	
	private ClientMapper clientMapper;
	
	public RepairBookingMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

	public RepairBooking toNewEntity(NewRepairBookingDto repairBookingDto) {
		
		RepairBooking repairBookingEntity = new RepairBooking();
		
		repairBookingEntity.setDate(repairBookingDto.getDate());
		repairBookingEntity.setStatus(RepairStatusEnum.TO_BE_DONE.toString());
		repairBookingEntity.setTotalPrice(repairBookingDto.getTotalPrice());
		
		repairBookingEntity.setClient(clientMapper.toNewEntity(repairBookingDto.getClient()));
		
		return repairBookingEntity;
		
	}

	public RepairBooking toEntity(String id, RepairBookingDto repairBookingDto) {
		
		RepairBooking repairBookingEntity = new RepairBooking();
		
		repairBookingEntity.setId(id);
		
		if(repairBookingDto.getDate() != null) {
			repairBookingEntity.setDate(repairBookingDto.getDate());
		}
		
		if(repairBookingDto.getStatus() != null) {
			repairBookingEntity.setStatus(repairBookingDto.getStatus());
		}
		
		if(repairBookingDto.getTotalPrice() != null) {
			repairBookingEntity.setTotalPrice(repairBookingDto.getTotalPrice());
		}
		
		if(repairBookingDto.getClient() != null) {
			repairBookingEntity.setClient(repairBookingDto.getClient());
		}
		
		return repairBookingEntity;
		
	}
	
	public RepairBookingListDto toDto(RepairBooking repairBooking) {
		
		RepairBookingListDto repairBookingListDto = new RepairBookingListDto();
		
		if(repairBooking.getDate() != null) {
			repairBookingListDto.setDate(repairBooking.getDate());
		}
		
		if(repairBooking.getStatus() != null) {
			repairBookingListDto.setStatus(repairBooking.getStatus());
		}
		
		if(repairBooking.getTotalPrice() != null) {
			repairBookingListDto.setTotalPrice(repairBooking.getTotalPrice());
		}
		
		if(repairBooking.getClient() != null) {
			repairBookingListDto.setClient(repairBooking.getClient());
		}
		
		return repairBookingListDto;
	}
	
	public List<RepairBookingListDto> toDtoList(List<RepairBooking> repairBookings){
		
		List<RepairBookingListDto> repairBookingDtoList = new ArrayList<RepairBookingListDto>();
		
		for(RepairBooking repairBooking : repairBookings) {
			repairBookingDtoList.add(toDto(repairBooking));
		}
		
		return repairBookingDtoList;
	}
	
	public RepairBooking updateEntity(RepairBookingDto repairBookingDto, RepairBooking repairBookingEntity) {
		
		
		if(repairBookingDto.getDate() != null) {
			repairBookingEntity.setDate(repairBookingDto.getDate());
		}
		
		if(repairBookingDto.getStatus() != null) {
			repairBookingEntity.setStatus(repairBookingDto.getStatus());
		}
		
		if(repairBookingDto.getTotalPrice() != null) {
			repairBookingEntity.setTotalPrice(repairBookingDto.getTotalPrice());
		}
		
		if(repairBookingDto.getClient() != null) {
			repairBookingEntity.setClient(repairBookingDto.getClient());
		}
		
		return repairBookingEntity;
	}

	

}
