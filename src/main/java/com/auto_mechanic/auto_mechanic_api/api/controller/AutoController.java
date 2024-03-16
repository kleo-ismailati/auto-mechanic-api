package com.auto_mechanic.auto_mechanic_api.api.controller;

import com.auto_mechanic.auto_mechanic_api.api.dto.auto.AutoDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.auto.auto_edit.AutoEditDto;
import com.auto_mechanic.auto_mechanic_api.api.service.AutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auto")
@Tag(name = "Auto", description = "Auto Controller")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get Auto by id", tags = {"Auto"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Auto found"),
            @ApiResponse(responseCode = "404", description = "Auto not found")
    })
    public ResponseEntity<AutoDto> getAuto(@PathVariable("id") Long id) {
        return autoService.getAuto(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update Auto by id", tags = {"Auto"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Auto updated successfully"),
            @ApiResponse(responseCode = "404", description = "Auto not found")
    })
    public ResponseEntity<Void> editAuto(@PathVariable("id") Long id,
                                         @RequestBody AutoEditDto autoDto) {
        return autoService.editAuto(id, autoDto);
    }
}
