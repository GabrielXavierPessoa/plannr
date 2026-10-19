package com.project.planner.dto.provider;

import com.project.planner.domain.Provider;

import java.util.UUID;

public class ProviderResponseDTO {

    private final UUID publicId;
    private final String name;
    private final String email;
    private final String specialtyName;

    public ProviderResponseDTO(Provider provider) {
        this.publicId = provider.getPublic_id();
        this.name = provider.getName();
        this.email = provider.getUser().getEmail();
        this.specialtyName = provider.getSpecialty().getName();
    }

    // =========================================================

    public UUID getPublicId() {
        return publicId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

}
