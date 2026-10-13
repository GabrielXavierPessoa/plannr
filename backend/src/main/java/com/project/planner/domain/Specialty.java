package com.project.planner.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @OneToOne(mappedBy = "specialty")
    private Provider provider;

    // ========== CONSTRUCTORS ==========
    public Specialty() {}
    // ==================================

    // ========== GETTERS ==========
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Provider getProvider() {
        return provider;
    }

    // =============================

    // ========== SETTERS ==========
    public void setName(String name) {
        this.name = name;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    // =============================
}
