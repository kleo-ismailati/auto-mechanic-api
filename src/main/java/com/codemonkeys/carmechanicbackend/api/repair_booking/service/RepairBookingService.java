package com.codemonkeys.carmechanicbackend.api.repair_booking.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.car.repository.CarRepository;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.client.repository.ClientRepository;
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
	
	private ClientRepository clientRepository;
	
	private CarRepository carRepository;

	public RepairBookingService(
			RepairBookingRepository repairBookingRepository, 
			RepairBookingMapper repairBookingMapper,
			ClientRepository clientRepository,
			CarRepository carRepository
			) {
		this.repairBookingRepository = repairBookingRepository;
		this.repairBookingMapper = repairBookingMapper;
		this.clientRepository = clientRepository;
		this.carRepository = carRepository;
	}

	public ResponseEntity<List<RepairBookingViewDto>> getAllRepairBookings() {

		List<RepairBooking> repairBookings = repairBookingRepository.findAll();
		return ResponseEntity.ok(repairBookingMapper.toViewDtoList(repairBookings));
	}
	
	public ResponseEntity<RepairBookingDto> getRepairBooking(Long id) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id).get();
		
		return ResponseEntity.ok(repairBookingMapper.toDto(repairBooking));
	}

	public ResponseEntity<Void> addRepairBooking(NewRepairBookingDto newRepairBooking) {
		
		Client client = clientRepository.findById(newRepairBooking.getClientId()).get();
		
		Car car = carRepository.findById(newRepairBooking.getCarId()).get();
		
		repairBookingRepository.save(repairBookingMapper.toNewEntity(newRepairBooking, client, car));
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteRepairBooking(Long id) {
		
		repairBookingRepository.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editRepairBooking(Long id, RepairBookingDto repairBookingDto) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id).get();
		repairBookingMapper.updateEntity(repairBookingDto, repairBooking);
		repairBookingRepository.save(repairBooking);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
