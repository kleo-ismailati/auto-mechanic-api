package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.UserAuthenticationInfoDto;

public interface AuthService {
    UserAuthenticationInfoDto authenticateUser(String username, String password);
}
