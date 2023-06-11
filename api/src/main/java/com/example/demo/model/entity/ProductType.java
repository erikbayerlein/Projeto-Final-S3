package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.example.demo.model.enums.ProductTypeEnum;

@Entity
@Getter
@Setter
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type", nullable = false)
    private ProductTypeEnum majorType;
}
