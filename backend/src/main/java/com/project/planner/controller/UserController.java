package com.project.planner.controller;

import com.project.planner.domain.User;
import com.project.planner.dto.user.UserRequestDTO;
import com.project.planner.dto.user.UserResponseDTO;
import com.project.planner.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> response = userService.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
