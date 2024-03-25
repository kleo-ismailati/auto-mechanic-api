package com.auto_mechanic.auto_mechanic_api.v1.dto.responses;

import lombok.Data;

@Data
public class AutoDto {

    private String autoType;
    private String autoModel;
    private String year;
    private String color;
    private String autoDescription;
    private String imageId;

}
