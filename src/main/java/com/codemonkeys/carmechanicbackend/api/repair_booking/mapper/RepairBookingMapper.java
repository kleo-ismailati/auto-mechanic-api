package com.codemonkeys.carmechanicbackend.api.repair_booking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.mapper.CarMapper;
import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.client.mapper.ClientMapper;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.repair.mapper.RepairMapper;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingViewDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;

@Service
public class RepairBookingMapper {
	
	private RepairMapper repairMapper;
	
	private ClientMapper clientMapper;
	
	private CarMapper carMapper;
	
	public RepairBookingMapper(RepairMapper repairMapper, ClientMapper clientMapper, CarMapper carMapper) {
		this.repairMapper = repairMapper;
		this.clientMapper = clientMapper;
		this.carMapper = carMapper;
	}

	public RepairBooking toNewEntity(NewRepairBookingDto repairBookingDto, Client client, Car car) {
		
		RepairBooking repairBookingEntity = new RepairBooking();
		
		repairBookingEntity.setDate(repairBookingDto.getDate());
		repairBookingEntity.setStatus(RepairStatusEnum.TO_BE_DONE.toString());
		repairBookingEntity.setTotalPrice(repairBookingDto.getTotalPrice());
		
		repairBookingEntity.setClient(client);
		
		repairBookingEntity.setCar(car);
		
		repairBookingEntity.setRepairs(repairMapper.toNewEntityList(repairBookingDto.getRepairs(), repairBookingEntity));
		
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
			
			repairBookingDto.setClientId(repairBooking.getClient().getId());
		}
		
		if(repairBooking.getCar() != null) {
			
			repairBookingDto.setCarId(repairBooking.getCar().getId());
		}
		
		if(repairBooking.getRepairs() != null) {
			
			repairBookingDto.setRepairs(repairMapper.toDtoList(repairBooking.getRepairs()));
			
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
			repairBookingViewDto.setClient(clientMapper.toViewDto(repairBooking.getClient()));
		}
		
		if(repairBooking.getCar() != null) {
			repairBookingViewDto.setCar(carMapper.toViewDto(repairBooking.getCar()));
		}
		
		if(repairBooking.getRepairs() != null) {
			
			repairBookingViewDto.setRepairs(repairMapper.toViewDtoList(repairBooking.getRepairs()));;
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
		
		return repairBookingEntity;
	}

	

}
