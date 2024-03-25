package com.auto_mechanic.auto_mechanic_api.v1.controllers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewRepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.RepairEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairDto;
import com.auto_mechanic.auto_mechanic_api.v1.services.RepairService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repair")
@Tag(name = "Repair", description = "Auto Repair Controller")
public class RepairController {

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get Repair by id", tags = {"Repair"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair found"),
            @ApiResponse(responseCode = "404", description = "Repair not found")
    })
    public ResponseEntity<RepairDto> getRepair(@PathVariable("id") Long id) {
        return repairService.getRepair(id);
    }

    @PostMapping(value = "add/{id}")
    @Operation(summary = "Add new Repair to Existing Repair Booking", tags = {"Repair"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Repair added successfully")
    })
    public ResponseEntity<Void> addRepair(@PathVariable("id") Long id, @RequestBody NewRepairDto newRepair) {
        return repairService.addRepair(id, newRepair);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update Repair by id", tags = {"Repair"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repair updated successfully"),
            @ApiResponse(responseCode = "404", description = "Repair not found")
    })
    public ResponseEntity<Void> editRepair(@PathVariable("id") Long id,
                                           @RequestBody RepairEditDto repairDto) {
        return repairService.editRepair(id, repairDto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete Repair by id", tags = {"Repair"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Repair deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Repair not found")
    })
    public ResponseEntity<Void> deleteRepair(@PathVariable("id") Long id) {
        return repairService.deleteRepair(id);
    }

}
