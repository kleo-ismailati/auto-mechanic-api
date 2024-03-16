package com.auto_mechanic.auto_mechanic_api.api.service;

import com.auto_mechanic.auto_mechanic_api.api.dto.auto.AutoDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.auto.auto_edit.AutoEditDto;
import com.auto_mechanic.auto_mechanic_api.api.mapper.AutoMapper;
import com.auto_mechanic.auto_mechanic_api.api.model.Auto;
import com.auto_mechanic.auto_mechanic_api.api.repository.AutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AutoService {

    private final AutoRepository autoRepository;
    private final AutoMapper autoMapper;

    public AutoService(AutoRepository autoRepository,
                       AutoMapper autoMapper) {
        this.autoRepository = autoRepository;
        this.autoMapper = autoMapper;
    }

    public ResponseEntity<AutoDto> getAuto(Long id) {

        Auto auto = autoRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(autoMapper.toDto(auto));
    }

    public ResponseEntity<Void> editAuto(Long id, AutoEditDto autoDto) {

        Auto auto = autoRepository.findById(id).orElseThrow();

        autoMapper.updateEntity(autoDto, auto);

        autoRepository.save(auto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
