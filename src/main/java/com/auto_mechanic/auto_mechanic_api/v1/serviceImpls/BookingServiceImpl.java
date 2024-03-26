package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.BookingCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.BookingUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.BookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.BookingSummaryDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.BookingPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.v1.mappers.BookingMapper;
import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Booking;
import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import com.auto_mechanic.auto_mechanic_api.v1.models.EmailDetails;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.BookingRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.ClientRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.BookingService;
import com.auto_mechanic.auto_mechanic_api.v1.services.EmailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;

    private final ClientRepository clientRepository;

    private final AutoRepository autoRepository;

    private final EmailService emailService;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            BookingMapper bookingMapper,
            ClientRepository clientRepository,
            AutoRepository autoRepository,
            EmailService emailService) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.clientRepository = clientRepository;
        this.autoRepository = autoRepository;
        this.emailService = emailService;
    }

    public ResponseEntity<BookingPageDto> getAllBookings(int page, int size) {

        Page<Booking> bookings = bookingRepository.findAll(PageRequest.of(page, size));

        return ResponseEntity.ok(bookingMapper.toBookingPageDto(bookings));
    }

    public ResponseEntity<BookingPageDto> getUnfinishedBookings(int page, int size) {

        Page<Booking> bookings =
                bookingRepository.findAllByStatusOrStatus(
                        RepairStatusEnum.toBeDone, RepairStatusEnum.inProgress,
                        PageRequest.of(page, size)
                );

        return ResponseEntity.ok(bookingMapper.toBookingPageDto(bookings));
    }

    public ResponseEntity<BookingDto> getBooking(Long id) {

        Booking booking = bookingRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(bookingMapper.toDto(booking));
    }

    public ResponseEntity<BookingSummaryDto> viewBooking(String refID) {

        Booking booking = bookingRepository.findFirstByRefID(refID).orElseThrow();

        return ResponseEntity.ok(bookingMapper.toBookingSummaryDto(booking));
    }

    public ResponseEntity<Void> addBooking(BookingCreateDto newBooking) {

        Client client = clientRepository.findById(newBooking.getClientId()).orElseThrow();

        Auto auto = autoRepository.findById(newBooking.getAutoId()).orElseThrow();

        for (Auto aAuto : client.getAutos()) {
            if (aAuto.getId().equals(auto.getId())) {
                Booking booking = bookingMapper.toNewEntity(newBooking, client, auto);

                bookingRepository.save(booking);

                emailService.sendSimpleMail(new EmailDetails(
                        client.getEmail(), booking.getRefID(), "Your Reference Code"
                ));

                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Void> deleteBooking(Long id) {

        bookingRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> editBooking(Long id, BookingUpdateDto bookingDto) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            bookingMapper.updateEntity(bookingDto, booking);
            bookingRepository.save(booking);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
