package com.auto_mechanic.auto_mechanic_api.api.dto.client.client_edit;

import lombok.Data;

@Data
public class ClientEditDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

}
