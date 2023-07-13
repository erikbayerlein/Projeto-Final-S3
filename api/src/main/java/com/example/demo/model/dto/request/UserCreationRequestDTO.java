package com.example.demo.model.dto.request;

import com.example.demo.model.entity.User; // alterado
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
// Essa classe é usada para transferir os dados de criação de um usuário
public class UserCreationRequestDTO {

    //Campos:
    String name;
    String password;
    String userRole;
    String CPF;

    // Métodos:
    // 1) Converte o objeto UserCreationRequestDTO em um objeto User
    public User toEntity() {
        return new User(name, password, null, CPF); //
    }
}
