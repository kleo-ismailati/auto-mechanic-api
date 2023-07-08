package com.codemonkeys.car_mechanic.api.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.codemonkeys.car_mechanic.api.dto.repair_booking.new_repair_booking.NewRepairBookingDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_edit.RepairBookingEditDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_guest.RepairBookingGuestViewDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_guest.RepairGuestViewDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_list.RepairBookingListItemDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_list.RepairBookingPageDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.RepairBookingDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.RepairForRepairBookingDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.codemonkeys.car_mechanic.api.model.Car;
import com.codemonkeys.car_mechanic.api.model.Client;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_list.RepairForRepairBookingListItemDto;
import com.codemonkeys.car_mechanic.api.model.RepairBooking;
import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;

@Service
public class RepairBookingMapper {
	
	private final RepairMapper repairMapper;

	
	public RepairBookingMapper(RepairMapper repairMapper) {
		this.repairMapper = repairMapper;
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
		rbGuestViewDto.setFirstName(repairBooking.getClient().getFirstName());
		rbGuestViewDto.setLastName(repairBooking.getClient().getLastName());
		rbGuestViewDto.setCarModel(repairBooking.getCar().getCarModel());
		rbGuestViewDto.setCarType(repairBooking.getCar().getCarType());

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
		repairBookingListItemDto.setFirstName(repairBooking.getClient().getFirstName());
		repairBookingListItemDto.setLastName(repairBooking.getClient().getLastName());
		repairBookingListItemDto.setCarModel(repairBooking.getCar().getCarModel());
		repairBookingListItemDto.setCarType(repairBooking.getCar().getCarType());

		List<RepairForRepairBookingListItemDto> repairs = repairMapper.toRBListItemDtoList(repairBooking.getRepairs());
		repairBookingListItemDto.setRepairs(repairs);

		long total = 0L;

		for(RepairForRepairBookingListItemDto repair : repairs) {
			total += repair.getRepairCost();
		}

		repairBookingListItemDto.setTotalPrice(total);

		return repairBookingListItemDto;
	}

	public RepairBookingDto toViewDto(RepairBooking repairBooking) {

		RepairBookingDto repairBookingDto = new RepairBookingDto();

		repairBookingDto.setId(repairBooking.getId());
		repairBookingDto.setDate(repairBooking.getDate());
		repairBookingDto.setStatus(repairBooking.getStatus());
		repairBookingDto.setFirstName(repairBooking.getClient().getFirstName());
		repairBookingDto.setLastName(repairBooking.getClient().getLastName());
		repairBookingDto.setCarModel(repairBooking.getCar().getCarModel());
		repairBookingDto.setCarType(repairBooking.getCar().getCarType());

		List<RepairForRepairBookingDto> repairs = repairMapper.toViewDtoList(repairBooking.getRepairs());
		repairBookingDto.setRepairs(repairs);

		long total = 0L;

		for(RepairForRepairBookingDto repair : repairs) {
			total += repair.getRepairCost();
		}

		repairBookingDto.setTotalPrice(total);

		return repairBookingDto;
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
