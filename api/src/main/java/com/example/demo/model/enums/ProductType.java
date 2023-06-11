package com.example.demo.model.enums;

import java.util.HashMap;

public enum ProductType {
    FOOD("food"), DRINK("description");

    private final String description;
    private static final HashMap<String, ProductType> map = new HashMap<>();
    ProductType(String description) {
        this.description = description;
    }

    public String getDescription(){ return this.description; }

    public static ProductType getByDescription(String type) {
        return map.get(type);
    }

    static{
        for(ProductType type : ProductType.values()){
            map.put(type.getDescription(), type);
        }
    }

}
