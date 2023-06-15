package com.example.demo.model.dto.request;

import com.example.demo.model.entity.User; // alterado
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class UserCreationRequestDTO {
    String name;
    String password;
    // Tirar dúvida sobre role
    String role;

    public User toEntity() {
        return new User(name, password, null); //
    }
}
