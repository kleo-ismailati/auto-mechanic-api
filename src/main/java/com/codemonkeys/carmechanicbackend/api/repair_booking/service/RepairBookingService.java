package com.codemonkeys.carmechanicbackend.api.repair_booking.service;

import java.util.Optional;

import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.car.repository.CarRepository;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.client.repository.ClientRepository;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingEditDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingPageDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingViewDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.mapper.RepairBookingMapper;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.repair_booking.repository.RepairBookingRepository;

@Service
public class RepairBookingService {
	
	private final RepairBookingRepository repairBookingRepository;
	
	private final RepairBookingMapper repairBookingMapper;
	
	private final ClientRepository clientRepository;
	
	private final CarRepository carRepository;

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

	public ResponseEntity<RepairBookingPageDto> getAllRepairBookings(
			Optional<Integer> pageOptional, 
			Optional<Integer> sizeOptional) {
		
		int page = 0;
		int size = 10;
		
		if(pageOptional.isPresent()) {
			page = pageOptional.get();
		}
		
		if(sizeOptional.isPresent()) {
			size = sizeOptional.get();
		}

		Page<RepairBooking> repairBookings = repairBookingRepository.findAll(PageRequest.of(page, size));
		
		return ResponseEntity.ok(repairBookingMapper.toViewDtoList(repairBookings));
	}

	public ResponseEntity<RepairBookingPageDto> getUnfinishedRepairBookings(
			Optional<Integer> pageOptional,
			Optional<Integer> sizeOptional
	) {
		int page = 0;
		int size = 10;

		if(pageOptional.isPresent()) {
			page = pageOptional.get();
		}

		if(sizeOptional.isPresent()) {
			size = sizeOptional.get();
		}

		Page<RepairBooking> repairBookings =
				repairBookingRepository.findAllByStatusOrStatus(
						RepairStatusEnum.toBeDone, RepairStatusEnum.inProgress,
						PageRequest.of(page, size)
				);

		return ResponseEntity.ok(repairBookingMapper.toViewDtoList(repairBookings));
	}
	
	public ResponseEntity<RepairBookingViewDto> getRepairBooking(Long id) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id).get();
		
		return ResponseEntity.ok(repairBookingMapper.toViewDto(repairBooking));
	}

	public ResponseEntity<RepairBookingViewDto> viewRepairBooking(String refID) {

		RepairBooking repairBooking = repairBookingRepository.findFirstByRefID(refID).get();

		return ResponseEntity.ok(repairBookingMapper.toViewDto(repairBooking));
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

	public ResponseEntity<Void> editRepairBooking(Long id, RepairBookingEditDto repairBookingDto) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id).get();
		repairBookingMapper.updateEntity(repairBookingDto, repairBooking);
		repairBookingRepository.save(repairBooking);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
