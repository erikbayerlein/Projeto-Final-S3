package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProductCreationRequestDTO {
    String name;
    BigDecimal price;
    String productType;

    // O método toEntity é responsável por criar um objeto produto a partir da informação enviada pelo usuário
    // -> arquivo entity/Product.java
    public Product toEntity() {
        return new Product(name, price, null);
    }
}
