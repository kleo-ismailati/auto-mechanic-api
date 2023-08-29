package com.auto_mechanic.auto_mechanic_api.api.service;

import com.auto_mechanic.auto_mechanic_api.api.dto.auto.AutoDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.auto.auto_edit.AutoEditDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.auto.new_auto.NewAutoDto;
import com.auto_mechanic.auto_mechanic_api.api.repository.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.api.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auto_mechanic.auto_mechanic_api.api.mapper.AutoMapper;
import com.auto_mechanic.auto_mechanic_api.api.model.Auto;
import com.auto_mechanic.auto_mechanic_api.api.model.Client;

@Service
public class AutoService {
	
	private final AutoRepository autoRepository;
	private final ClientRepository clientRepository;
	
	private final AutoMapper autoMapper;

	public AutoService(AutoRepository autoRepository, ClientRepository clientRepository,
			AutoMapper autoMapper) {
		this.autoRepository = autoRepository;
		this.clientRepository = clientRepository;
		this.autoMapper = autoMapper;
	}
	
	public ResponseEntity<AutoDto> getAuto(Long id) {
		
		Auto auto = autoRepository.findById(id).get();
		
		return ResponseEntity.ok(autoMapper.toDto(auto));
	}

	public ResponseEntity<Void> addAuto(Long id, NewAutoDto newAuto) {
		
		Client client = clientRepository.findById(id).get();
		
		autoRepository.save(autoMapper.toNewEntity(newAuto, client));
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteAuto(Long id) {
		
		autoRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editAuto(Long id, AutoEditDto autoDto) {
		
		Auto auto = autoRepository.findById(id).get();
		
		autoMapper.updateEntity(autoDto, auto);
		
		autoRepository.save(auto);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
