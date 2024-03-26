package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update;

import lombok.Data;

@Data
public class AutoUpdateDto {

    private String autoType;
    private String autoModel;
    private String year;
    private String color;
    private String autoDescription;

}
