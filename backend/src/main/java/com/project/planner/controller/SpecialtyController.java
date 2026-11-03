package com.project.planner.controller;

import com.project.planner.domain.Specialty;
import com.project.planner.service.SpecialtyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/specialties")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public ResponseEntity<List<Specialty>> findAll() {
        List<Specialty> response = specialtyService.findAll();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Specialty> create(@RequestBody Specialty specialty) {
        Specialty response = specialtyService.save(specialty);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialty> update(@PathVariable Integer id, @RequestBody Specialty specialty) {
        Specialty response = specialtyService.update(id, specialty);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        specialtyService.deleteById(id);

        return  ResponseEntity.noContent().build();

    }
}
