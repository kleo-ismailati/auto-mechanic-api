package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle;

import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private List<ClientAutoDto> autos;

}
