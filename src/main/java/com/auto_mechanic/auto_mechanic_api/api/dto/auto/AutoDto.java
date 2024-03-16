package com.auto_mechanic.auto_mechanic_api.api.dto.auto;

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
