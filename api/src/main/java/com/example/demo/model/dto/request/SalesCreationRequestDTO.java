package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Sales;
import lombok.Data;

import java.util.List;

@Data

/**
 * Usada para transferir os dados de criação de uma venda
 *
 * @param Lista de produtos vendidas e id do vendendor.
 * @return objeto Sales vazio.
 */
public class SalesCreationRequestDTO {

    List<Long> productList;
    Long salesPersonId;


    /** Retorna uma instância vazia de Sales */
    public Sales toEntity() {
        return new Sales();
    }

}
