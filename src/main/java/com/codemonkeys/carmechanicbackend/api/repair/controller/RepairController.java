package com.codemonkeys.carmechanicbackend.api.repair.controller;

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
import com.codemonkeys.carmechanicbackend.api.repair.dto.RepairDto;
import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;
import com.codemonkeys.carmechanicbackend.api.repair.service.RepairService;

@RestController
@RequestMapping("/api/repair")
public class RepairController {
	
	private RepairService repairService;
	
	public RepairController(RepairService repairService) {
		this.repairService = repairService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RepairDto> getRepair(@PathVariable("id") Long id) {
		return repairService.getRepair(id);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Repair> addRepair(@PathVariable("id") Long id,
			@RequestBody NewRepairDto newRepair) {
		return repairService.addRepair(newRepair, id);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Repair> editRepair(@PathVariable("id") Long id, 
			@RequestBody RepairDto repairDto) {
		return repairService.editRepair(id, repairDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Repair> deleteRepair(@PathVariable("id") Long id) {
		return repairService.deleteRepair(id);
	}

}
