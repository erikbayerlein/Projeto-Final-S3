package com.example.demo.service;

import com.example.demo.model.dto.response.UserLoggedResponseDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// Essa classe fornece informações sobre o usuário atualmente autenticado
public class UserService {

    // Métodos:
    //  1) Retorna um objeto UserLoggedResponseDTO que representa as informações do usuário atualmente autenticado.
    public UserLoggedResponseDTO getUserLogged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return UserLoggedResponseDTO.fromEntity((User) auth.getPrincipal()) ;
    }

    // 2) Retorna o objeto User que representa o usuário atualmente autenticado.
    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return (User) auth.getPrincipal();
    }

}
