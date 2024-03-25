package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.list_items;

import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.ImageDto;
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
