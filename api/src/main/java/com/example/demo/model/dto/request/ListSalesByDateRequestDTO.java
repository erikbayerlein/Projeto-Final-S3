package com.example.demo.model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data

/**
 * Um DTO que representa os critérios de busca por data para listar as vendas
 *
 * @param data.
 */
public class ListSalesByDateRequestDTO {

    LocalDate date;
}
