package com.auto_mechanic.auto_mechanic_api.api.dto.client;

import com.auto_mechanic.auto_mechanic_api.image.dto.ImageDto;
import lombok.Data;

@Data
public class AutoClientListItemDto {

    private long id;
    private String autoType;
    private String autoModel;
    private String year;
    private String color;

    private ImageDto thumbnail;

}
