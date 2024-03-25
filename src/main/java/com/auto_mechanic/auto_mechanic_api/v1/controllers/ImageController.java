package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.models.Image;
import com.auto_mechanic.auto_mechanic_api.v1.services.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
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
    @Operation(summary = "Get Image", tags = {"Image"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image found"),
            @ApiResponse(responseCode = "404", description = "Image not found")
    })
    public ResponseEntity<Resource> getImage(@PathVariable("id") String id) {
        return this.imageService.getImage(id);
    }

    @PostMapping(value = "/setAutoImg/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload auto image", tags = {"Image"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image uploaded")
    })
    public ResponseEntity<Image> setAutoImg(
            @PathVariable("id") Long id,
            @RequestPart("image") MultipartFile image
    ) {
        return this.imageService.setAutoImg(id, image);
    }

    @PostMapping(value = "/setUserImg/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload user image", tags = {"Image"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image uploaded")
    })
    public ResponseEntity<Image> setUserImg(
            @PathVariable("id") Long id,
            @RequestPart("image") MultipartFile image
    ) {
        return this.imageService.setUserImg(id, image);
    }

}
