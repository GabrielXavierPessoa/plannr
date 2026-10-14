package com.project.planner.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "public_id", length = 36,nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID public_id = UUID.randomUUID();

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @OneToOne
    @JoinColumn(name = "specialty_id", nullable = false, unique = true)
    private Specialty specialty;

    // ========== CONSTRUCTORS ==========
    public Provider() {}
    // ==================================

    // ========== GETTERS ==========
    public Integer getId() {
        return id;
    }

    public UUID getPublic_id() {
        return public_id;
    }

    public String getName() {
        return name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public User getUser() {
        return user;
    }
    // =============================

    // ========== SETTERS ==========
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
    // =============================

}
