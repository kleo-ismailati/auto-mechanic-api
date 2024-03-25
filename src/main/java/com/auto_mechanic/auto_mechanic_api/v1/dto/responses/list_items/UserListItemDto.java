package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items;

import lombok.Data;

@Data
public class UserListItemDto {

    private long id;
    private String username;
    private String email;

}
