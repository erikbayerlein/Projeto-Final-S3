package com.example.demo.model.enums;

import java.util.HashMap;

// Essa classe é uma enumeração que define os possíveis papéis de usuário (Cliente, gerente, administrador)
public enum UserRoleEnum {
    CLIENT("client"), MANAGER("MANAGER"), ADMIN("admin");

    // Campos:
    private final String description;
    private static final HashMap<String, UserRoleEnum> map = new HashMap<>();
    UserRoleEnum(String description) {
        this.description = description;
    }

    // Métodos:
    // 1) Retorna a descrição do papel do usuário
    public String getDescription(){ return this.description; }

    // 2) Retorna o papel do usuário a partir de uma descrição fornecida
    public static UserRoleEnum getByDescription(String type) {
        return map.get(type);
    }

    static{
        for(UserRoleEnum type : UserRoleEnum.values()){
            map.put(type.getDescription(), type);
        }
    }
}
