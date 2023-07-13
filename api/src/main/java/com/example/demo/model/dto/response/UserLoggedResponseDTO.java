package com.example.demo.model.dto.response;

import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

/**
 *  Essa classe é um DTO que representa os dados de resposta de um usuário logado
 */
public class UserLoggedResponseDTO {

    
    private String name;

    private String CPF;

    private String userRole;

    /** Cria uma instância de UserLoggedResponseDTO a partir de uma instância de User */
    public static UserLoggedResponseDTO fromEntity(User user){
        return new UserLoggedResponseDTO(user.getName(), user.getCPF(), user.getUserRole());
    }
}
