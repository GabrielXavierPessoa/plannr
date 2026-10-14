package com.project.planner.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClientRequestDTO {

    @NotBlank(message = "O Nome não pode estar em branco")
    @Size(min = 3, message = "Minimum of three characters for the name field")
    private String name;

    @NotBlank(message = "Telefone não pode estar vazio")
    @Size(min = 12, max = 12, message = "The phone field must contain 12 digits")
    private String phone;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Email em formato invalido")
    private String email;

    @NotBlank(message = "A senha esta em vazia")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_=+]).{8,20}$",
            message = "Invalid password format. Must contain uppercase, lowercase, number and special char."
    )
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
