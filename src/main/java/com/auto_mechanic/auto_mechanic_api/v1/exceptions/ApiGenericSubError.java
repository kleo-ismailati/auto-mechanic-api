package com.auto_mechanic.auto_mechanic_api.v1.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiGenericSubError extends ApiSubError {

    private String message;

    public ApiGenericSubError(String message) {
        this.message = message;
    }
}