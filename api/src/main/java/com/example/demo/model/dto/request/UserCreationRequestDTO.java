package com.example.demo.model.dto.request;

import com.example.demo.model.entity.User; // alterado
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor

/**
 * Usada para transferir os dados de criação de um usuário
 *
 * @param Nome, senha, tipo do usuário e CPF.
 * @return objeto User com os dados fornecidos.
 */
public class UserCreationRequestDTO {

    String name;
    String password;
    String userRole;
    String CPF;


    /** Converte o objeto UserCreationRequestDTO em um objeto User */
    public User toEntity() {
        return new User(name, password, null, CPF); //
    }
}
