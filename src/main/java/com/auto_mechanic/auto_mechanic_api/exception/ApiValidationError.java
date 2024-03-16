package com.auto_mechanic.auto_mechanic_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {

    private String object;

    private String field;

    private Object rejectedValue;

    private String message;

    public ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}