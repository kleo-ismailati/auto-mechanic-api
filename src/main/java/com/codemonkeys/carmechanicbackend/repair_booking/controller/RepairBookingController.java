package com.codemonkeys.carmechanicbackend.repair_booking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair_booking.NewRepairBookingDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair_booking.RepairBookingDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.repair_booking.RepairBookingViewDto;
import com.codemonkeys.carmechanicbackend.repair_booking.service.RepairBookingService;

@RestController
@RequestMapping("/repair_booking")
public class RepairBookingController {
	
	private RepairBookingService repairBookingService;
	
	public RepairBookingController(RepairBookingService repairBookingService) {
		this.repairBookingService = repairBookingService;
	}

	@GetMapping
	public List<RepairBookingViewDto> getAllRepairBookings() {
		return repairBookingService.getAllRepairBookings();
	}
	
	@GetMapping(value = "/{id}")
	public RepairBookingDto getRepairBooking(@PathVariable("id") String id) {
		return repairBookingService.getRepairBooking(id);
	}
	
	@PostMapping
	public void addRepairBooking(@RequestBody NewRepairBookingDto newRepairBooking) {
		repairBookingService.addRepairBooking(newRepairBooking);
	}
	
	@PutMapping(value = "/{id}")
	public void editRepairBooking(@PathVariable("id") String id, @RequestBody RepairBookingDto repairBookingDto) {
		repairBookingService.editRepairBooking(id, repairBookingDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteRepairBooking(@PathVariable("id") String id) {
		repairBookingService.deleteRepairBooking(id);
	}

}
