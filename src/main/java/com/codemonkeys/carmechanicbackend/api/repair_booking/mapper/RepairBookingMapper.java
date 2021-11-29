package com.codemonkeys.carmechanicbackend.api.repair_booking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientViewDto;
import com.codemonkeys.carmechanicbackend.api.client.mapper.ClientMapper;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingViewDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;

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
		
		repairBookingEntity.setClient(clientMapper.toNewEntity(repairBookingDto.getClientDto()));
		
		return repairBookingEntity;
		
	}

	public RepairBooking toEntity(String id, RepairBookingDto repairBookingDto) {
		
		RepairBooking repairBookingEntity = new RepairBooking();
		
		if(repairBookingDto.getId() != null) {
			repairBookingEntity.setId(repairBookingDto.getId());
		}
		
		if(repairBookingDto.getDate() != null) {
			repairBookingEntity.setDate(repairBookingDto.getDate());
		}
		
		if(repairBookingDto.getStatus() != null) {
			repairBookingEntity.setStatus(repairBookingDto.getStatus());
		}
		
		if(repairBookingDto.getTotalPrice() != null) {
			repairBookingEntity.setTotalPrice(repairBookingDto.getTotalPrice());
		}
		
		if(repairBookingDto.getClientDto() != null) {
			Client client = clientMapper.toEntity(repairBookingDto.getClientDto());
			repairBookingEntity.setClient(client);
		}
		
		return repairBookingEntity;
		
	}
	
	public RepairBookingDto toDto(RepairBooking repairBooking) {
		
		RepairBookingDto repairBookingDto = new RepairBookingDto();
		
		if(repairBooking.getId() != null) {
			repairBookingDto.setId(repairBooking.getId());
		}
		
		if(repairBooking.getDate() != null) {
			repairBookingDto.setDate(repairBooking.getDate());
		}
		
		if(repairBooking.getStatus() != null) {
			repairBookingDto.setStatus(repairBooking.getStatus());
		}
		
		if(repairBooking.getTotalPrice() != null) {
			repairBookingDto.setTotalPrice(repairBooking.getTotalPrice());
		}
		
		if(repairBooking.getClient() != null) {
			
			ClientDto clientDto = clientMapper.toDto(repairBooking.getClient());
			
			repairBookingDto.setClientDto(clientDto);
		}
		
		return repairBookingDto;
	}
	
	public RepairBookingViewDto toViewDto(RepairBooking repairBooking) {
		
		RepairBookingViewDto repairBookingViewDto = new RepairBookingViewDto();
		
		if(repairBooking.getId() != null) {
			repairBookingViewDto.setId(repairBooking.getId());
		}
		
		if(repairBooking.getDate() != null) {
			repairBookingViewDto.setDate(repairBooking.getDate());
		}
		
		if(repairBooking.getStatus() != null) {
			repairBookingViewDto.setStatus(repairBooking.getStatus());
		}
		
		if(repairBooking.getClient() != null) {
			
			ClientViewDto clientViewDto = clientMapper.toViewDto(repairBooking.getClient());
			
			repairBookingViewDto.setClientViewDto(clientViewDto);
		}
		
		return repairBookingViewDto;
	}
	
	public List<RepairBookingViewDto> toViewDtoList(List<RepairBooking> repairBookings){
		
		List<RepairBookingViewDto> repairBookingDtoList = new ArrayList<RepairBookingViewDto>();
		
		for(RepairBooking repairBooking : repairBookings) {
			repairBookingDtoList.add(toViewDto(repairBooking));
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
		
		if(repairBookingDto.getClientDto() != null) {
			Client client = clientMapper.updateEntity(repairBookingDto.getClientDto(), repairBookingEntity.getClient());
			repairBookingEntity.setClient(client);
		}
		
		return repairBookingEntity;
	}

	

}
