package com.project.planner.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "public_id", length = 36, nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID publicId = UUID.randomUUID();

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // ========== CONSTRUCTORS ==========
    public Client() {}


    public Client(UUID publicId, String name, String phone) {
        this.publicId = publicId;
        this.name = name;
        this.phone = phone;
    }
    // ==================================

    // ========== GETTERS ==========
    public Long getId() {
        return id;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public User getUser() {
        return user;
    }
    // =============================

    // ========== SETTERS ==========
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // =============================

}
