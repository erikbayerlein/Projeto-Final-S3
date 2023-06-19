package com.example.demo.service;

import com.example.demo.model.dto.request.UserCreationRequestDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void create(UserCreationRequestDTO request){

        userRepository.save(request.toEntity());

    }
}
