package com.codemonkeys.carmechanicbackend.api.client.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.NewClientDto;
import com.codemonkeys.carmechanicbackend.api.client.mapper.ClientMapper;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.client.repository.ClientRepository;
import com.codemonkeys.carmechanicbackend.api.exception.ResourceNotFoundException;

@Service
public class ClientService {
	
	private ClientRepository clientRepository;
	
	private ClientMapper clientMapper;

	public ClientService(ClientRepository clientRepository, 
			ClientMapper clientMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
	}
	
	public ResponseEntity<ClientDto> getClient(Long id) {
		
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client with id: " + id + " not found!"));
		
		return ResponseEntity.ok(clientMapper.toDto(client));
	}

	public ResponseEntity<Client> addClient(NewClientDto newClient) {
		
		clientRepository.save(clientMapper.toNewEntity(newClient));
		
		return new ResponseEntity<Client>(HttpStatus.CREATED);
	}

	public ResponseEntity<Client> deleteClient(Long id) {
		
		clientRepository.deleteById(id);
		
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Client> editClient(Long id, ClientDto clientDto) {
		
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Car with id: " + id + " not found!"));
		clientMapper.updateEntity(clientDto, client);
		clientRepository.save(client);
		
		return new ResponseEntity<Client>(HttpStatus.OK);
	}

}
