package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewRepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.RepairBookingEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairBookingGuestViewDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages.RepairBookingPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.RepairBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/repair_booking")
@Tag(name = "Repair Booking", description = "Repair Booking Controller")
public class RepairBookingController {

    private final RepairBookingService repairBookingService;

    public RepairBookingController(RepairBookingService repairBookingService) {
        this.repairBookingService = repairBookingService;
    }

    @GetMapping
    @Operation(summary = "Get all Repair Bookings", tags = {"Repair Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair Bookings List found"),
            @ApiResponse(responseCode = "404", description = "Repair Bookings List not found")
    })
    public ResponseEntity<RepairBookingPageDto> getAllRepairBookings(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size) {
        return repairBookingService.getAllRepairBookings(page.orElse(0), size.orElse(10));
    }

    @GetMapping(value = "/tbd")
    @Operation(summary = "Get unfinished Repair Bookings", tags = {"Repair Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair Bookings List found"),
            @ApiResponse(responseCode = "404", description = "Repair Bookings List not found")
    })
    public ResponseEntity<RepairBookingPageDto> getUnfinishedRepairBookings(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size) {
        return repairBookingService.getUnfinishedRepairBookings(page.orElse(0), size.orElse(10));
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get Repair Booking by id", tags = {"Repair Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair Booking found"),
            @ApiResponse(responseCode = "404", description = "Repair Booking not found")
    })
    public ResponseEntity<RepairBookingDto> getRepairBooking(@PathVariable("id") Long id) {
        return repairBookingService.getRepairBooking(id);
    }

    @GetMapping(value = "/view/{refID}")
    @Operation(summary = "Get Repair Booking Information by reference id", tags = {"Repair Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair Booking found"),
            @ApiResponse(responseCode = "404", description = "Repair Booking not found")
    })
    public ResponseEntity<RepairBookingGuestViewDto> viewRepairBookingAsGuest(@PathVariable("refID") String refID) {
        return repairBookingService.viewRepairBookingAsGuest(refID);
    }

    @PostMapping
    @Operation(summary = "Add new Repair Booking", tags = {"Repair Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Repair Booking added successfully")
    })
    public ResponseEntity<Void> addRepairBooking(@RequestBody NewRepairBookingDto newRepairBooking) {
        return repairBookingService.addRepairBooking(newRepairBooking);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update Repair Booking by id", tags = {"Repair Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair Booking updated successfully"),
            @ApiResponse(responseCode = "404", description = "Repair Booking not found")
    })
    public ResponseEntity<Void> editRepairBooking(@PathVariable("id") Long id,
                                                  @RequestBody RepairBookingEditDto repairBookingDto) {
        return repairBookingService.editRepairBooking(id, repairBookingDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete Repair Booking by id", tags = {"Repair Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Repair Booking deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Repair Booking not found")
    })
    public ResponseEntity<Void> deleteRepairBooking(@PathVariable("id") Long id) {
        return repairBookingService.deleteRepairBooking(id);
    }

}
