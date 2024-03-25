package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewRepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.RepairBookingEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairBookingGuestViewDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages.RepairBookingPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.v1.mappers.RepairBookingMapper;
import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import com.auto_mechanic.auto_mechanic_api.v1.models.EmailDetails;
import com.auto_mechanic.auto_mechanic_api.v1.models.RepairBooking;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.ClientRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.RepairBookingRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.EmailService;
import com.auto_mechanic.auto_mechanic_api.v1.services.RepairBookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepairBookingServiceImpl implements RepairBookingService {

    private final RepairBookingRepository repairBookingRepository;

    private final RepairBookingMapper repairBookingMapper;

    private final ClientRepository clientRepository;

    private final AutoRepository autoRepository;

    private final EmailService emailService;

    public RepairBookingServiceImpl(
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

    public ResponseEntity<RepairBookingPageDto> getAllRepairBookings(int page, int size) {

        Page<RepairBooking> repairBookings = repairBookingRepository.findAll(PageRequest.of(page, size));

        return ResponseEntity.ok(repairBookingMapper.toViewPage(repairBookings));
    }

    public ResponseEntity<RepairBookingPageDto> getUnfinishedRepairBookings(int page, int size) {

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
