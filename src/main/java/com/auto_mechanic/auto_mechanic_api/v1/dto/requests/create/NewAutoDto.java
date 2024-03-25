package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create;

import lombok.Data;

@Data
public class NewAutoDto {

    private String autoType;
    private String autoModel;
    private String year;
    private String color;
    private String autoDescription;
}
