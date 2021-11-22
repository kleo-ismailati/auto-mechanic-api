package com.codemonkeys.carmechanicbackend.repair_booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.RepairBookingDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.RepairBookingListDto;
import com.codemonkeys.carmechanicbackend.repair_booking.mapper.RepairBookingMapper;
import com.codemonkeys.carmechanicbackend.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.repair_booking.repository.RepairBookingRepository;



@Service
public class RepairBookingService {
	
	private RepairBookingRepository repairBookingRepository;
	
	private RepairBookingMapper repairBookingMapper;

	public RepairBookingService(RepairBookingRepository repairBookingRepository, 
			RepairBookingMapper repairBookingMapper) {
		this.repairBookingRepository = repairBookingRepository;
		this.repairBookingMapper = repairBookingMapper;
	}

	public List<RepairBookingListDto> getAllRepairBookings() {

		List<RepairBooking> repairBookings = repairBookingRepository.findAll();
		return repairBookingMapper.toDtoList(repairBookings);
	}
	
	public RepairBookingListDto getRepairBooking(String id) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id)
				.orElseThrow(() -> new RepairBookingNotFoundException(id));
		return repairBookingMapper.toDto(repairBooking);
	}

	public void addRepairBooking(NewRepairBookingDto newRepairBooking) {
		
		repairBookingRepository.save(repairBookingMapper.toNewEntity(newRepairBooking));
	}

	public void deleteRepairBooking(String id) {
		
		repairBookingRepository.deleteById(id);
	}

	public void editRepairBooking(String id, RepairBookingDto repairBookingDto) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id)
				.orElseThrow(() -> new RepairBookingNotFoundException(id));
		repairBookingMapper.updateEntity(repairBookingDto, repairBooking);
		repairBookingRepository.save(repairBooking);
	}

}
