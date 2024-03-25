package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.RepairEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairDto;
import org.springframework.http.ResponseEntity;

public interface RepairService {
    ResponseEntity<RepairDto> getRepair(Long id);

    ResponseEntity<Void> addRepair(Long id, NewRepairDto newRepair);

    ResponseEntity<Void> deleteRepair(Long id);

    ResponseEntity<Void> editRepair(Long id, RepairEditDto repairDto);
}
