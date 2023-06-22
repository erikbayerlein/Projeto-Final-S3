package com.example.demo.model.dto.request;

import jakarta.annotation.Nonnull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthLoginDTO {
    String CPF;
    String password;
}
