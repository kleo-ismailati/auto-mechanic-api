package com.auto_mechanic.auto_mechanic_api.api.dto.client;

import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private List<AutoClientListItemDto> autos;

}
