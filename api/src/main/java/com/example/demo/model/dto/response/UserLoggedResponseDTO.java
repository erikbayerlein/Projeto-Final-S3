package com.example.demo.model.dto.response;

import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoggedResponseDTO {

    private String name;

    private String CPF;

    private String userRole;

    public static UserLoggedResponseDTO fromEntity(User user){
        return new UserLoggedResponseDTO(user.getName(), user.getCPF(), user.getUserRole());
    }
}
