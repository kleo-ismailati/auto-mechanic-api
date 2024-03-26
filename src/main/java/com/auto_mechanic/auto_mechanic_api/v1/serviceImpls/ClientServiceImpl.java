package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.AutoCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.ClientCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.ClientUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.ClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.ClientPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.mappers.ClientMapper;
import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.ClientRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ResponseEntity<ClientDto> getClient(Long id) {

        Client client = clientRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(clientMapper.toDto(client));
    }

    public ResponseEntity<Void> addClient(ClientCreateDto newClient) {

        clientRepository.save(clientMapper.toNewEntity(newClient));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    public ResponseEntity<Void> editClient(Long id, ClientUpdateDto clientDto) {

        Client client = clientRepository.findById(id).orElseThrow();
        clientMapper.updateEntity(clientDto, client);
        clientRepository.save(client);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addAuto(Long id, AutoCreateDto newAutoDto) {

        Client client = clientRepository.findById(id).orElseThrow();
        clientMapper.addAuto(newAutoDto, client);
        clientRepository.save(client);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<ClientPageDto> getAllClients(int page, int size) {

        Page<Client> clients =
                clientRepository.findAll(
                        PageRequest.of(page, size)
                );

        return ResponseEntity.ok(clientMapper.toClientPageDto(clients));
    }
}
