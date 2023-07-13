package com.example.demo.model.dto.request;

import jakarta.annotation.Nonnull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

// Essa classe é um DTO que representa os dados de login do usuário. 
public class AuthLoginDTO {

    // Campos:
    String CPF;
    String password;
}
