package com.example.demo.service;

import com.example.demo.model.dto.request.UserCreationRequestDTO;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public void create(UserCreationRequestDTO request){
        userRepository.save(request.toEntity());
    }
}
