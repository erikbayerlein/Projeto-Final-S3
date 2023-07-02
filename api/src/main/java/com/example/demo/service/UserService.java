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
public class UserService {

    public UserLoggedResponseDTO getUserLogged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return UserLoggedResponseDTO.fromEntity((User) auth.getPrincipal()) ;
    }

    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return (User) auth.getPrincipal();
    }

}
