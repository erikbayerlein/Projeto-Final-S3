package com.example.demo.model.dto.request;

import jakarta.annotation.Nonnull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

/**
 * Um DTO que representa os dados de login do usuário.
 */
public class AuthLoginDTO {

    String CPF;
    String password;
}
