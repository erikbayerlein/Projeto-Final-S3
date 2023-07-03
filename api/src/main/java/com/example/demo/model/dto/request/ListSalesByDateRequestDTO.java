package com.example.demo.model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ListSalesByDateRequestDTO {
    LocalDate date;
}
