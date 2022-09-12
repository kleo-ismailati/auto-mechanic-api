package com.codemonkeys.carmechanicbackend.api.repair_booking.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairGuestViewDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairViewDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.mapper.CarMapper;
import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.client.mapper.ClientMapper;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairRBListItemDto;
import com.codemonkeys.carmechanicbackend.api.repair.mapper.RepairMapper;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;

@Service
public class RepairBookingMapper {
	
	private final RepairMapper repairMapper;
	
	private final ClientMapper clientMapper;
	
	private final CarMapper carMapper;
	
	public RepairBookingMapper(RepairMapper repairMapper, ClientMapper clientMapper, CarMapper carMapper) {
		this.repairMapper = repairMapper;
		this.clientMapper = clientMapper;
		this.carMapper = carMapper;
	}

	public RepairBooking toNewEntity(NewRepairBookingDto repairBookingDto, Client client, Car car) {
		
		RepairBooking repairBookingEntity = new RepairBooking();
		
		repairBookingEntity.setDate(LocalDateTime.now());
		repairBookingEntity.setStatus(RepairStatusEnum.toBeDone);
		repairBookingEntity.setTotalPrice(repairBookingDto.getTotalPrice());
		repairBookingEntity.setClient(client);
		repairBookingEntity.setCar(car);
		repairBookingEntity.setRefID(String.valueOf(UUID.randomUUID()));
		repairBookingEntity.setRepairs(repairMapper.toNewEntityList(repairBookingDto.getRepairs(), repairBookingEntity));
		
		return repairBookingEntity;
		
	}
	
	public RepairBookingGuestViewDto toGuestViewDto(RepairBooking repairBooking) {

		RepairBookingGuestViewDto rbGuestViewDto = new RepairBookingGuestViewDto();

		rbGuestViewDto.setDate(repairBooking.getDate());
		rbGuestViewDto.setStatus(repairBooking.getStatus());
		rbGuestViewDto.setClient(clientMapper.toGuestViewDto(repairBooking.getClient()));
		rbGuestViewDto.setCar(carMapper.toGuestViewDto(repairBooking.getCar()));

		List<RepairGuestViewDto> repairs = repairMapper.toGuestViewDtoList(repairBooking.getRepairs());
		rbGuestViewDto.setRepairs(repairs);

		long total = 0L;

		for(RepairGuestViewDto repair : repairs) {
			total += repair.getRepairCost();
		}

		rbGuestViewDto.setTotalPrice(total);
		
		return rbGuestViewDto;
	}
	
	public RepairBookingListItemDto toRBListItemDto(RepairBooking repairBooking) {
		
		RepairBookingListItemDto repairBookingListItemDto = new RepairBookingListItemDto();
		repairBookingListItemDto.setId(repairBooking.getId());
		repairBookingListItemDto.setDate(repairBooking.getDate());
		repairBookingListItemDto.setStatus(repairBooking.getStatus());
		repairBookingListItemDto.setClient(clientMapper.toRBListItemDto(repairBooking.getClient()));
		repairBookingListItemDto.setCar(carMapper.toRBListItemDto(repairBooking.getCar()));

		List<RepairRBListItemDto> repairs = repairMapper.toRBListItemDtoList(repairBooking.getRepairs());
		repairBookingListItemDto.setRepairs(repairs);

		long total = 0L;

		for(RepairRBListItemDto repair : repairs) {
			total += repair.getRepairCost();
		}

		repairBookingListItemDto.setTotalPrice(total);

		return repairBookingListItemDto;
	}

	public RepairBookingViewDto toViewDto(RepairBooking repairBooking) {

		RepairBookingViewDto repairBookingViewDto = new RepairBookingViewDto();

		repairBookingViewDto.setDate(repairBooking.getDate());
		repairBookingViewDto.setStatus(repairBooking.getStatus());
		repairBookingViewDto.setClient(clientMapper.toViewDto(repairBooking.getClient()));
		repairBookingViewDto.setCar(carMapper.toViewDto(repairBooking.getCar()));

		List<RepairViewDto> repairs = repairMapper.toViewDtoList(repairBooking.getRepairs());
		repairBookingViewDto.setRepairs(repairs);

		long total = 0L;

		for(RepairViewDto repair : repairs) {
			total += repair.getRepairCost();
		}

		repairBookingViewDto.setTotalPrice(total);

		return repairBookingViewDto;
	}
	
	public RepairBookingPageDto toViewPage(Page<RepairBooking> repairBookings){
		
		RepairBookingPageDto repairBookingPageDto = new RepairBookingPageDto();
		
		List<RepairBookingListItemDto> repairBookingDtoList = new ArrayList<>();
		
		for(RepairBooking repairBooking : repairBookings) {
			repairBookingDtoList.add(toRBListItemDto(repairBooking));
		}
		
		repairBookingPageDto.setResult(repairBookingDtoList);
		repairBookingPageDto.setPageNo(repairBookings.getNumber());
		repairBookingPageDto.setSize(repairBookings.getSize());
		repairBookingPageDto.setTotal(repairBookings.getTotalPages());
		
		return repairBookingPageDto;
	}
	
	public RepairBooking updateEntity(RepairBookingEditDto repairBookingDto, RepairBooking repairBookingEntity) {
		
		if(repairBookingDto.getStatus() != null) {
			repairBookingEntity.setStatus(repairBookingDto.getStatus());
		}
		
		return repairBookingEntity;
	}



}
