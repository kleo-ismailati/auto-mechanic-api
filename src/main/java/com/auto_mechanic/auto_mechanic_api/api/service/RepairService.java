package com.auto_mechanic.auto_mechanic_api.api.service;

import com.auto_mechanic.auto_mechanic_api.api.dto.repair.RepairDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair.repair_edit.RepairEditDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.new_repair_booking.NewRepairDto;
import com.auto_mechanic.auto_mechanic_api.api.mapper.RepairMapper;
import com.auto_mechanic.auto_mechanic_api.api.model.Repair;
import com.auto_mechanic.auto_mechanic_api.api.model.RepairBooking;
import com.auto_mechanic.auto_mechanic_api.api.repository.RepairBookingRepository;
import com.auto_mechanic.auto_mechanic_api.api.repository.RepairRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RepairService {

    private final RepairRepository repairRepository;

    private final RepairBookingRepository rbRepository;

    private final RepairMapper repairMapper;

    public RepairService(RepairRepository repairRepository, RepairBookingRepository rbRepository,
                         RepairMapper repairMapper) {
        this.repairRepository = repairRepository;
        this.rbRepository = rbRepository;
        this.repairMapper = repairMapper;
    }

    public ResponseEntity<RepairDto> getRepair(Long id) {

        Repair repair = repairRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(repairMapper.toDto(repair));
    }

    public ResponseEntity<Void> addRepair(Long id, NewRepairDto newRepair) {

        RepairBooking repairBooking = rbRepository.findById(id).orElseThrow();

        repairRepository.save(repairMapper.toNewEntity(newRepair, repairBooking));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteRepair(Long id) {

        repairRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> editRepair(Long id, RepairEditDto repairDto) {

        Repair repair = repairRepository.findById(id).orElseThrow();

        repairMapper.updateEntity(repairDto, repair);
        repairRepository.save(repair);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
