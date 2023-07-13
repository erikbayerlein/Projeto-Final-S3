package com.example.demo.model.dto.request;

import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

/**
 * Envia os dados de registro do usuário para a API
 * ou para a camada de serviço, permitindo a criação de uma instância de User
 *
 * @param dados fornecidos pelo usuário.
 * @return novo usuário.
 */
public class AuthRegisterDTO {

    private String name;
    private String CPF;
    private String password;
    private String confirmPassword;
    private String role;

    /** Converte o objeto AuthRegisterDTO em um objeto User */
    public User toUser() {
        return new User(name, password, role, CPF);
    }
}
