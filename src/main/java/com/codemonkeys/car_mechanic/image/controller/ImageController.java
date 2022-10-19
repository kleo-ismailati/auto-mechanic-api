package com.codemonkeys.car_mechanic.image.controller;

import com.codemonkeys.car_mechanic.image.model.Image;
import com.codemonkeys.car_mechanic.image.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@Tag(name = "Image", description = "Image Controller")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get Image", tags = { "Image" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image found"),
            @ApiResponse(responseCode = "404", description = "Image not found")
    })
    public ResponseEntity<Resource> getImage(@PathVariable("id") String id){
        return this.imageService.getImage(id);
    }

    @PostMapping("/setCarImg/{id}")
    @Operation(summary = "Upload car image", tags = { "Image" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image uploaded")
    })
    public ResponseEntity<Image> setCarImg(
            @PathVariable("id") Long id,
            @RequestBody MultipartFile file
    ) {
        return this.imageService.setCarImg(id, file);
    }

    @PostMapping("/setUserImg/{id}")
    @Operation(summary = "Upload user image", tags = { "Image" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image uploaded")
    })
    public ResponseEntity<Image> setUserImg(
            @PathVariable("id") Long id,
            @RequestBody MultipartFile file
    ) {
        return this.imageService.setUserImg(id,file);
    }

}
