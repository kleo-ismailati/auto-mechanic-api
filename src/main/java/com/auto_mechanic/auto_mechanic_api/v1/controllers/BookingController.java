package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.BookingCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.BookingUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingSummaryDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.BookingPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.BookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
@Tag(name = "Bookings", description = "Bookings Controller")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    @Operation(summary = "Get all bookings", tags = {"Bookings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking list found"),
            @ApiResponse(responseCode = "404", description = "Booking list not found")
    })
    public ResponseEntity<BookingPageDto> getAllBookings(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size) {
        return bookingService.getAllBookings(page.orElse(0), size.orElse(10));
    }

    @GetMapping(value = "/tbd")
    @Operation(summary = "Get bookings with unfinished repairs", tags = {"Bookings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking list found"),
            @ApiResponse(responseCode = "404", description = "Booking list not found")
    })
    public ResponseEntity<BookingPageDto> getUnfinishedBookings(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size) {
        return bookingService.getUnfinishedBookings(page.orElse(0), size.orElse(10));
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get booking by id", tags = {"Bookings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking found"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<BookingDto> getBooking(@PathVariable("id") Long id) {
        return bookingService.getBooking(id);
    }

    @GetMapping(value = "/view/{refID}")
    @Operation(summary = "Get booking information by reference id", tags = {"Bookings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking found"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<BookingSummaryDto> viewBooking(@PathVariable("refID") String refID) {
        return bookingService.viewBooking(refID);
    }

    @PostMapping
    @Operation(summary = "Add new booking", tags = {"Bookings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Booking added successfully")
    })
    public ResponseEntity<Void> addBooking(@RequestBody BookingCreateDto newBooking) {
        return bookingService.addBooking(newBooking);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update booking by id", tags = {"Bookings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking updated successfully"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<Void> editBooking(@PathVariable("id") Long id,
                                            @RequestBody BookingUpdateDto bookingDto) {
        return bookingService.editBooking(id, bookingDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete booking by id", tags = {"Bookings"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Booking deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Long id) {
        return bookingService.deleteBooking(id);
    }

}
