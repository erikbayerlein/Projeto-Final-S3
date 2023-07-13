package com.example.demo.controller;

import com.example.demo.model.dto.request.AuthLoginDTO;
import com.example.demo.model.dto.request.AuthRegisterDTO;
import com.example.demo.model.dto.response.AuthenticationResponse;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

// Essa Classe recebe os dados de registro ou login fornecidos pelo cliente, chama os métodos apropriados do serviço e retorna as respostas adequadas para o cliente
public class AuthenticationController {
    
    // Campos:
    private final AuthService authService;

    // Métodos:
    // 1) Endpoint que lida com a solicitação de registro de um usuário.
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthRegisterDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    // 2) Endpoint que lida com a solicitação de autenticação de um usuário.
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthLoginDTO request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
