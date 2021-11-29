package com.codemonkeys.carmechanicbackend.api.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.api.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.NewClientDto;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	

	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDto> getClient(@PathVariable("id") Long id) {
		return clientService.getClient(id);
	}
	
	@PostMapping
	public ResponseEntity<Client> addClient(@RequestBody NewClientDto newClient) {
		return clientService.addClient(newClient);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> editClient(@PathVariable("id") Long id, 
			@RequestBody ClientDto clientDto) {
		return clientService.editClient(id, clientDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id) {
		return clientService.deleteClient(id);
	}

}
