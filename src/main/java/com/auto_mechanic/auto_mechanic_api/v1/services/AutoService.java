package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.AutoEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.AutoDto;
import org.springframework.http.ResponseEntity;

public interface AutoService {
    ResponseEntity<AutoDto> getAuto(Long id);

    ResponseEntity<Void> editAuto(Long id, AutoEditDto autoDto);
}
