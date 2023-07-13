package com.example.demo.model.dto.pojos;

import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

/**
 * um DTO que representa um usuário sem os detalhes sensíveis.
 */
public class UserWithoutDetails {

    private Long id;
    private String name;
    private String password;
    private String CPF;
    private String userRole;


    public UserWithoutDetails fromEntity(User user){
        return new UserWithoutDetails(user.getId(), user.getName(), user.getPassword(), user.getCPF(), user.getUserRole());
    }
}
