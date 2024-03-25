package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewAutoDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.ClientEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.ClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages.ClientPageDto;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<ClientDto> getClient(Long id);

    ResponseEntity<Void> addClient(NewClientDto newClient);

    ResponseEntity<Void> editClient(Long id, ClientEditDto clientDto);

    ResponseEntity<Void> addAuto(Long id, NewAutoDto newAutoDto);

    ResponseEntity<ClientPageDto> getAllClients(int page, int size);
}
