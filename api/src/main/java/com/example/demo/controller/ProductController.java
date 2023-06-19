package com.example.demo.controller;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductService productService;

    // DTO contém as informações passadas através do view (usuário)
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ProductCreationRequestDTO request) {
        // É necessário transformar o conteúdo de DTO para um formato adequado para ser salvo na tabela de produtos
        // Dessa forma, o método create é chamado, passando o request (DTO) como parâmetro
        // -> arquivo service/ProductService.java
        productService.create(request);
        return ResponseEntity.ok("Product created successfully");

    }
}
