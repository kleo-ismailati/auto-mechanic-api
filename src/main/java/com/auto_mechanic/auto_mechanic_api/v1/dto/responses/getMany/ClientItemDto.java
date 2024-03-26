package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getMany;

import lombok.Data;


@Data
public class ClientItemDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
