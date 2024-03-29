package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle;

import lombok.Data;

@Data
public class ClientAutoDto {

    private long id;
    private String autoType;
    private String autoModel;
    private String year;
    private String color;

    private ImageDataDto thumbnail;

}
