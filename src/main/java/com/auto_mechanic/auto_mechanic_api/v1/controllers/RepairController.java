package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.RepairCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.RepairUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.RepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.RepairService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repairs")
@Tag(name = "Repairs", description = "Repairs Controller")
public class RepairController {

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get repair by id", tags = {"Repairs"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair found"),
            @ApiResponse(responseCode = "404", description = "Repair not found")
    })
    public ResponseEntity<RepairDto> getRepair(@PathVariable("id") Long id) {
        return repairService.getRepair(id);
    }

    @PostMapping(value = "add/{id}")
    @Operation(summary = "Add new repair to existing booking", tags = {"Repairs"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Repair added successfully")
    })
    public ResponseEntity<Void> addRepair(@PathVariable("id") Long id, @RequestBody RepairCreateDto newRepair) {
        return repairService.addRepair(id, newRepair);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update repair by id", tags = {"Repairs"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair updated successfully"),
            @ApiResponse(responseCode = "404", description = "Repair not found")
    })
    public ResponseEntity<Void> editRepair(@PathVariable("id") Long id,
                                           @RequestBody RepairUpdateDto repairDto) {
        return repairService.editRepair(id, repairDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete repair by id", tags = {"Repairs"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Repair deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Repair not found")
    })
    public ResponseEntity<Void> deleteRepair(@PathVariable("id") Long id) {
        return repairService.deleteRepair(id);
    }

}
