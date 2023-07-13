package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data

/**
 * usada para transferir os dados de atualização de um produto.
 */
public class ProductUpdateRequestDTO {

    String name;
    BigDecimal price;
    String productType;


    /** Converte o objeto ProductUpdateRequestDTO em um objeto Product */
    public Product toEntity() {
        return new Product(name, price, null);
    }
}
