package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salesPerson", nullable = false)
    private String salesPerson;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "listProducts", nullable = false)
    private List<Product> listProducts;

    @Column(name = "date", nullable = false)
    private String date;

    public Sales(String salesPerson, BigDecimal price, String listProducts, String date) {
        this.salesPerson = salesPerson;
        this.price = price;

        this.date = date;
    }


}
