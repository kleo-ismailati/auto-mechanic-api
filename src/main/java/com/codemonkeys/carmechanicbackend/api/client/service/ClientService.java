package com.codemonkeys.carmechanicbackend.api.client.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientEditDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.NewClientDto;
import com.codemonkeys.carmechanicbackend.api.client.mapper.ClientMapper;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.client.repository.ClientRepository;

@Service
public class ClientService {
	
	private final ClientRepository clientRepository;
	
	private final ClientMapper clientMapper;

	public ClientService(ClientRepository clientRepository, 
			ClientMapper clientMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
	}
	
	public ResponseEntity<ClientDto> getClient(Long id) {
		
		Client client = clientRepository.findById(id).get();
		
		return ResponseEntity.ok(clientMapper.toDto(client));
	}

	public ResponseEntity<Void> addClient(NewClientDto newClient) {
		
		clientRepository.save(clientMapper.toNewEntity(newClient));
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteClient(Long id) {
		
		clientRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editClient(Long id, ClientEditDto clientDto) {
		
		Client client = clientRepository.findById(id).get();
		clientMapper.updateEntity(clientDto, client);
		clientRepository.save(client);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> addCar(Long id, NewCarDto newCarDto) {
		
		Client client = clientRepository.findById(id).get();
		clientMapper.addCar(newCarDto, client);
		clientRepository.save(client);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
