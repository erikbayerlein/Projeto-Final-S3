package com.example.demo.controller;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    ProductService productService;
    @PostMapping("/create")
    public ResponseEntity<String> create(@Validated @RequestBody ProductCreationRequestDTO request) {
        productService.create(request);
        return ResponseEntity.ok("Product created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
