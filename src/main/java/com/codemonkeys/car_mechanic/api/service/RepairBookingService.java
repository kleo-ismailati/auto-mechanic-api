package com.codemonkeys.car_mechanic.api.service;

import java.util.Optional;

import com.codemonkeys.car_mechanic.api.dto.repair_booking.new_repair_booking.NewRepairBookingDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_edit.RepairBookingEditDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_guest.RepairBookingGuestViewDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_list.RepairBookingPageDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.RepairBookingDto;
import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.car_mechanic.api.model.Car;
import com.codemonkeys.car_mechanic.api.repository.CarRepository;
import com.codemonkeys.car_mechanic.api.model.Client;
import com.codemonkeys.car_mechanic.api.repository.ClientRepository;
import com.codemonkeys.car_mechanic.api.mapper.RepairBookingMapper;
import com.codemonkeys.car_mechanic.api.model.RepairBooking;
import com.codemonkeys.car_mechanic.api.repository.RepairBookingRepository;

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
		
		return ResponseEntity.ok(repairBookingMapper.toViewPage(repairBookings));
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

		return ResponseEntity.ok(repairBookingMapper.toViewPage(repairBookings));
	}
	
	public ResponseEntity<RepairBookingDto> getRepairBooking(Long id) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id).get();
		
		return ResponseEntity.ok(repairBookingMapper.toViewDto(repairBooking));
	}

	public ResponseEntity<RepairBookingGuestViewDto> viewRepairBooking(String refID) {

		RepairBooking repairBooking = repairBookingRepository.findFirstByRefID(refID).get();

		return ResponseEntity.ok(repairBookingMapper.toGuestViewDto(repairBooking));
	}

	public ResponseEntity<Void> addRepairBooking(NewRepairBookingDto newRepairBooking) {
		
		Client client = clientRepository.findById(newRepairBooking.getClientId()).get();
		
		Car car = carRepository.findById(newRepairBooking.getCarId()).get();

		for (Car aCar : client.getCars()){
			if(aCar.getId().equals(car.getId())){
				repairBookingRepository.save(repairBookingMapper.toNewEntity(newRepairBooking, client, car));

				return new ResponseEntity<>(HttpStatus.CREATED);
			}
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<Void> deleteRepairBooking(Long id) {
		
		repairBookingRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editRepairBooking(Long id, RepairBookingEditDto repairBookingDto) {
		
		RepairBooking repairBooking = repairBookingRepository.findById(id).get();
		repairBookingMapper.updateEntity(repairBookingDto, repairBooking);
		repairBookingRepository.save(repairBooking);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
