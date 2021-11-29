package com.codemonkeys.carmechanicbackend.api.repair_booking.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.exception.ResourceNotFoundException;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingViewDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.mapper.RepairBookingMapper;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.repair_booking.repository.RepairBookingRepository;

@Service
public class RepairBookingService {
	
	private RepairBookingRepository repairBookingRepository;
	
	private RepairBookingMapper repairBookingMapper;

	public RepairBookingService(RepairBookingRepository repairBookingRepository, 
			RepairBookingMapper repairBookingMapper) {
		this.repairBookingRepository = repairBookingRepository;
		this.repairBookingMapper = repairBookingMapper;
	}

	public ResponseEntity<List<RepairBookingViewDto>> getAllRepairBookings() {

		List<RepairBooking> repairBookings = repairBookingRepository.findAll();
		return ResponseEntity.ok(repairBookingMapper.toViewDtoList(repairBookings));
	}
	
	public ResponseEntity<RepairBookingDto> getRepairBooking(Long id) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Repair booking with id: " + id + " not found!"));
		
		return ResponseEntity.ok(repairBookingMapper.toDto(repairBooking));
	}

	public ResponseEntity<RepairBooking> addRepairBooking(NewRepairBookingDto newRepairBooking) {
		
		repairBookingRepository.save(repairBookingMapper.toNewEntity(newRepairBooking));
		
		return new ResponseEntity<RepairBooking>(HttpStatus.CREATED);
	}

	public ResponseEntity<RepairBooking> deleteRepairBooking(Long id) {
		
		repairBookingRepository.deleteById(id);
		
		return new ResponseEntity<RepairBooking>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<RepairBooking> editRepairBooking(Long id, RepairBookingDto repairBookingDto) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Repair booking with id: " + id + " not found!"));
		repairBookingMapper.updateEntity(repairBookingDto, repairBooking);
		repairBookingRepository.save(repairBooking);
		
		return new ResponseEntity<RepairBooking>(HttpStatus.OK);
	}

}
