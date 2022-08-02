package com.codemonkeys.carmechanicbackend.api.repair.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.repair.dto.NewRepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.mapper.RepairMapper;
import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;
import com.codemonkeys.carmechanicbackend.api.repair.repository.RepairRepository;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.repair_booking.repository.RepairBookingRepository;

@Service
public class RepairService {
	
	private RepairRepository repairRepository;
	
	private RepairBookingRepository rbRepository;
	
	private RepairMapper repairMapper;

	public RepairService(RepairRepository repairRepository, RepairBookingRepository rbRepository,
			RepairMapper repairMapper) {
		this.repairRepository = repairRepository;
		this.rbRepository = rbRepository;
		this.repairMapper = repairMapper;
	}
	
	public ResponseEntity<RepairDto> getRepair(Long id) {
		
		Repair repair = repairRepository.findById(id).get();
		
		return ResponseEntity.ok(repairMapper.toDto(repair));
	}

	public ResponseEntity<Void> addRepair(Long id, NewRepairDto newRepair) {
		
		RepairBooking repairBooking = rbRepository.findById(id).get();
		
		repairRepository.save(repairMapper.toNewEntity(newRepair, repairBooking));
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteRepair(Long id) {
		
		repairRepository.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editRepair(Long id, RepairDto repairDto) {
		
		Repair repair = repairRepository.findById(id).get();
		
		repairMapper.updateEntity(repairDto, repair);
		repairRepository.save(repair);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
