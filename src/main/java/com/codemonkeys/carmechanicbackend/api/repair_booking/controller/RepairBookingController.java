package com.codemonkeys.carmechanicbackend.api.repair_booking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.RepairBookingViewDto;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.codemonkeys.carmechanicbackend.api.repair_booking.service.RepairBookingService;

@RestController
@RequestMapping("/api/repair_booking")
public class RepairBookingController {
	
	private RepairBookingService repairBookingService;
	
	public RepairBookingController(RepairBookingService repairBookingService) {
		this.repairBookingService = repairBookingService;
	}

	@GetMapping
	public ResponseEntity<List<RepairBookingViewDto>> getAllRepairBookings() {
		return repairBookingService.getAllRepairBookings();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RepairBookingDto> getRepairBooking(@PathVariable("id") Long id) {
		return repairBookingService.getRepairBooking(id);
	}
	
	@PostMapping
	public ResponseEntity<RepairBooking> addRepairBooking(@RequestBody NewRepairBookingDto newRepairBooking) {
		return repairBookingService.addRepairBooking(newRepairBooking);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<RepairBooking> editRepairBooking(@PathVariable("id") Long id, 
			@RequestBody RepairBookingDto repairBookingDto) {
		return repairBookingService.editRepairBooking(id, repairBookingDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RepairBooking> deleteRepairBooking(@PathVariable("id") Long id) {
		return repairBookingService.deleteRepairBooking(id);
	}

}
