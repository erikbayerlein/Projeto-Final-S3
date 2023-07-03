package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Sales;
import lombok.Data;

import java.util.List;

@Data
public class SalesCreationRequestDTO {

    List<Long> productList;
    Long salesPersonId;

    public Sales toEntity() {
        return new Sales();
    }

}
