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

import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientEditDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.NewClientDto;
import com.codemonkeys.carmechanicbackend.api.client.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/client")
@Tag(name = "Client", description = "Client Controller")
public class ClientController {
	

	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Get Client by id", tags = { "Client" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Client found"),
	  @ApiResponse(responseCode = "404", description = "Client not found") 
	  })
	public ResponseEntity<ClientDto> getClient(@PathVariable("id") Long id) {
		return clientService.getClient(id);
	}
	
	@PostMapping
	@Operation(summary = "Add new Client", tags = { "Client" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "201", description = "Client added successfully")
	  })
	public ResponseEntity<Void> addClient(@RequestBody NewClientDto newClient) {
		return clientService.addClient(newClient);
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update Client by id", tags = { "Client" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Client updated successfully"),
	  @ApiResponse(responseCode = "404", description = "Client not found") 
	  })
	public ResponseEntity<Void> editClient(@PathVariable("id") Long id, 
			@RequestBody ClientEditDto clientDto) {
		return clientService.editClient(id, clientDto);
	}
	
	@PostMapping(value = "/{id}/addCar")
	@Operation(summary = "Add new Car to a Client", tags = { "Client" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "201", description = "Car added successfully")
	  })
	public ResponseEntity<Void> addCar(@PathVariable("id") Long id, @RequestBody NewCarDto newCar) {
		return clientService.addCar(id, newCar);
	}
	
//	@DeleteMapping(value = "/{id}")
//	@Operation(summary = "Delete Client by id", tags = { "Client" })
//	@ApiResponses(value = {
//	  @ApiResponse(responseCode = "204", description = "Client deleted successfully"),
//	  @ApiResponse(responseCode = "404", description = "Client not found") 
//	  })
//	public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
//		return clientService.deleteClient(id);
//	}

}
