package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Sales;
import lombok.Data;

import java.util.List;

@Data
//  Essa classe é usada para transferir os dados de criação de uma venda
public class SalesCreationRequestDTO {

    // Campos
    List<Long> productList;
    Long salesPersonId;

    // Métodos
    // 1) Retorna uma instância vazia de Sales
    public Sales toEntity() {
        return new Sales();
    }

}
