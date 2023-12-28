package com.auto_mechanic.auto_mechanic_api.image.dto;

import lombok.Data;

@Data
public class ImageDto {

    private String name;

    private String type;

    private byte[] data;
}
