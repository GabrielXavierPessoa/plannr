package com.project.planner.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", length = 60, nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleUser role = RoleUser.client;


    // ========== CONSTRUCTORS ==========
    public User() {}

    public User(String email, String passwordHash, RoleUser role) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }
    // ==================================

    // ========== GETTERS ==========
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public RoleUser getRole() {
        return role;
    }
    // =============================

    // ========== SETTERS ==========
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }
}
