package com.example.demo.service;

import com.example.demo.model.dto.request.UserCreationRequestDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(UserCreationRequestDTO request){
        userRepository.save(request.toEntity());
    }
}
