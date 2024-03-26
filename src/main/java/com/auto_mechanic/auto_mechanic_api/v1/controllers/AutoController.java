package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.AutoUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.AutoDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autos")
@Tag(name = "Autos", description = "Autos Controller")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get auto by id", tags = {"Autos"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Auto found"),
            @ApiResponse(responseCode = "404", description = "Auto not found")
    })
    public ResponseEntity<AutoDto> getAuto(@PathVariable("id") Long id) {
        return autoService.getAuto(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update auto by id", tags = {"Autos"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Auto updated successfully"),
            @ApiResponse(responseCode = "404", description = "Auto not found")
    })
    public ResponseEntity<Void> editAuto(@PathVariable("id") Long id,
                                         @RequestBody AutoUpdateDto autoDto) {
        return autoService.editAuto(id, autoDto);
    }
}
