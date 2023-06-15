// ******************************************************************

// DÚVIDA COM ESSE ARQUIVO

package com.example.demo.model.enums;

import java.util.HashMap;

public enum UserRoleEnum {
    CLIENT("client"), SALESMAN("salesman"), MANAGER("manager");

    private static final HashMap<String, UserRoleEnum> map = new HashMap<>();
    UserRoleEnum(String description) {
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

// ******************************************************************