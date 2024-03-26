package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.RepairCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.RepairUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.RepairDto;
import org.springframework.http.ResponseEntity;

public interface RepairService {
    ResponseEntity<RepairDto> getRepair(Long id);

    ResponseEntity<Void> addRepair(Long id, RepairCreateDto newRepair);

    ResponseEntity<Void> deleteRepair(Long id);

    ResponseEntity<Void> editRepair(Long id, RepairUpdateDto repairDto);
}
