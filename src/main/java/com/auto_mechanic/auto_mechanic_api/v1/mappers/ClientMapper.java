package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.AutoCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.ClientCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.ClientUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.ClientItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany.ClientPageDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.ClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientMapper {

    private final AutoMapper autoMapper;

    public ClientMapper(AutoMapper autoMapper) {
        this.autoMapper = autoMapper;
    }

    public Client toNewEntity(ClientCreateDto clientDto) {

        Client clientEntity = new Client();

        clientEntity.setFirstName(clientDto.getFirstName().trim());
        clientEntity.setLastName(clientDto.getLastName().trim());
        clientEntity.setEmail(clientDto.getEmail().trim());
        clientEntity.setPhoneNumber(clientDto.getPhoneNumber().trim());
        clientEntity.setAddress(clientDto.getAddress().trim());

        return clientEntity;

    }

    public Client updateEntity(ClientUpdateDto clientDto, Client clientEntity) {


        if (clientDto.getFirstName() != null) {
            clientEntity.setFirstName(clientDto.getFirstName().trim());
        }

        if (clientDto.getLastName() != null) {
            clientEntity.setLastName(clientDto.getLastName().trim());
        }

        if (clientDto.getEmail() != null) {
            clientEntity.setEmail(clientDto.getEmail().trim());
        }

        if (clientDto.getPhoneNumber() != null) {
            clientEntity.setPhoneNumber(clientDto.getPhoneNumber().trim());
        }

        if (clientDto.getAddress() != null) {
            clientEntity.setAddress(clientDto.getAddress().trim());
        }

        return clientEntity;
    }

    public void addAuto(AutoCreateDto newAutoDto, Client client) {

        client.addAuto(autoMapper.toNewEntity(newAutoDto, client));

    }

    public ClientDto toDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setEmail(client.getEmail());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setAddress(client.getAddress());

        clientDto.setAutos(autoMapper.toClientAutoDtoList(client.getAutos()));

        return clientDto;
    }

    public ClientPageDto toClientPageDto(Page<Client> clients) {
        ClientPageDto clientPageDto = new ClientPageDto();

        List<ClientItemDto> clientDtoList = new ArrayList<>();

        for (Client client : clients) {
            clientDtoList.add(toClientItemDto(client));
        }

        clientPageDto.setResult(clientDtoList);
        clientPageDto.setPageNo(clients.getNumber());
        clientPageDto.setSize(clients.getSize());
        clientPageDto.setTotal(clients.getTotalPages());

        return clientPageDto;
    }

    private ClientItemDto toClientItemDto(Client client) {
        ClientItemDto clientDto = new ClientItemDto();

        clientDto.setId(client.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setEmail(client.getEmail());

        return clientDto;
    }
}
