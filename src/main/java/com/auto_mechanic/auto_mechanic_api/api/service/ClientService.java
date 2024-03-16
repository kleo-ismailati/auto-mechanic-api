package com.auto_mechanic.auto_mechanic_api.api.service;

import com.auto_mechanic.auto_mechanic_api.api.dto.auto.new_auto.NewAutoDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.client.ClientDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.client.client_edit.ClientEditDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.client.client_list.ClientPageDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.client.new_client.NewClientDto;
import com.auto_mechanic.auto_mechanic_api.api.mapper.ClientMapper;
import com.auto_mechanic.auto_mechanic_api.api.model.Client;
import com.auto_mechanic.auto_mechanic_api.api.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

        Client client = clientRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(clientMapper.toDto(client));
    }

    public ResponseEntity<Void> addClient(NewClientDto newClient) {

        clientRepository.save(clientMapper.toNewEntity(newClient));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    public ResponseEntity<Void> editClient(Long id, ClientEditDto clientDto) {

        Client client = clientRepository.findById(id).orElseThrow();
        clientMapper.updateEntity(clientDto, client);
        clientRepository.save(client);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addAuto(Long id, NewAutoDto newAutoDto) {

        Client client = clientRepository.findById(id).orElseThrow();
        clientMapper.addAuto(newAutoDto, client);
        clientRepository.save(client);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<ClientPageDto> getAllClients(Optional<Integer> pageOptional,
                                                       Optional<Integer> sizeOptional) {
        int page = 0;
        int size = 10;

        if (pageOptional.isPresent()) {
            page = pageOptional.get();
        }

        if (sizeOptional.isPresent()) {
            size = sizeOptional.get();
        }

        Page<Client> clients =
                clientRepository.findAll(
                        PageRequest.of(page, size)
                );

        return ResponseEntity.ok(clientMapper.toClientPage(clients));
    }
}
