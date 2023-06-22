package com.example.demo.model.enums;

import java.util.HashMap;

public enum UserRoleEnum {
    CLIENT("client"), MANAGER("MANAGER"), ADMIN("admin");

    private final String description;
    private static final HashMap<String, UserRoleEnum> map = new HashMap<>();
    UserRoleEnum(String description) {
        this.description = description;
    }

    public String getDescription(){ return this.description; }

    public static UserRoleEnum getByDescription(String type) {
        return map.get(type);
    }

    static{
        for(UserRoleEnum type : UserRoleEnum.values()){
            map.put(type.getDescription(), type);
        }
    }
}
