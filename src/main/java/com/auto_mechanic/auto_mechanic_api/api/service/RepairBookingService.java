package com.auto_mechanic.auto_mechanic_api.api.service;

import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.RepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.new_repair_booking.NewRepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_edit.RepairBookingEditDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_guest.RepairBookingGuestViewDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_list.RepairBookingPageDto;
import com.auto_mechanic.auto_mechanic_api.api.mapper.RepairBookingMapper;
import com.auto_mechanic.auto_mechanic_api.api.model.Auto;
import com.auto_mechanic.auto_mechanic_api.api.model.Client;
import com.auto_mechanic.auto_mechanic_api.api.model.RepairBooking;
import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.api.repository.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.api.repository.ClientRepository;
import com.auto_mechanic.auto_mechanic_api.api.repository.RepairBookingRepository;
import com.auto_mechanic.auto_mechanic_api.email.model.EmailDetails;
import com.auto_mechanic.auto_mechanic_api.email.service.EmailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepairBookingService {

    private final RepairBookingRepository repairBookingRepository;

    private final RepairBookingMapper repairBookingMapper;

    private final ClientRepository clientRepository;

    private final AutoRepository autoRepository;

    private final EmailService emailService;

    public RepairBookingService(
            RepairBookingRepository repairBookingRepository,
            RepairBookingMapper repairBookingMapper,
            ClientRepository clientRepository,
            AutoRepository autoRepository,
            EmailService emailService) {
        this.repairBookingRepository = repairBookingRepository;
        this.repairBookingMapper = repairBookingMapper;
        this.clientRepository = clientRepository;
        this.autoRepository = autoRepository;
        this.emailService = emailService;
    }

    public ResponseEntity<RepairBookingPageDto> getAllRepairBookings(
            Optional<Integer> pageOptional,
            Optional<Integer> sizeOptional) {

        int page = 0;
        int size = 10;

        if (pageOptional.isPresent()) {
            page = pageOptional.get();
        }

        if (sizeOptional.isPresent()) {
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

        if (pageOptional.isPresent()) {
            page = pageOptional.get();
        }

        if (sizeOptional.isPresent()) {
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

        RepairBooking repairBooking = repairBookingRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(repairBookingMapper.toViewDto(repairBooking));
    }

    public ResponseEntity<RepairBookingGuestViewDto> viewRepairBookingAsGuest(String refID) {

        RepairBooking repairBooking = repairBookingRepository.findFirstByRefID(refID).orElseThrow();

        return ResponseEntity.ok(repairBookingMapper.toGuestViewDto(repairBooking));
    }

    public ResponseEntity<Void> addRepairBooking(NewRepairBookingDto newRepairBooking) {

        Client client = clientRepository.findById(newRepairBooking.getClientId()).orElseThrow();

        Auto auto = autoRepository.findById(newRepairBooking.getAutoId()).orElseThrow();

        for (Auto aAuto : client.getAutos()) {
            if (aAuto.getId().equals(auto.getId())) {
                RepairBooking booking = repairBookingMapper.toNewEntity(newRepairBooking, client, auto);

                repairBookingRepository.save(booking);

                emailService.sendSimpleMail(new EmailDetails(
                        client.getEmail(), booking.getRefID(), "Your Reference Code"
                ));

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
        Optional<RepairBooking> repairBookingOptional = repairBookingRepository.findById(id);
        if (repairBookingOptional.isPresent()) {
            RepairBooking repairBooking = repairBookingOptional.get();
            repairBookingMapper.updateEntity(repairBookingDto, repairBooking);
            repairBookingRepository.save(repairBooking);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
