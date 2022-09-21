package com.codemonkeys.carmechanicbackend.api.controller;

import com.codemonkeys.carmechanicbackend.api.model.Stats;
import com.codemonkeys.carmechanicbackend.api.service.StatsService;
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
@Tag(name = "Statistic", description = "Statistic Controller")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    @Operation(summary = "Get all API Stats", tags = { "Statistic" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stats found"),
            @ApiResponse(responseCode = "404", description = "Stats not found")
    })
    public ResponseEntity<Stats> getAllRepairBookings() {
        return statsService.getStats();
    }
}
