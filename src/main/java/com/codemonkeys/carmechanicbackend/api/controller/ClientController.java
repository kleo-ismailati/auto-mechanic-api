package com.codemonkeys.carmechanicbackend.api.controller;

import com.codemonkeys.carmechanicbackend.api.dto.client.ClientDto;
import com.codemonkeys.carmechanicbackend.api.dto.client.client_edit.ClientEditDto;
import com.codemonkeys.carmechanicbackend.api.dto.client.client_list.ClientPageDto;
import com.codemonkeys.carmechanicbackend.api.dto.client.new_client.NewClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codemonkeys.carmechanicbackend.api.dto.car.new_car.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Optional;

@RestController
@RequestMapping("/api/client")
@Tag(name = "Client", description = "Client Controller")
public class ClientController {
	

	private final ClientService clientService;
	
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


	@GetMapping
	@Operation(summary = "Get Client list", tags = { "Client" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Client list found"),
			@ApiResponse(responseCode = "404", description = "Client list not found")
	})
	public ResponseEntity<ClientPageDto> getClientList(
			@RequestParam(required = false) Optional<Integer> page,
			@RequestParam(required = false) Optional<Integer> size
	) {
		return clientService.getAllClients(page, size);
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

}
