package com.example.demo.model.entity;

import com.example.demo.model.enums.ProductTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_type")
// Essa classe é uma entidade que representa um tipo de produto no banco de dados
public class ProductType implements Serializable {
    // Campos:
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ProductTypeEnum majorType;

    public ProductType(String name, ProductTypeEnum majorType) {
        this.name = name;
        this.majorType = majorType;
    }
}
