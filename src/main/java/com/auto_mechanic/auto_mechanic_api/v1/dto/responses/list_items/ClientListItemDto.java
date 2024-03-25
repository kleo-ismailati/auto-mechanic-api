package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items;

import lombok.Data;


@Data
public class ClientListItemDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
