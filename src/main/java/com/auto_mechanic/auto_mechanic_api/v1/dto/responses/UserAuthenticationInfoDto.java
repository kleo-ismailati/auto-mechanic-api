package com.auto_mechanic.auto_mechanic_api.v1.dto.responses;

import lombok.Data;

import java.util.List;

@Data
public class UserAuthenticationInfoDto {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public UserAuthenticationInfoDto(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

}
