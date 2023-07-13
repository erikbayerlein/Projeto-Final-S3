package com.example.demo.model.enums;

import java.util.HashMap;

// Essa classe é uma enumeração define os possíveis tipos de produto (Comida e bebida)
public enum ProductTypeEnum {
    FOOD("food"), DRINK("drink");

    // Campos:
    private final String description;
    private static final HashMap<String, ProductTypeEnum> map = new HashMap<>();

    ProductTypeEnum(String description) {
        this.description = description;
    }

    // Métodos:
    // 1) Retorna a descrição do tipo do produto
    public String getDescription(){ return this.description; }

    // 2) retorna o tipo de produto correspondente à descrição fornecida
    public static ProductTypeEnum getByDescription(String type) {
        return map.get(type);
    }

    static{
        for(ProductTypeEnum type : ProductTypeEnum.values()){
            map.put(type.getDescription(), type);
        }
    }

}
