package com.example.demo.model.dto.response;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.Sales;
import com.example.demo.model.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class SalesResponse {

    private BigDecimal price;

    private List<Product> listProducts;

    private LocalDate date;

    private Long id;

    public SalesResponse(BigDecimal price, List<Product> listProducts, LocalDate date, Long id) {
    this.price = price;
    this.listProducts = listProducts;
    this.date = date;
    this.id = id;
        }

    public static SalesResponse fromEntity(Sales sales){
            return new SalesResponse(sales.getPrice(), sales.getListProducts(), sales.getDate(), sales.getId());
        }


}
