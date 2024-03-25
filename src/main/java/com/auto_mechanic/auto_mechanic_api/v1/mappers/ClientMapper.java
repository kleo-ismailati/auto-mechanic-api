package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewAutoDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.ClientEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.ClientDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items.ClientListItemDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages.ClientPageDto;
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

    public Client toNewEntity(NewClientDto clientDto) {

        Client clientEntity = new Client();

        clientEntity.setFirstName(clientDto.getFirstName().trim());
        clientEntity.setLastName(clientDto.getLastName().trim());
        clientEntity.setEmail(clientDto.getEmail().trim());
        clientEntity.setPhoneNumber(clientDto.getPhoneNumber().trim());
        clientEntity.setAddress(clientDto.getAddress().trim());

        return clientEntity;

    }

    public Client updateEntity(ClientEditDto clientDto, Client clientEntity) {


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

    public void addAuto(NewAutoDto newAutoDto, Client client) {

        client.addAuto(autoMapper.toNewEntity(newAutoDto, client));

    }

    public ClientDto toDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setEmail(client.getEmail());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setAddress(client.getAddress());

        clientDto.setAutos(autoMapper.toDtoListForClient(client.getAutos()));

        return clientDto;
    }

    public ClientPageDto toClientPage(Page<Client> clients) {
        ClientPageDto clientPageDto = new ClientPageDto();

        List<ClientListItemDto> clientDtoList = new ArrayList<>();

        for (Client client : clients) {
            clientDtoList.add(toListItem(client));
        }

        clientPageDto.setResult(clientDtoList);
        clientPageDto.setPageNo(clients.getNumber());
        clientPageDto.setSize(clients.getSize());
        clientPageDto.setTotal(clients.getTotalPages());

        return clientPageDto;
    }

    private ClientListItemDto toListItem(Client client) {
        ClientListItemDto clientListItemDto = new ClientListItemDto();

        clientListItemDto.setId(client.getId());
        clientListItemDto.setFirstName(client.getFirstName());
        clientListItemDto.setLastName(client.getLastName());
        clientListItemDto.setPhoneNumber(client.getPhoneNumber());
        clientListItemDto.setEmail(client.getEmail());

        return clientListItemDto;
    }
}
