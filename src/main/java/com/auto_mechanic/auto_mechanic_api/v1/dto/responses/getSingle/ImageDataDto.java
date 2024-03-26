package com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle;

import lombok.Data;

@Data
public class ImageDataDto {

    private String name;

    private String type;

    private byte[] data;
}
