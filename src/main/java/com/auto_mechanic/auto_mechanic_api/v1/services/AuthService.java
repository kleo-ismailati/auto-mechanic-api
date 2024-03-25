package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.LoggedUserDto;

public interface AuthService {
    LoggedUserDto authenticateUser(String username, String password);
}
