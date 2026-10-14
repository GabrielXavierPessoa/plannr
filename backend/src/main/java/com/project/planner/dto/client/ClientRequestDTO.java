package com.project.planner.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {

    @NotBlank(message = "O Nome não pode estar em branco")
    private String name;

    @NotBlank(message = "Telefone não pode estar vazio")
    private String phone;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Email em formato invalido")
    private String email;

    @NotBlank(message = "A senha esta em vazia")
    private String password;

    // ========== CONSTRUCTOR ==========
    public ClientRequestDTO(
            String name,
            String phone,
            String email,
            String password
    ) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    // =================================

    // ========== GETTERS ==========
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // ========== SETTERS ==========

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
