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

/**
 * Define as rotas para criação, busca e manipulação de produtos.
 *
 * @param dados fornecidos pelo cliente.
 * @return as respostas adequadas para o cliente.
 */
public class ProductController {

    private final ProductService productService;


    @PostMapping("/create")
    /** Endpoint que lida com a solicitação de criação de um novo produto */
    public ResponseEntity<String> create(@Validated @RequestBody ProductCreationRequestDTO request) {
        productService.create(request);
        return ResponseEntity.ok("Produto criado com sucesso.");
    }

    @GetMapping("/{id}")
    /** Endpoint que lida com a solicitação de busca de um produto por ID. */
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/new-type")
    /** Endpoint que lida com a solicitação de criação de um novo tipo de produto. */
    public ResponseEntity<String> createProductType(@Validated @RequestBody ProductTypeCreationDTO request) {
        productService.createProductType(request);
        return ResponseEntity.ok("Tipo criado com sucesso.");
    }

    @GetMapping("")
    /** Endpoint para obter uma lista de todos os produtos cadastrados. */
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
