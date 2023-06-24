package com.example.demo.model.enums;

import java.util.HashMap;

public enum ProductTypeEnum {
    FOOD("food"), DRINK("drink");

    private final String description;
    private static final HashMap<String, ProductTypeEnum> map = new HashMap<>();
    ProductTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription(){ return this.description; }

    public static ProductTypeEnum getByDescription(String type) {
        return map.get(type);
    }

    static{
        for(ProductTypeEnum type : ProductTypeEnum.values()){
            map.put(type.getDescription(), type);
        }
    }

}
