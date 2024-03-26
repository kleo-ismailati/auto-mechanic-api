package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.AutoUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.AutoDto;
import com.auto_mechanic.auto_mechanic_api.v1.mappers.AutoMapper;
import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;
    private final AutoMapper autoMapper;

    public AutoServiceImpl(AutoRepository autoRepository,
                           AutoMapper autoMapper) {
        this.autoRepository = autoRepository;
        this.autoMapper = autoMapper;
    }

    public ResponseEntity<AutoDto> getAuto(Long id) {

        Optional<Auto> autoOptional = autoRepository.findById(id);

        if (autoOptional.isPresent()) {
            Auto auto = autoOptional.get();
            return ResponseEntity.ok(autoMapper.toDto(auto));
        }

        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<Void> editAuto(Long id, AutoUpdateDto autoDto) {

        Auto auto = autoRepository.findById(id).orElseThrow();

        autoMapper.updateEntity(autoDto, auto);

        autoRepository.save(auto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
