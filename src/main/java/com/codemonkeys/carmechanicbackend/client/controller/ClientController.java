package com.codemonkeys.carmechanicbackend.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.client.NewClientDto;
import com.codemonkeys.carmechanicbackend.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.client.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	@ResponseBody
	public List<ClientDto> getAllClients() {
		return clientService.getAllClients();
	}
	
	@GetMapping(value = "/{id}")
	public ClientDto getClient(@PathVariable("id") String id) {
		return clientService.getClient(id);
	}
	
	@PostMapping
	public void addAdmin(@RequestBody NewClientDto newClient) {
		clientService.addAdmin(newClient);
	}
	
	@PutMapping(value = "/{id}")
	public void editAdmin(@PathVariable("id") String id, @RequestBody NewClientDto clientDto) {
		clientService.editClient(id, clientDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAdmin(@PathVariable("id") String id) {
		clientService.deleteClient(id);
	}

}
