package com.example.demo.controller;

import com.example.demo.model.dto.request.UserCreationRequestDTO;
import com.example.demo.model.dto.response.UserLoggedResponseDTO;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor

/**
 * Essa classe define a rota para obter os detalhes do usuário logado.
 *
 * @param dados fornecidos pelo cliente.
 * @return as respostas adequadas.
 */
public class UserController {

    private final UserService userService;


    /** Endpoint que lida com a solicitação de busca do usuário logado.  */
    @GetMapping("/me")
    public ResponseEntity<UserLoggedResponseDTO> getUserLogged(){
        return ResponseEntity.ok(userService.getUserLogged());
    }
}
