package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ProductUpdateRequestDTO {
    String name;
    BigDecimal price;
    String productType;

    public Product toEntity() {
        return new Product(name, price, null);
    }
}
