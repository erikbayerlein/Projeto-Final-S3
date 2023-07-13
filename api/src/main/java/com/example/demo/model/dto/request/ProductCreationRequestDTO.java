package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data

/**
 * Um DTO que representa os dados de criação de um produto.
 *
 * @param dados fornecidos pelo usuário.
 * @return objeto Product com os dados fornecidos.
 */
public class ProductCreationRequestDTO {

    String name;
    BigDecimal price;
    String productType;


    /** Converte o objeto ProductCreationRequestDTO em um objeto Product */
    public Product toEntity() {
        return new Product(name, price, null);
    }
}
