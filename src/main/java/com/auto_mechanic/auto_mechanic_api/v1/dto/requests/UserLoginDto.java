package com.auto_mechanic.auto_mechanic_api.v1.dto.requests;

import lombok.Data;

@Data
public class UserLoginDto {

    private String username;
    private String password;

}
