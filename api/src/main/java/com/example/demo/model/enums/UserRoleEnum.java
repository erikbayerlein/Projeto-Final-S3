package com.example.demo.model.enums;

import java.util.HashMap;


/**
 * Essa classe é uma enumeração que define os possíveis papéis de usuário (Cliente, gerente, administrador)
 *
 * @param Descrição do papel, HashMap que associa o nome do papel com sua descrição
 * @return Descrição do papel, Nome do papel
 */
public enum UserRoleEnum {
    CLIENT("client"), MANAGER("MANAGER"), ADMIN("admin");

    private final String description;
    private static final HashMap<String, UserRoleEnum> map = new HashMap<>();
    UserRoleEnum(String description) {
        this.description = description;
    }

 
    /** Retorna a descrição do papel do usuário */
    public String getDescription(){ return this.description; }

    /** Retorna o papel do usuário a partir de uma descrição fornecida */
    public static UserRoleEnum getByDescription(String type) {
        return map.get(type);
    }

    static{
        for(UserRoleEnum type : UserRoleEnum.values()){
            map.put(type.getDescription(), type);
        }
    }
}
