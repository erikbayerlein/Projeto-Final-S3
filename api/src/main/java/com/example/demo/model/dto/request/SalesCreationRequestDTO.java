package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.Sales;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SalesCreationRequestDTO {

    List<Long> productList;
    Long salesPersonId;
    BigDecimal price;
    String date;

    public Sales toEntity() {
        return new Sales(null , null, price, date);
    }

}
