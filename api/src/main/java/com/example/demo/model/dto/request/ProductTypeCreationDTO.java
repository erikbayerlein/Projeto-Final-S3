package com.example.demo.model.dto.request;

import com.example.demo.model.entity.ProductType;
import com.example.demo.model.enums.ProductTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter

/**
 * Usada para transferir os dados de criação de um tipo de produto.
 */
public class ProductTypeCreationDTO {

    @NonNull
    String name;
    @NonNull
    String majorType;

    /** Converte o objeto ProductTypeCreationDTO em um objeto ProductType */
    public ProductType toEntity() {
        return new ProductType(name, ProductTypeEnum.getByDescription(majorType));
    }
}
