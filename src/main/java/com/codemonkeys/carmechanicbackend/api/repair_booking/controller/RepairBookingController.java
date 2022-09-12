package com.codemonkeys.carmechanicbackend.api.repair_booking.controller;

import java.util.Optional;

import com.codemonkeys.carmechanicbackend.api.repair_booking.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.api.repair_booking.service.RepairBookingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/repair_booking")
@Tag(name = "Repair Booking", description = "Repair Booking Controller")
public class RepairBookingController {
	
	private final RepairBookingService repairBookingService;
	
	public RepairBookingController(RepairBookingService repairBookingService) {
		this.repairBookingService = repairBookingService;
	}

	@GetMapping
	@Operation(summary = "Get all Repair Bookings", tags = { "Repair Booking" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Repair Bookings List found"),
	  @ApiResponse(responseCode = "404", description = "Repair Bookings List not found") 
	  })
	public ResponseEntity<RepairBookingPageDto> getAllRepairBookings(
			@RequestParam(required = false) Optional<Integer> page, 
			@RequestParam(required = false) Optional<Integer> size) {
		return repairBookingService.getAllRepairBookings(page, size);
	}

	@GetMapping(value = "/tbd")
	@Operation(summary = "Get unfinished Repair Bookings", tags = { "Repair Booking" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Repair Bookings List found"),
			@ApiResponse(responseCode = "404", description = "Repair Bookings List not found")
	})
	public ResponseEntity<RepairBookingPageDto> getUnfinishedRepairBookings(
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(required = false) Optional<Integer> size) {
		return repairBookingService.getUnfinishedRepairBookings(page, size);
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Get Repair Booking by id", tags = { "Repair Booking" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Repair Booking found"),
	  @ApiResponse(responseCode = "404", description = "Repair Booking not found") 
	  })
	public ResponseEntity<RepairBookingViewDto> getRepairBooking(@PathVariable("id") Long id) {
		return repairBookingService.getRepairBooking(id);
	}

	@GetMapping(value = "/view/{refID}")
	@Operation(summary = "Get Repair Booking by reference id", tags = { "Repair Booking" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Repair Booking found"),
			@ApiResponse(responseCode = "404", description = "Repair Booking not found")
	})
	public ResponseEntity<RepairBookingGuestViewDto> viewRepairBooking(@PathVariable("refID") String refID) {
		return repairBookingService.viewRepairBooking(refID);
	}
	
	@PostMapping
	@Operation(summary = "Add new Repair Booking", tags = { "Repair Booking" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "201", description = "Repair Booking added successfully") 
	  })
	public ResponseEntity<Void> addRepairBooking(@RequestBody NewRepairBookingDto newRepairBooking) {
		return repairBookingService.addRepairBooking(newRepairBooking);
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update Repair Booking by id", tags = { "Repair Booking" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Repair Booking updated successfully"),
	  @ApiResponse(responseCode = "404", description = "Repair Booking not found") 
	  })
	public ResponseEntity<Void> editRepairBooking(@PathVariable("id") Long id, 
			@RequestBody RepairBookingEditDto repairBookingDto) {
		return repairBookingService.editRepairBooking(id, repairBookingDto);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete Repair Booking by id", tags = { "Repair Booking" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "204", description = "Repair Booking deleted successfully"),
	  @ApiResponse(responseCode = "404", description = "Repair Booking not found") 
	  })
	public ResponseEntity<Void> deleteRepairBooking(@PathVariable("id") Long id) {
		return repairBookingService.deleteRepairBooking(id);
	}

}
