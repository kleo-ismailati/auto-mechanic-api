package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.BookingCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.BookingUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.BookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingSummaryDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.BookingPageDto;
import org.springframework.http.ResponseEntity;

public interface BookingService {
    ResponseEntity<BookingPageDto> getAllBookings(int page, int size);

    ResponseEntity<BookingPageDto> getUnfinishedBookings(int pageOptional, int sizeOptional);

    ResponseEntity<BookingDto> getBooking(Long id);

    ResponseEntity<BookingSummaryDto> viewBooking(String refID);

    ResponseEntity<Void> addBooking(BookingCreateDto newBooking);

    ResponseEntity<Void> deleteBooking(Long id);

    ResponseEntity<Void> editBooking(Long id, BookingUpdateDto bookingDto);
}
