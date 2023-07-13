package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
// A classe ProductCreationRequestDTO é um DTO que representa os dados de criação de um produto.
public class ProductCreationRequestDTO {
    // Campos:
    String name;
    BigDecimal price;
    String productType;

    // Métodos:
    // 1) Converte o objeto ProductCreationRequestDTO em um objeto Product
    public Product toEntity() {
        return new Product(name, price, null);
    }
}
