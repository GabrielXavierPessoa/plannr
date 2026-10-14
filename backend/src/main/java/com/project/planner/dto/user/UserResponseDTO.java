package com.project.planner.dto.user;

import com.project.planner.domain.User;

public class UserResponseDTO {

    private final Long id;
    private final String email;
    private final String passwordHash;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
