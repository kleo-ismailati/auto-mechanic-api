package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.AutoCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.ClientCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.ClientUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.ClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.ClientPageDto;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<ClientDto> getClient(Long id);

    ResponseEntity<Void> addClient(ClientCreateDto newClient);

    ResponseEntity<Void> editClient(Long id, ClientUpdateDto clientDto);

    ResponseEntity<Void> addAuto(Long id, AutoCreateDto newAutoDto);

    ResponseEntity<ClientPageDto> getAllClients(int page, int size);
}
