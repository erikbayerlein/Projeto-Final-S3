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
public class AuthRegisterDTO {
    private String name;
    private String CPF;
    private String password;
    private String confirmPassword;
    private String role;

    public User toUser() {
        return new User(name, password, role, CPF);
    }
}
