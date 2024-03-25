package com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit;

import lombok.Data;

@Data
public class AutoEditDto {

    private String autoType;
    private String autoModel;
    private String year;
    private String color;
    private String autoDescription;

}
