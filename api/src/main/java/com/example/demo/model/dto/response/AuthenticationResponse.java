package com.example.demo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

/**
 * Essa classe é um DTO que representa a resposta de autenticação
 *
 * @param Token do tipo String
 */
public class AuthenticationResponse {
    private String token;
}
