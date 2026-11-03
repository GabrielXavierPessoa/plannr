package com.project.planner.controller;

import com.project.planner.dto.provider.ProviderRequestDTO;
import com.project.planner.dto.provider.ProviderResponseDTO;
import com.project.planner.service.ProviderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public ResponseEntity<List<ProviderResponseDTO>> findAll() {
        List<ProviderResponseDTO> response = providerService.findAll();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProviderResponseDTO> create(@Valid @RequestBody ProviderRequestDTO request) {
        ProviderResponseDTO response = providerService.save(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}










