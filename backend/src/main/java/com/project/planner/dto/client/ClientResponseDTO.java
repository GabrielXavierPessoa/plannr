package com.project.planner.dto.client;

import com.project.planner.domain.Client;
import com.project.planner.domain.RoleUser;

import java.util.UUID;

public class ClientResponseDTO {

    private final UUID publicId;
    private final String name;
    private final String phone;
    private final String email;
    private final RoleUser role;


    // ========== CONSTRUCTORS ==========

    public ClientResponseDTO (Client client) {
        this.publicId = client.getPublicId();
        this.name = client.getName();
        this.phone = client.getPhone();
        this.email = client.getUser().getEmail();
        this.role = client.getUser().getRole();
    }

    // =================================

    // ========== GETTERS ==========
    public UUID getPublicId() {
        return publicId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public RoleUser getRole() {
        return role;
    }
}
