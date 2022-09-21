package com.codemonkeys.carmechanicbackend.api.service;

import com.codemonkeys.carmechanicbackend.api.dto.repair.RepairDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.dto.repair_booking.new_repair_booking.NewRepairDto;
import com.codemonkeys.carmechanicbackend.api.dto.repair.repair_edit.RepairEditDto;
import com.codemonkeys.carmechanicbackend.api.mapper.RepairMapper;
import com.codemonkeys.carmechanicbackend.api.model.Repair;
import com.codemonkeys.carmechanicbackend.api.repository.RepairRepository;
import com.codemonkeys.carmechanicbackend.api.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.repository.RepairBookingRepository;

@Service
public class RepairService {
	
	private final RepairRepository repairRepository;
	
	private final RepairBookingRepository rbRepository;
	
	private final RepairMapper repairMapper;

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
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteRepair(Long id) {
		
		repairRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editRepair(Long id, RepairEditDto repairDto) {
		
		Repair repair = repairRepository.findById(id).get();
		
		repairMapper.updateEntity(repairDto, repair);
		repairRepository.save(repair);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
