package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update;

import lombok.Data;

@Data
public class ClientUpdateDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

}
