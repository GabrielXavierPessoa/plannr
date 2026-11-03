package com.project.planner.dto.provider;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProviderRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String passwordHash;

    @NotNull
    private Integer specialty;

    // =========================================================

    public ProviderRequestDTO() {}

    // =========================================================

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Integer getSpecialty() {
        return specialty;
    }

    // =========================================================

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setSpecialty(Integer specialty) {
        this.specialty = specialty;
    }
}
