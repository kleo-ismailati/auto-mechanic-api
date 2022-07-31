package com.codemonkeys.carmechanicbackend.api.repair.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.car.repository.CarRepository;
import com.codemonkeys.carmechanicbackend.api.repair.dto.NewRepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.mapper.RepairMapper;
import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;
import com.codemonkeys.carmechanicbackend.api.repair.repository.RepairRepository;

@Service
public class RepairService {
	
	private RepairRepository repairRepository;
	
	private CarRepository carRepository;
	
	private RepairMapper repairMapper;

	public RepairService(RepairRepository repairRepository, CarRepository carRepository,
			RepairMapper repairMapper) {
		this.repairRepository = repairRepository;
		this.carRepository = carRepository;
		this.repairMapper = repairMapper;
	}
	
	public ResponseEntity<RepairDto> getRepair(Long id) {
		
		Repair repair = repairRepository.findById(id).get();
		
		return ResponseEntity.ok(repairMapper.toDto(repair));
	}

	public ResponseEntity<Void> addRepair(NewRepairDto newRepair, Long id) {
		
		Car car = carRepository.findById(id).get();
		
		repairRepository.save(repairMapper.toNewEntity(newRepair, car));
		
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
