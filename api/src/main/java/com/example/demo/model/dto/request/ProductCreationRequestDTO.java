package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ProductCreationRequestDTO {
    String name;
    BigDecimal price;
    String productType;

    public Product toEntity() {
        return new Product(name, price, null);
    }
}
