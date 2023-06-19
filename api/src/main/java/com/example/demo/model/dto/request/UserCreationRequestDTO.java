package com.example.demo.model.dto.request;

import com.example.demo.model.entity.User; // alterado
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class UserCreationRequestDTO {
    String name;
    String password;
    String userRole;
    String CPF;

    public User toEntity() {
        return new User(name, password, null, CPF); //
    }
}
