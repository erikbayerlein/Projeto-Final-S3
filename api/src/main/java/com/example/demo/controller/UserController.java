package com.example.demo.controller;

import com.example.demo.model.dto.request.UserCreationRequestDTO; //
import com.example.demo.service.UserService; //
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    UserService userService;
    @PostMapping("/create")
    public ResponseEntity<String> create(@Validated @RequestBody UserCreationRequestDTO request) {
        userService.create(request);
        return ResponseEntity.ok("User created successfully");
    }

    
}
