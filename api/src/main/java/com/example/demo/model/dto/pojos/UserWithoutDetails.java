package com.example.demo.model.dto.pojos;

import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// Essa classe é é um DTO que representa um usuário sem os detalhes sensíveis. 
public class UserWithoutDetails {

    // Campos:
    private Long id;

    private String name;

    private String password;

    private String CPF;

    private String userRole;

    // Métodos: 
    // 1) Esse método 
    public UserWithoutDetails fromEntity(User user){
        return new UserWithoutDetails(user.getId(), user.getName(), user.getPassword(), user.getCPF(), user.getUserRole());
    }
}
