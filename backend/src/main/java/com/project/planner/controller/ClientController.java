package com.project.planner.controller;

import com.project.planner.dto.client.ClientRequestDTO;
import com.project.planner.dto.client.ClientResponseDTO;
import com.project.planner.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        List<ClientResponseDTO> response = clientService.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientRequestDTO dto) {
        ClientResponseDTO response = clientService.save(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
