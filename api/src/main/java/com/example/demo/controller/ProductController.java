package com.example.demo.controller;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    ProductService productService;
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ProductCreationRequestDTO request) {
        productService.create(request);
        return ResponseEntity.ok("Product created successfully");
    }
}
