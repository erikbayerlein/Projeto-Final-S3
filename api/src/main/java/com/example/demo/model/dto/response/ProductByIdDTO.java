package com.example.demo.model.dto.response;

import com.example.demo.model.entity.ProductType;
import jakarta.persistence.*;

import java.math.BigDecimal;


/**
 * Essa classe representa a resposta a uma requisição de busca por Id do produto
 *
 * @param Nome, Preço e tipo do Produto
 * 
 */
public class ProductByIdDTO {

    
    private String name;

    private BigDecimal price;

    private ProductType productType;
}
