package com.codemonkeys.carmechanicbackend.api.repair.controller;

import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.api.repair.dto.NewRepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairEditDto;
import com.codemonkeys.carmechanicbackend.api.repair.service.RepairService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/repair")
@Tag(name = "Repair", description = "Car Repair Controller")
public class RepairController {
	
	private final RepairService repairService;
	
	public RepairController(RepairService repairService) {
		this.repairService = repairService;
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Get Repair by id", tags = { "Repair" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Repair found"),
	  @ApiResponse(responseCode = "404", description = "Repair not found") 
	  })
	public ResponseEntity<RepairDto> getRepair(@PathVariable("id") Long id) {
		return repairService.getRepair(id);
	}
	
	@PostMapping(value = "add/{id}")
	@Operation(summary = "Add new Repair to Existing Repair Booking", tags = { "Repair" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "201", description = "Repair added successfully")
	  })
	public ResponseEntity<Void> addRepair(@PathVariable("id") Long id, @RequestBody NewRepairDto newRepair) {
		return repairService.addRepair(id, newRepair);
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update Repair by id", tags = { "Repair" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Repair updated successfully"),
	  @ApiResponse(responseCode = "404", description = "Repair not found") 
	  })
	public ResponseEntity<Void> editRepair(@PathVariable("id") Long id, 
			@RequestBody RepairEditDto repairDto) {
		return repairService.editRepair(id, repairDto);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete Repair by id", tags = { "Repair" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "204", description = "Repair deleted successfully"),
	  @ApiResponse(responseCode = "404", description = "Repair not found") 
	  })
	public ResponseEntity<Void> deleteRepair(@PathVariable("id") Long id) {
		return repairService.deleteRepair(id);
	}

}
