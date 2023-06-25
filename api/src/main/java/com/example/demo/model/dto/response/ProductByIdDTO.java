package com.example.demo.model.dto.response;

import com.example.demo.model.entity.ProductType;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class ProductByIdDTO {

    private String name;

    private BigDecimal price;

    private ProductType productType;
}
