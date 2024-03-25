package com.auto_mechanic.auto_mechanic_api.v1.dto.responses;

import lombok.Data;

@Data
public class ImageDto {

    private String name;

    private String type;

    private byte[] data;
}
