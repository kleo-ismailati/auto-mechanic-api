package com.codemonkeys.car_mechanic.exception;

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