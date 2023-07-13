package com.example.demo.controller;

import com.example.demo.model.dto.request.ProductCreationRequestDTO;
import com.example.demo.model.dto.request.ProductTypeCreationDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor

// Essa classe define as rotas para criação, busca e manipulação de produtos. Ele recebe os dados fornecidos pelo cliente, chama os métodos apropriados do serviço correspondente (productService) e retorna as respostas adequadas para o cliente.
public class ProductController {

    // Campos:
    private final ProductService productService;

    // Métodos:
    // 1) Endpoint que lida com a solicitação de criação de um novo produto.
    @PostMapping("/create")
    public ResponseEntity<String> create(@Validated @RequestBody ProductCreationRequestDTO request) {
        productService.create(request);
        return ResponseEntity.ok("Produto criado com sucesso.");
    }

    // 2) Endpoint que lida com a solicitação de busca de um produto por ID.
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // 3) Endpoint que lida com a solicitação de criação de um novo tipo de produto. 
    @PostMapping("/new-type")
    public ResponseEntity<String> createProductType(@Validated @RequestBody ProductTypeCreationDTO request) {
        productService.createProductType(request);
        return ResponseEntity.ok("Tipo criado com sucesso.");
    }

    // 4) Endpoint para obter uma lista de todos os produtos cadastrados. 
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
