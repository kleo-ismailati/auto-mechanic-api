package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.AutoCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.ClientCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.ClientUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.ClientPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.ClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description = "Clients Controller")
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get client by id", tags = {"Clients"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<ClientDto> getClient(@PathVariable("id") Long id) {
        return clientService.getClient(id);
    }


    @GetMapping
    @Operation(summary = "Get client list", tags = {"Clients"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client list found"),
            @ApiResponse(responseCode = "404", description = "Client list not found")
    })
    public ResponseEntity<ClientPageDto> getClientList(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size
    ) {
        return clientService.getAllClients(page.orElse(0), size.orElse(10));
    }

    @PostMapping
    @Operation(summary = "Add new client", tags = {"Clients"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client added successfully")
    })
    public ResponseEntity<Void> addClient(@RequestBody ClientCreateDto newClient) {
        return clientService.addClient(newClient);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update client by id", tags = {"Clients"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client updated successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<Void> editClient(@PathVariable("id") Long id,
                                           @RequestBody ClientUpdateDto clientDto) {
        return clientService.editClient(id, clientDto);
    }

    @PostMapping(value = "/{id}/addAuto")
    @Operation(summary = "Add new auto to a client", tags = {"Clients"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Auto added successfully")
    })
    public ResponseEntity<Void> addAuto(@PathVariable("id") Long id, @RequestBody AutoCreateDto newAuto) {
        return clientService.addAuto(id, newAuto);
    }

}
