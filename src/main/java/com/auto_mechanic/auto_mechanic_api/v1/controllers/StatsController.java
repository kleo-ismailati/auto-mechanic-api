package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.models.Stats;
import com.auto_mechanic.auto_mechanic_api.v1.services.StatsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@Tag(name = "Statistics", description = "Booking statistics Controller")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    @Operation(summary = "Get all booking stats", tags = {"Statistics"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stats found"),
            @ApiResponse(responseCode = "404", description = "Stats not found")
    })
    public ResponseEntity<Stats> getAllStatistics() {
        return statsService.getStatistics();
    }
}
