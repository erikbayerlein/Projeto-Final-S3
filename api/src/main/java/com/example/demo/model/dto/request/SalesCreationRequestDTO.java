package com.example.demo.model.dto.request;

import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.Sales;

import java.math.BigDecimal;
import java.util.List;

public class SalesCreationRequestDTO {

    List<Product> productList; // ou String productList e depois transformamos em um array utilizando split(",")
    String salesPerson;
    BigDecimal price;
    String date;

    public Sales toEntity() {
        return new Sales(productList , salesPerson, price, date);
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
