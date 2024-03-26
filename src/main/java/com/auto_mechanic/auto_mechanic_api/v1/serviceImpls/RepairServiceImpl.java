package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.RepairCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.RepairUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.RepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.mappers.RepairMapper;
import com.auto_mechanic.auto_mechanic_api.v1.models.Booking;
import com.auto_mechanic.auto_mechanic_api.v1.models.Repair;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.BookingRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.RepairRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.RepairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;

    private final BookingRepository rbRepository;

    private final RepairMapper repairMapper;

    public RepairServiceImpl(RepairRepository repairRepository, BookingRepository rbRepository,
                             RepairMapper repairMapper) {
        this.repairRepository = repairRepository;
        this.rbRepository = rbRepository;
        this.repairMapper = repairMapper;
    }

    public ResponseEntity<RepairDto> getRepair(Long id) {

        Repair repair = repairRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(repairMapper.toDto(repair));
    }

    public ResponseEntity<Void> addRepair(Long id, RepairCreateDto newRepair) {

        Booking booking = rbRepository.findById(id).orElseThrow();

        repairRepository.save(repairMapper.toNewEntity(newRepair, booking));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteRepair(Long id) {

        repairRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> editRepair(Long id, RepairUpdateDto repairDto) {

        Repair repair = repairRepository.findById(id).orElseThrow();

        repairMapper.updateEntity(repairDto, repair);
        repairRepository.save(repair);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
