package com.example.demo.model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
//A classe ListSalesByDateRequestDTO é um DTO que representa os critérios de busca por data para listar as vendas
public class ListSalesByDateRequestDTO {
    // Campos:
    LocalDate date;
}
