package com.codemonkeys.carmechanicbackend.api.client.service;

import com.codemonkeys.carmechanicbackend.api.client.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.client.mapper.ClientMapper;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.client.repository.ClientRepository;

import java.util.Optional;

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

	public ResponseEntity<ClientPageDto> getAllClients(Optional<Integer> pageOptional,
														Optional<Integer> sizeOptional) {
		int page = 0;
		int size = 10;

		if(pageOptional.isPresent()) {
			page = pageOptional.get();
		}

		if(sizeOptional.isPresent()) {
			size = sizeOptional.get();
		}

		Page<Client> clients =
				clientRepository.findAll(
						PageRequest.of(page, size)
				);

		return ResponseEntity.ok(clientMapper.toClientPage(clients));
	}
}
